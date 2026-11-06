package pe.empresa.pedidos.notificacion;

// PUNTO DE VARIACIÓN: canal de notificación (email, SMS, WhatsApp).
// Mecanismo: polimorfismo (interfaz) + DI en Pedido.
public interface Notificador {
    void notificar(String mensaje);
}
