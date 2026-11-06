package pe.empresa.pedidos;

import pe.empresa.pedidos.domain.*;
import pe.empresa.pedidos.impuesto.*;
import pe.empresa.pedidos.notificacion.*;
import pe.empresa.pedidos.pago.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuracion config = new Configuracion();

        Pedido pedido1 = new Pedido(
                new DescuentoVip(),
                new PagoYape(),
                new ImpuestoLima(config),
                new NotificadorEmail());
        pedido1.procesar(200.0);

        // Ejercicios: PagoPlin y DescuentoBlackFriday sin tocar Pedido
        Pedido pedido2 = new Pedido(
                new DescuentoBlackFriday(),
                new PagoPlin(),
                new ImpuestoSelva(config),
                new NotificadorWhatsApp());
        pedido2.procesar(200.0);
    }
}
