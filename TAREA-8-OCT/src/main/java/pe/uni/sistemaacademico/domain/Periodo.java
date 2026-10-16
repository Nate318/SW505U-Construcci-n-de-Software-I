package pe.uni.sistemaacademico.domain;

public class Periodo {
    private final String codigo;
    private final String descripcion;

    public Periodo(String codigo, String descripcion) {
        this.codigo = exigirTexto(codigo, "El código del período es obligatorio.");
        this.descripcion = exigirTexto(descripcion, "La descripción del período es obligatoria.");
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private static String exigirTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return codigo + " - " + descripcion;
    }
}