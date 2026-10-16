public class CalculoRUS implements EstrategiaCalculoTributario {
    @Override
    public double calcular(double base) {
        return base * 0.01;
    }
}
