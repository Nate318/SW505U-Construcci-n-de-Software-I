package pe.empresa.pedidos.impuesto;

import pe.empresa.pedidos.Configuracion;

public class ImpuestoSelva implements CalculadoraImpuesto {
    private final double tasa;

    public ImpuestoSelva(Configuracion configuracion) {
        this.tasa = configuracion.getDouble("impuesto.selva");
    }

    @Override
    public double calcular(double monto) {
        return monto * tasa;
    }
}
