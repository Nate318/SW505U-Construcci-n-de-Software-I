package pe.empresa.pedidos.impuesto;

import pe.empresa.pedidos.Configuracion;

public class ImpuestoArequipa implements CalculadoraImpuesto {
    private final double tasa;

    public ImpuestoArequipa(Configuracion configuracion) {
        this.tasa = configuracion.getDouble("impuesto.arequipa");
    }

    @Override
    public double calcular(double monto) {
        return monto * tasa;
    }
}
