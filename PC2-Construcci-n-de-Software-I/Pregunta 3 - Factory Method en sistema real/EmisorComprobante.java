public abstract class EmisorComprobante {
    protected abstract Comprobante crearComprobante(String ruc, double monto);

    public void emitir(String ruc, double monto) {
        Comprobante comprobante = crearComprobante(ruc, monto);
        comprobante.procesar();
    }
}
