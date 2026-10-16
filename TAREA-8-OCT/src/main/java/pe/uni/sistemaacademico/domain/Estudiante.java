package pe.uni.sistemaacademico.domain;

public class Estudiante {
    private final String codigo;
    private final String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = exigirTexto(codigo, "El código del alumno es obligatorio.");
        this.nombre = exigirTexto(nombre, "El nombre del alumno es obligatorio.");
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