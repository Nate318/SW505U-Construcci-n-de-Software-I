// Clase Matricula - relaciona un alumno con sus cursos
public class Matricula {

    private int codMatricula;
    private Alumno alumno;
    private Curso[] cursos;
    private int cantidadCursos;
    private String periodo; // ej: "2026-2"

    // Constructor - el arreglo tiene un máximo de 8 cursos
    public Matricula(int codMatricula, Alumno alumno, String periodo) {
        this.codMatricula = codMatricula;
        this.alumno = alumno;
        this.periodo = periodo;
        this.cursos = new Curso[8];
        this.cantidadCursos = 0;
    }

    // Agrega un curso a la matrícula
    public boolean agregarCurso(Curso curso) {
        if (cantidadCursos >= cursos.length) {
            System.out.println("No se puede agregar más cursos, límite alcanzado.");
            return false;
        }
        cursos[cantidadCursos] = curso;
        cantidadCursos++;
        return true;
    }

    // Getters
    public int getCodMatricula() {
        return codMatricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getCantidadCursos() {
        return cantidadCursos;
    }

    // Calcula el total de créditos matriculados
    public int getTotalCreditos() {
        int total = 0;
        for (int i = 0; i < cantidadCursos; i++) {
            total += cursos[i].getCreditos();
        }
        return total;
    }

    // Muestra el resumen de la matrícula
    public void mostrarMatricula() {
        System.out.println("========================================");
        System.out.println("    MATRÍCULA N° " + codMatricula);
        System.out.println("    Período: " + periodo);
        System.out.println("========================================");
        System.out.println("Alumno  : " + alumno.getNombres() + " " + alumno.getApellidos());
        System.out.println("Código  : " + alumno.getCodigo());
        System.out.println("Estado  : " + alumno.getEstadoTexto());
        System.out.println("----------------------------------------");
        System.out.println("Cursos matriculados:");
        for (int i = 0; i < cantidadCursos; i++) {
            System.out.println("  " + (i + 1) + ". " + cursos[i].getNombre()
                    + " (" + cursos[i].getCreditos() + " créditos)"
                    + " - Docente: " + cursos[i].getDocente().getNombres()
                    + " " + cursos[i].getDocente().getApellidos());
        }
        System.out.println("----------------------------------------");
        System.out.println("Total de créditos: " + getTotalCreditos());
        System.out.println("========================================");
    }
}
