public abstract class Comprobante {
    protected String ruc;
    protected double monto;

    public Comprobante(String ruc, double monto) {
        this.ruc = ruc;
        this.monto = monto;
    }

    public abstract void procesar();
}
