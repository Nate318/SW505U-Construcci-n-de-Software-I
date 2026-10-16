public class Main {
    public static void main(String[] args) {
        EmisorComprobante emisorBoleta = new EmisorBoleta();
        emisorBoleta.emitir("20123456789", 250.50);

        EmisorComprobante emisorFactura = new EmisorFactura();
        emisorFactura.emitir("20123456789", 1200.00);

        EmisorComprobante emisorNotaCredito = new EmisorNotaCredito();
        emisorNotaCredito.emitir("20123456789", 100.00);
    }
}
