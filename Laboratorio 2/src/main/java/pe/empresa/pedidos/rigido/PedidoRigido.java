package pe.empresa.pedidos.rigido;

// FASE 1: código rígido original (solo para analizar, no se usa)
public class PedidoRigido {
    public double calcularTotal(String tipoCliente, double subtotal, String metodoPago) {
        double total = subtotal;
        if (tipoCliente.equals("regular")) {
            // sin descuento
        } else if (tipoCliente.equals("vip")) {
            total = total * 0.85;
        } else if (tipoCliente.equals("navidad")) {
            total = total * 0.80;
        }
        if (metodoPago.equals("tarjeta")) {
            System.out.println("Cobrando S/ " + total + " con tarjeta");
        } else if (metodoPago.equals("yape")) {
            System.out.println("Cobrando S/ " + total + " con Yape");
        } else if (metodoPago.equals("efectivo")) {
            System.out.println("Cobrando S/ " + total + " en efectivo");
        }
        return total;
    }
}
