public class Main {
    public static void main(String[] args) {
        Docente d1 = new Docente(1, "Juan Herencia", "Ingeniería de Software");
        Docente d2 = new Docente(2, "Ana Torres", "Bases de Datos");

        Curso c1 = new Curso("SW505", "Construcción de Software I", 4, d1);
        Curso c2 = new Curso("SW506", "Bases de Datos II", 3, d2);

        Alumno a1 = new Alumno(20230001, "Luis", "Pérez", 6);
        Alumno a2 = new Alumno(20230002, "María", "Gómez", 6);
        a2.setEstado(EstadoAlumno.SUSPENDIDO);

        Matricula m1 = new Matricula(1, a1);
        m1.agregarCurso(c1);
        m1.agregarCurso(c2);
        m1.agregarCurso(c1); // repetido, debe rechazarse
        m1.mostrar();

        System.out.println();
        Matricula m2 = new Matricula(2, a2);
        m2.agregarCurso(c1); // suspendido, debe rechazarse
    }
}
