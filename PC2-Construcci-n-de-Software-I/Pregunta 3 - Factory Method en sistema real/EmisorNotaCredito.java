public class EmisorNotaCredito extends EmisorComprobante {
    @Override
    protected Comprobante crearComprobante(String ruc, double monto) {
        return new NotaCredito(ruc, monto);
    }
}

class NotaCredito extends Comprobante {
    public NotaCredito(String ruc, double monto) {
        super(ruc, monto);
    }

    @Override
    public void procesar() {
        System.out.println("Emitiendo NOTA DE CRÉDITO | RUC: " + ruc + " | Monto: " + monto);
    }
}
