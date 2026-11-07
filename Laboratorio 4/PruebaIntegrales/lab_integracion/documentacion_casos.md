# Documentación de casos de prueba de integración

| Campo | Valor |
|---|---|
| ID | CI-001 |
| Tipo | Stub |
| Componentes integrados | ServicioPedidos + StubNotificador |
| Descripción | Crear un pedido válido y verificar que se retorna un ID, usando un stub que no hace nada |
| Precondición | Repositorio con BD en memoria inicializada |
| Datos de entrada | cliente="Ana", total=150.0 |
| Resultado esperado | Retorna un entero > 0 |
| Resultado actual | Retorna un entero > 0 (ID = 1) |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CI-002 |
| Tipo | Mock |
| Componentes integrados | ServicioPedidos + MockNotificador |
| Descripción | Verificar que al crear un pedido, el notificador recibe exactamente (cliente, pedido_id) |
| Precondición | Repositorio con BD en memoria |
| Datos de entrada | cliente="Luis", total=200.0 |
| Resultado esperado | enviar_confirmacion llamado una vez con ("Luis", id_retornado) |
| Resultado actual | enviar_confirmacion llamado una vez con ("Luis", 1) |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CI-003 |
| Tipo | Base de datos real |
| Componentes integrados | ServicioPedidos + RepositorioPedidos (SQLite) |
| Descripción | Crear un pedido y recuperarlo de la BD verificando que los datos persisten correctamente |
| Precondición | BD SQLite en memoria con tabla pedidos creada |
| Datos de entrada | cliente="María", total=300.0 |
| Resultado esperado | El registro recuperado tiene cliente="María", total=300.0, estado="pendiente" |
| Resultado actual | Registro recuperado: (1, "María", 300.0, "pendiente") |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CI-004 |
| Tipo | Base de datos temporal (archivo) |
| Componentes integrados | RepositorioPedidos + SQLite (archivo temporal) |
| Descripción | Verificar que el repositorio funciona con una BD en disco y persiste entre conexiones |
| Precondición | Archivo de BD temporal creado por tmp_path |
| Datos de entrada | cliente="Pedro", total=50.0 |
| Resultado esperado | Al cerrar y reabrir conexión, el registro sigue existiendo |
| Resultado actual | Con una nueva instancia del repositorio, el registro sigue existiendo (cliente="Pedro") |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CI-005 |
| Tipo | Integración con error |
| Componentes integrados | ServicioPedidos + RepositorioPedidos |
| Descripción | Total inválido no debe llegar al repositorio ni al notificador |
| Precondición | Mock del repositorio y mock del notificador |
| Datos de entrada | total=0 |
| Resultado esperado | ValueError; repositorio.guardar NO llamado; notificador NO llamado |
| Resultado actual | ValueError "El total debe ser mayor a cero"; guardar y enviar_confirmacion no fueron llamados |
| Estado | Aprobado |

# Respuesta breve

CI-002 (mock) verifica el contrato entre ServicioPedidos y el notificador: que se llame una sola vez con (“Luis”, id). No ejecuta SQL real, así que no detectaría errores de consulta, esquema o tipos.
CI-003 (BD real) verifica que el dato se guarda y se recupera con cliente, total y estado “pendiente”. Con un stub no detectaría que el notificador no se llamó o recibió argumentos incorrectos.
Resultados: los 5 casos pasaron y la cobertura de app/ fue 91%; repositorio_pedidos.py y servicio_pedidos.py llegaron al 100%, y notificador.py quedó en 0% porque siempre se reemplaza por stub o mock.
Al ejecutar el código original de la guía, CI-001, CI-002 y CI-003 fallaron con “no such table: pedidos”, porque cada sqlite3.connect(“:memory:”) crea una BD nueva. Se corrigió reutilizando una sola conexión en memoria, y con eso pasaron.
