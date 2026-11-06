package pe.empresa.pedidos.domain;

public class DescuentoBlackFriday implements EstrategiaDescuento {
    private static final double FACTOR = 0.70;

    @Override
    public double aplicar(double subtotal) {
        return subtotal * FACTOR;
    }

    @Override
    public String descripcion() {
        return "Black Friday 30%";
    }
}
