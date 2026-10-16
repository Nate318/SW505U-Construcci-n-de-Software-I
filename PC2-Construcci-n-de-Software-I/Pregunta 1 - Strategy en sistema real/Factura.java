public class Factura {
    private EstrategiaCalculoTributario estrategia;
    private double base;

    public Factura(String regimen, double base) {
        this.base = base;

        switch (regimen) {
            case "RUS":
                estrategia = new CalculoRUS();
                break;
            case "RER":
                estrategia = new CalculoRER();
                break;
            default:
                estrategia = new CalculoGeneral();
                break;
        }
    }

    public double calcularImpuesto() {
        return estrategia.calcular(base);
    }
}
