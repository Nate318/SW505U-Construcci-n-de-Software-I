package pe.empresa.pedidos.domain;

public class SinDescuento implements EstrategiaDescuento {
    private static final double FACTOR = 1.0;

    @Override
    public double aplicar(double subtotal) {
        return subtotal * FACTOR;
    }

    @Override
    public String descripcion() {
        return "Sin descuento";
    }
}
