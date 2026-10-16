public class EmisorFactura extends EmisorComprobante {
    @Override
    protected Comprobante crearComprobante(String ruc, double monto) {
        return new Factura(ruc, monto);
    }
}

class Factura extends Comprobante {
    public Factura(String ruc, double monto) {
        super(ruc, monto);
    }

    @Override
    public void procesar() {
        System.out.println("Emitiendo FACTURA | RUC: " + ruc + " | Monto: " + monto);
    }
}
