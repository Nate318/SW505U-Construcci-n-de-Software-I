public class Cliente {
    public static void main(String[] args) {
        FachadaAperturaCuenta fachada = new FachadaAperturaCuenta();
        fachada.abrirCuenta("12345678", "Ana Torres");
    }
}
