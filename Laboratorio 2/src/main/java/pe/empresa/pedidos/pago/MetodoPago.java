package pe.empresa.pedidos.pago;

// PUNTO DE VARIACIÓN: método de pago.
// Mecanismo: polimorfismo (interfaz). Agregar un método nuevo = 1 archivo nuevo, 0 modificados.
public interface MetodoPago {
    void procesar(double monto);

    String nombre();
}
