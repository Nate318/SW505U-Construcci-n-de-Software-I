package pe.empresa.pedidos.impuesto;

import pe.empresa.pedidos.Configuracion;

public class ImpuestoLima implements CalculadoraImpuesto {
    private final double tasa;

    public ImpuestoLima(Configuracion configuracion) {
        this.tasa = configuracion.getDouble("impuesto.lima");
    }

    @Override
    public double calcular(double monto) {
        return monto * tasa;
    }
}
