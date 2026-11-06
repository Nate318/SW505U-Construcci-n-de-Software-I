# Respuestas del Laboratorio 2

## Fase 0
Con el if/else de pagos, agregar criptomonedas obliga a modificar la clase que tiene el if (1 archivo)
y los tests de esa clase hay que revisarlos, porque ahora hay una rama más.

## Fase 1 - Preguntas guía
1. Hay 2 puntos de variación: el descuento según tipo de cliente y el método de pago.
2. Descuento Black Friday: hay que modificar PedidoRigido y agregar otro else if.
3. Plin: igual, se modifica PedidoRigido y se agrega otro else if.
4. VIP de 15% a 20%: se modifica PedidoRigido (el número 0.85 está escrito dentro del método).
5. Umbral VIP por monto: se modifica PedidoRigido y la lógica se complica más.
En todos los casos se toca la misma clase, por eso es código rígido.

## Fase 2
Agregar PagoPlin costó 1 archivo nuevo y 0 modificados.

## Fase 3 - Preguntas guía
- Pedido gana flexibilidad: no depende de clases concretas, solo de interfaces.
- Para testear Pedido se le pasa un mock (doble de prueba) de MetodoPago y de Notificador, así no se usa una pasarela real.
- Polimorfismo simple cambia una operación; en Strategy el objeto completo representa un algoritmo intercambiable.
- DescuentoBlackFriday se creó sin modificar Pedido; en Main solo cambia la línea del new.

## Fase 4 - Preguntas guía
- QA puede cambiar el valor en application.properties sin recompilar.
- Poner credenciales en el código es riesgoso porque quedan visibles en el repositorio.
