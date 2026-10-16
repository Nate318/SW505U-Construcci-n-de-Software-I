package pe.uni.sistemaacademico.domain;

public class Docente {
    private final String codigo;
    private final String nombre;

    public Docente(String codigo, String nombre) {
        this.codigo = exigirTexto(codigo, "El código del docente es obligatorio.");
        this.nombre = exigirTexto(nombre, "El nombre del docente es obligatorio.");
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    private static String exigirTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}