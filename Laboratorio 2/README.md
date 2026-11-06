# Laboratorio 2 - Estructura de paquetes
- Main.java: arma el sistema eligiendo qué implementaciones usar.
- Configuracion.java: lee application.properties.
- domain/: Pedido (recibe sus colaboradores por constructor) y las estrategias de descuento.
- pago/: interfaz MetodoPago y sus clases (Tarjeta, Yape, Efectivo, Plin).
- notificacion/: interfaz Notificador y sus clases (Email, SMS, WhatsApp).
- impuesto/: interfaz CalculadoraImpuesto y una clase por región (Lima, Arequipa, Selva).
- resources/application.properties: valores externalizados (tasas de impuesto, URL, umbral VIP).
- Mecanismos usados: polimorfismo, Strategy, inyección de dependencias y configuración.
- Agregar una variante nueva = crear 1 clase y cambiar una línea en Main.
