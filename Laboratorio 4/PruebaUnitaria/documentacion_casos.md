# Documentación de casos de prueba

| Campo | Valor |
|---|---|
| ID | CP-001 |
| Tipo | Camino Normal |
| Descripción | Sumar dos enteros positivos |
| Precondición | Ninguna |
| Datos de entrada | a=2, b=3 |
| Resultado esperado | 5 |
| Resultado actual | 5 |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CP-002 |
| Tipo | Valor Límite |
| Descripción | Verificar edad exactamente en el límite (18) |
| Precondición | Ninguna |
| Datos de entrada | edad=18 |
| Resultado esperado | True |
| Resultado actual | True |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CP-003 |
| Tipo | Excepción |
| Descripción | Dividir por cero debe lanzar ValueError |
| Precondición | Ninguna |
| Datos de entrada | a=10, b=0 |
| Resultado esperado | ValueError con mensaje "No se puede dividir por cero" |
| Resultado actual | ValueError con mensaje "No se puede dividir por cero" |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CP-004 |
| Tipo | Entrada Inválida |
| Descripción | Edad negativa debe lanzar ValueError |
| Precondición | Ninguna |
| Datos de entrada | edad=-5 |
| Resultado esperado | ValueError con mensaje "La edad no puede ser negativa" |
| Resultado actual | ValueError con mensaje "La edad no puede ser negativa" |
| Estado | Aprobado |

| Campo | Valor |
|---|---|
| ID | CP-005 |
| Tipo | Parametrizada (múltiples entradas) |
| Descripción | Sumar varios pares de números |
| Precondición | Ninguna |
| Datos de entrada | (1,1)→2; (-1,1)→0; (0,0)→0; (100,200)→300 |
| Resultado esperado | Los valores indicados |
| Resultado actual | Los valores indicados |
| Estado | Aprobado |

# Respuesta breve

Si se elimina el test de edad negativa (CP-004), quedaría sin cubrir la línea 18 de `calculadora.py`: `raise ValueError("La edad no puede ser negativa")`, porque ningún test entra al `if edad < 0`.
En el reporte actual la cobertura es 90% (10 sentencias, 1 sin cubrir: la línea 11, `return a / b`).
Sin ese test habría 2 líneas sin cubrir (11 y 18) y la cobertura bajaría a 80%; la línea 18 aparecería en rojo en `htmlcov/calculadora_py.html`.
