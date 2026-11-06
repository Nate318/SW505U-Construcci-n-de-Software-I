package pe.empresa.pedidos.notificacion;

public class NotificadorWhatsApp implements Notificador {
    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación por WhatsApp: " + mensaje);
    }
}
