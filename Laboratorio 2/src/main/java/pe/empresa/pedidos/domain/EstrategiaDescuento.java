package pe.empresa.pedidos.domain;

// PUNTO DE VARIACIÓN: política de descuento.
// Mecanismo: Strategy (cada clase es un algoritmo completo e intercambiable).
public interface EstrategiaDescuento {
    double aplicar(double subtotal);

    String descripcion();
}
