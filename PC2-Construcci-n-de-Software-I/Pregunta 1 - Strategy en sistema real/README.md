# Pregunta 1 - Strategy en sistema real

Este ejercicio usa el patrón Strategy para cambiar la forma de calcular impuestos según el régimen tributario.

## Regímenes

- RUS: 1% de la base
- RER: 18% de la base
- General: 18% + 2% sobre el total

La clase `Factura` usa la estrategia correcta según el régimen que se le pase.
