package pe.uni.sistemaacademico.domain;

public class DetalleMatricula {
    private final Curso curso;
    private Double nota;

    public DetalleMatricula(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso es obligatorio.");
        }
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public Double getNota() {
        return nota;
    }

    public void registrarNota(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 20) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 20.");
        }
        this.nota = nota;
    }
}