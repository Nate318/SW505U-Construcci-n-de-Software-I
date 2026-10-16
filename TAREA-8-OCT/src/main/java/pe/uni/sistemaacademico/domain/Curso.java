package pe.uni.sistemaacademico.domain;

public class Curso {
    private final String codigo;
    private final String nombre;
    private final Docente docente;
    private final int creditos;

    public Curso(String codigo, String nombre, Docente docente, int creditos) {
        this.codigo = exigirTexto(codigo, "El código del curso es obligatorio.");
        this.nombre = exigirTexto(nombre, "El nombre del curso es obligatorio.");
        if (docente == null) {
            throw new IllegalArgumentException("El curso debe tener un docente registrado.");
        }
        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser mayores que cero.");
        }
        this.docente = docente;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public int getCreditos() {
        return creditos;
    }

    private static String exigirTexto(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | Docente: " + docente.getNombre()
                + " | Créditos: " + creditos;
    }
}