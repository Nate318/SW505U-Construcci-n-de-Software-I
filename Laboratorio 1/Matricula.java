import java.util.ArrayList;

public class Matricula {
    private int codMatricula;
    private Alumno alumno;
    private ArrayList<Curso> cursos;

    public Matricula(int codMatricula, Alumno alumno) {
        this.codMatricula = codMatricula;
        this.alumno = alumno;
        this.cursos = new ArrayList<>();
    }

    public int getCodMatricula() { return codMatricula; }
    public Alumno getAlumno() { return alumno; }

    // Devuelve true si se pudo agregar el curso
    public boolean agregarCurso(Curso curso) {
        if (!alumno.puedeMatricularse()) {
            System.out.println("El alumno no puede matricularse (estado: " + alumno.getEstado() + ")");
            return false;
        }
        if (cursos.contains(curso)) {
            System.out.println("El curso " + curso.getNombre() + " ya está matriculado");
            return false;
        }
        cursos.add(curso);
        return true;
    }

    public int totalCreditos() {
        int total = 0;
        for (Curso c : cursos) {
            total += c.getCreditos();
        }
        return total;
    }

    public void mostrar() {
        System.out.println("Matrícula N° " + codMatricula);
        System.out.println("Alumno: " + alumno);
        for (Curso c : cursos) {
            System.out.println("  - " + c);
        }
        System.out.println("Total de créditos: " + totalCreditos());
    }
}
