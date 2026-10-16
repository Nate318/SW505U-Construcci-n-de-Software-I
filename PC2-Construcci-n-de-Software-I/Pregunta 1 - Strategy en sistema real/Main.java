public class Main {
    public static void main(String[] args) {
        Factura facturaRUS = new Factura("RUS", 1000);
        Factura facturaRER = new Factura("RER", 1000);
        Factura facturaGeneral = new Factura("GENERAL", 1000);

        System.out.println("RUS: " + facturaRUS.calcularImpuesto());
        System.out.println("RER: " + facturaRER.calcularImpuesto());
        System.out.println("GENERAL: " + facturaGeneral.calcularImpuesto());
    }
}
