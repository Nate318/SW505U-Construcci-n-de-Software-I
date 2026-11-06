package pe.empresa.pedidos.domain;

public class DescuentoVip implements EstrategiaDescuento {
    private static final double FACTOR = 0.85;

    @Override
    public double aplicar(double subtotal) {
        return subtotal * FACTOR;
    }

    @Override
    public String descripcion() {
        return "VIP 15%";
    }
}
