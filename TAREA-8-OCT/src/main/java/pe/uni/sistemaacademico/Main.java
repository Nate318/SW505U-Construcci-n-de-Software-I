package pe.uni.sistemaacademico;

import pe.uni.sistemaacademico.domain.DetalleMatricula;
import pe.uni.sistemaacademico.domain.Matricula;
import pe.uni.sistemaacademico.service.SistemaAcademico;
import pe.uni.sistemaacademico.strategy.EstrategiaPromedio;
import pe.uni.sistemaacademico.strategy.PromedioPonderado;
import pe.uni.sistemaacademico.strategy.PromedioSimple;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final SistemaAcademico sistema = new SistemaAcademico();

    public static void main(String[] args) {
        new Main().iniciar();
    }

    private void iniciar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion;
            try {
                opcion = leerEntero("Seleccione una opción: ");
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
                System.out.println();
                continue;
            }
            try {
                switch (opcion) {
                    case 1 -> registrarAlumno();
                    case 2 -> registrarDocente();
                    case 3 -> registrarCurso();
                    case 4 -> registrarPeriodo();
                    case 5 -> matricularAlumno();
                    case 6 -> registrarNota();
                    case 7 -> mostrarLista(sistema.listarAlumnos());
                    case 8 -> mostrarLista(sistema.listarDocentes());
                    case 9 -> mostrarLista(sistema.listarCursos());
                    case 10 -> listarMatriculasPorPeriodo();
                    case 11 -> verHistorialAlumno();
                    case 12 -> verPromedioMatricula();
                    case 0 -> continuar = false;
                    default -> System.out.println("Opción no válida.");
                }
            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
            System.out.println();
        }
        System.out.println("Hasta luego.");
    }

    private void mostrarMenu() {
        System.out.println("=== SISTEMA ACADÉMICO ===");
        System.out.println("1. Registrar alumno");
        System.out.println("2. Registrar docente");
        System.out.println("3. Registrar curso");
        System.out.println("4. Registrar período");
        System.out.println("5. Matricular alumno");
        System.out.println("6. Registrar nota");
        System.out.println("7. Listar alumnos");
        System.out.println("8. Listar docentes");
        System.out.println("9. Listar cursos");
        System.out.println("10. Listar matrículas por período");
        System.out.println("11. Ver historial de un alumno");
        System.out.println("12. Ver promedio de una matrícula");
        System.out.println("0. Salir");
    }

    private void registrarAlumno() {
        sistema.registrarAlumno(leerTexto("Código del alumno: "), leerTexto("Nombre completo: "));
        System.out.println("Alumno registrado.");
    }

    private void registrarDocente() {
        sistema.registrarDocente(leerTexto("Código del docente: "), leerTexto("Nombre completo: "));
        System.out.println("Docente registrado.");
    }

    private void registrarCurso() {
        String codigo = leerTexto("Código del curso: ");
        String nombre = leerTexto("Nombre del curso: ");
        String codigoDocente = leerTexto("Código del docente: ");
        int creditos = leerEntero("Créditos: ");
        sistema.registrarCurso(codigo, nombre, codigoDocente, creditos);
        System.out.println("Curso registrado.");
    }

    private void registrarPeriodo() {
        sistema.registrarPeriodo(leerTexto("Código del período (por ejemplo, 2026-I): "),
                leerTexto("Descripción: "));
        System.out.println("Período registrado.");
    }

    private void matricularAlumno() {
        sistema.matricular(leerTexto("Código del alumno: "), leerTexto("Código del curso: "),
                leerTexto("Código del período: "));
        System.out.println("Matrícula registrada.");
    }

    private void registrarNota() {
        String codigoAlumno = leerTexto("Código del alumno: ");
        String codigoCurso = leerTexto("Código del curso: ");
        String codigoPeriodo = leerTexto("Código del período: ");
        sistema.registrarNota(codigoAlumno, codigoCurso, codigoPeriodo, leerDecimal("Nota (0 a 20): "));
        System.out.println("Nota registrada.");
    }

    private void listarMatriculasPorPeriodo() {
        List<Matricula> matriculas = sistema.listarMatriculasPorPeriodo(
                leerTexto("Código del período: "));
        if (matriculas.isEmpty()) {
            System.out.println("No hay matrículas registradas para ese período.");
            return;
        }
        matriculas.forEach(this::mostrarMatricula);
    }

    private void verHistorialAlumno() {
        List<Matricula> historial = sistema.historialPorAlumno(leerTexto("Código del alumno: "));
        if (historial.isEmpty()) {
            System.out.println("El alumno no tiene matrículas registradas.");
            return;
        }
        historial.forEach(this::mostrarMatricula);
    }

    private void verPromedioMatricula() {
        String codigoAlumno = leerTexto("Código del alumno: ");
        String codigoPeriodo = leerTexto("Código del período: ");
        System.out.println("1. Promedio simple");
        System.out.println("2. Promedio ponderado por créditos");
        EstrategiaPromedio estrategia = switch (leerEntero("Tipo de promedio: ")) {
            case 1 -> new PromedioSimple();
            case 2 -> new PromedioPonderado();
            default -> throw new IllegalArgumentException("Tipo de promedio no válido.");
        };
        System.out.printf("Promedio: %.2f%n",
                sistema.calcularPromedio(codigoAlumno, codigoPeriodo, estrategia));
    }

    private void mostrarMatricula(Matricula matricula) {
        System.out.printf("Alumno: %s | Período: %s%n",
                matricula.getEstudiante(), matricula.getPeriodo());
        for (DetalleMatricula detalle : matricula.getDetalles()) {
            String nota = detalle.getNota() == null ? "Pendiente"
                    : String.format("%.2f", detalle.getNota());
            System.out.printf("  Curso: %s | Docente: %s | Nota: %s%n",
                    detalle.getCurso(), detalle.getCurso().getDocente(), nota);
        }
    }

    private <T> void mostrarLista(List<T> elementos) {
        if (elementos.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        elementos.forEach(System.out::println);
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String valor = scanner.nextLine().trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El valor no puede estar vacío.");
        }
        return valor;
    }

    private int leerEntero(String mensaje) {
        try {
            return Integer.parseInt(leerTexto(mensaje));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Ingrese un número entero válido.");
        }
    }

    private double leerDecimal(String mensaje) {
        try {
            return Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Ingrese un número válido.");
        }
    }
}