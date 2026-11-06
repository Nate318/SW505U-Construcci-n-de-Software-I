package pe.empresa.pedidos.notificacion;

public class NotificadorSms implements Notificador {
    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación por SMS: " + mensaje);
    }
}
