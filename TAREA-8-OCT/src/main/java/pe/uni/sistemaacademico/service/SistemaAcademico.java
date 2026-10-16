package pe.uni.sistemaacademico.service;

import pe.uni.sistemaacademico.domain.Curso;
import pe.uni.sistemaacademico.domain.DetalleMatricula;
import pe.uni.sistemaacademico.domain.Docente;
import pe.uni.sistemaacademico.domain.Estudiante;
import pe.uni.sistemaacademico.domain.Matricula;
import pe.uni.sistemaacademico.domain.Periodo;
import pe.uni.sistemaacademico.strategy.EstrategiaPromedio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SistemaAcademico {
    private final Map<String, Estudiante> estudiantes = new LinkedHashMap<>();
    private final Map<String, Docente> docentes = new LinkedHashMap<>();
    private final Map<String, Curso> cursos = new LinkedHashMap<>();
    private final Map<String, Periodo> periodos = new LinkedHashMap<>();
    private final Map<String, Matricula> matriculas = new LinkedHashMap<>();

    public void registrarAlumno(String codigo, String nombre) {
        registrarUnico(estudiantes, codigo, new Estudiante(codigo, nombre), "alumno");
    }

    public void registrarDocente(String codigo, String nombre) {
        registrarUnico(docentes, codigo, new Docente(codigo, nombre), "docente");
    }

    public void registrarCurso(String codigo, String nombre, String codigoDocente, int creditos) {
        Docente docente = buscar(docentes, codigoDocente, "docente");
        registrarUnico(cursos, codigo, new Curso(codigo, nombre, docente, creditos), "curso");
    }

    public void registrarPeriodo(String codigo, String descripcion) {
        registrarUnico(periodos, codigo, new Periodo(codigo, descripcion), "período");
    }

    public void matricular(String codigoAlumno, String codigoCurso, String codigoPeriodo) {
        Estudiante estudiante = buscar(estudiantes, codigoAlumno, "alumno");
        Curso curso = buscar(cursos, codigoCurso, "curso");
        Periodo periodo = buscar(periodos, codigoPeriodo, "período");
        String clave = claveMatricula(estudiante.getCodigo(), periodo.getCodigo());
        Matricula matricula = matriculas.get(clave);
        boolean nueva = matricula == null;
        if (nueva) {
            matricula = new Matricula(estudiante, periodo);
        }
        matricula.agregarCurso(curso);
        if (nueva) {
            matriculas.put(clave, matricula);
        }
    }

    public void registrarNota(String codigoAlumno, String codigoCurso, String codigoPeriodo, double nota) {
        Estudiante estudiante = buscar(estudiantes, codigoAlumno, "alumno");
        Periodo periodo = buscar(periodos, codigoPeriodo, "período");
        Matricula matricula = matriculas.get(claveMatricula(estudiante.getCodigo(), periodo.getCodigo()));
        if (matricula == null) {
            throw new IllegalStateException("No existe una matrícula del alumno en ese período.");
        }
        DetalleMatricula detalle = matricula.buscarDetalle(codigoCurso);
        detalle.registrarNota(nota);
    }

    public List<Estudiante> listarAlumnos() {
        return List.copyOf(estudiantes.values());
    }

    public List<Docente> listarDocentes() {
        return List.copyOf(docentes.values());
    }

    public List<Curso> listarCursos() {
        return List.copyOf(cursos.values());
    }

    public List<Matricula> listarMatriculasPorPeriodo(String codigoPeriodo) {
        Periodo periodo = buscar(periodos, codigoPeriodo, "período");
        return matriculas.values().stream()
                .filter(matricula -> matricula.getPeriodo().getCodigo().equals(periodo.getCodigo()))
                .toList();
    }

    public List<Matricula> historialPorAlumno(String codigoAlumno) {
        Estudiante estudiante = buscar(estudiantes, codigoAlumno, "alumno");
        return matriculas.values().stream()
                .filter(matricula -> matricula.getEstudiante().getCodigo().equals(estudiante.getCodigo()))
                .toList();
    }

    public double calcularPromedio(String codigoAlumno, String codigoPeriodo,
                                   EstrategiaPromedio estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("La estrategia de promedio es obligatoria.");
        }
        Estudiante estudiante = buscar(estudiantes, codigoAlumno, "alumno");
        Periodo periodo = buscar(periodos, codigoPeriodo, "período");
        Matricula matricula = matriculas.get(claveMatricula(estudiante.getCodigo(), periodo.getCodigo()));
        if (matricula == null) {
            throw new IllegalStateException("No existe una matrícula del alumno en ese período.");
        }
        return estrategia.calcular(matricula.getDetalles());
    }

    private static <T> void registrarUnico(Map<String, T> registros, String codigo, T entidad, String tipo) {
        String clave = normalizarCodigo(codigo);
        if (registros.containsKey(clave)) {
            throw new IllegalStateException("Ya existe un " + tipo + " con ese código.");
        }
        registros.put(clave, entidad);
    }

    private static <T> T buscar(Map<String, T> registros, String codigo, String tipo) {
        T entidad = registros.get(normalizarCodigo(codigo));
        if (entidad == null) {
            throw new IllegalArgumentException("No existe un " + tipo + " con código " + codigo + ".");
        }
        return entidad;
    }

    private static String claveMatricula(String codigoAlumno, String codigoPeriodo) {
        return normalizarCodigo(codigoAlumno) + "|" + normalizarCodigo(codigoPeriodo);
    }

    private static String normalizarCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }
        return codigo.trim().toUpperCase();
    }
}