package pe.empresa.pedidos.domain;

import pe.empresa.pedidos.impuesto.CalculadoraImpuesto;
import pe.empresa.pedidos.notificacion.Notificador;
import pe.empresa.pedidos.pago.MetodoPago;

// Contexto: no crea sus colaboradores, le llegan desde fuera.
// PUNTO DE VARIACIÓN: los 4 colaboradores. Mecanismo: inyección de dependencias por constructor.
public class Pedido {
    private final EstrategiaDescuento estrategia;
    private final MetodoPago metodoPago;
    private final CalculadoraImpuesto calculadoraImpuesto;
    private final Notificador notificador;

    public Pedido(EstrategiaDescuento estrategia, MetodoPago metodoPago,
                  CalculadoraImpuesto calculadoraImpuesto, Notificador notificador) {
        this.estrategia = estrategia;
        this.metodoPago = metodoPago;
        this.calculadoraImpuesto = calculadoraImpuesto;
        this.notificador = notificador;
    }

    public double procesar(double subtotal) {
        double conDescuento = estrategia.aplicar(subtotal);
        double impuesto = calculadoraImpuesto.calcular(conDescuento);
        double total = conDescuento + impuesto;

        metodoPago.procesar(total);
        notificador.notificar("Pedido confirmado. Total pagado: S/ " + total);
        return total;
    }
}
