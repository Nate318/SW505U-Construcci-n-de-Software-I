public class EmisorBoleta extends EmisorComprobante {
    @Override
    protected Comprobante crearComprobante(String ruc, double monto) {
        return new Boleta(ruc, monto);
    }
}

class Boleta extends Comprobante {
    public Boleta(String ruc, double monto) {
        super(ruc, monto);
    }

    @Override
    public void procesar() {
        System.out.println("Emitiendo BOLETA | RUC: " + ruc + " | Monto: " + monto);
    }
}
