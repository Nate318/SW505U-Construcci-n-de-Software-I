package pe.uni.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private final Estudiante estudiante;
    private final Periodo periodo;
    private final List<DetalleMatricula> detalles = new ArrayList<>();

    public Matricula(Estudiante estudiante, Periodo periodo) {
        if (estudiante == null || periodo == null) {
            throw new IllegalArgumentException("Alumno y período son obligatorios.");
        }
        this.estudiante = estudiante;
        this.periodo = periodo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public List<DetalleMatricula> getDetalles() {
        return List.copyOf(detalles);
    }

    public void agregarCurso(Curso curso) {
        boolean yaMatriculado = detalles.stream()
                .anyMatch(detalle -> detalle.getCurso().getCodigo().equals(curso.getCodigo()));
        if (yaMatriculado) {
            throw new IllegalStateException("El alumno ya está matriculado en ese curso y período.");
        }
        detalles.add(new DetalleMatricula(curso));
    }

    public DetalleMatricula buscarDetalle(String codigoCurso) {
        return detalles.stream()
                .filter(detalle -> detalle.getCurso().getCodigo().equals(codigoCurso))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("El alumno no está matriculado en ese curso."));
    }
}