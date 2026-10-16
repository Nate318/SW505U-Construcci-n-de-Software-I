public class FachadaAperturaCuenta {
    private ValidacionDNI validacionDNI;
    private ConsultaHistorial consultaHistorial;
    private GeneradorCuenta generadorCuenta;
    private ServicioFirmaDigital servicioFirmaDigital;
    private NotificadorCliente notificadorCliente;

    public FachadaAperturaCuenta() {
        validacionDNI = new ValidacionDNI();
        consultaHistorial = new ConsultaHistorial();
        generadorCuenta = new GeneradorCuenta();
        servicioFirmaDigital = new ServicioFirmaDigital();
        notificadorCliente = new NotificadorCliente();
    }

    public void abrirCuenta(String dni, String nombre) {
        validacionDNI.verificarDNI(dni);
        consultaHistorial.verificarDeudas(dni);

        String numeroCuenta = generadorCuenta.generarNumeroCuenta();
        System.out.println("Cuenta creada: " + numeroCuenta + " a nombre de " + nombre);

        servicioFirmaDigital.firmarContrato("Contrato de apertura");
        notificadorCliente.enviarSMSyCorreo(nombre);

        System.out.println("Apertura de cuenta completada para " + nombre + ".");
    }
}
