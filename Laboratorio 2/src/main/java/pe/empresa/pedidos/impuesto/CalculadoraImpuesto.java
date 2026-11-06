package pe.empresa.pedidos.impuesto;

// PUNTO DE VARIACIÓN: impuesto según región.
// Mecanismo: Strategy (una clase por región) + configuración (la tasa vive en application.properties).
public interface CalculadoraImpuesto {
    double calcular(double monto);
}
