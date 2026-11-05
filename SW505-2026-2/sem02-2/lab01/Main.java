// Clase principal - aquí se prueba el sistema académico
public class Main {

    public static void main(String[] args) {

        // Crear docentes
        Docente doc1 = new Docente(1, "Carlos", "Ramírez", "Ingeniería de Software", "c.ramirez@universidad.edu");
        Docente doc2 = new Docente(2, "María", "López", "Base de Datos", "m.lopez@universidad.edu");
        Docente doc3 = new Docente(3, "Jorge", "Mendoza", "Redes y Comunicaciones", "j.mendoza@universidad.edu");

        System.out.println("=== DOCENTES REGISTRADOS ===");
        doc1.mostrarInfo();
        System.out.println();
        doc2.mostrarInfo();
        System.out.println();
        doc3.mostrarInfo();
        System.out.println();

        // Crear cursos
        Curso c1 = new Curso(101, "Construcción de Software I", 4, 6, doc1);
        Curso c2 = new Curso(102, "Base de Datos II", 4, 6, doc2);
        Curso c3 = new Curso(103, "Redes de Computadoras", 3, 6, doc3);
        Curso c4 = new Curso(104, "Matemática Discreta", 3, 6, doc1);

        System.out.println("=== CURSOS REGISTRADOS ===");
        c1.mostrarInfo();
        System.out.println();
        c2.mostrarInfo();
        System.out.println();

        // Crear alumnos
        // Estado: 1=Regular, 2=Egresado, 3=Bachiller, 4=Suspendido
        Alumno a1 = new Alumno(20231001, "Pedro", "García Torres", "pedro.garcia@uni.edu", 6, 1);
        Alumno a2 = new Alumno(20231002, "Lucía", "Flores Huanca", "lucia.flores@uni.edu", 6, 1);
        Alumno a3 = new Alumno(20231003, "Miguel", "Quispe Ramos", "miguel.quispe@uni.edu", 5, 4);

        System.out.println("=== ALUMNOS REGISTRADOS ===");
        a1.mostrarInfo();
        System.out.println();
        a2.mostrarInfo();
        System.out.println();
        a3.mostrarInfo();
        System.out.println();

        // Crear matrículas
        Matricula m1 = new Matricula(1, a1, "2026-2");
        m1.agregarCurso(c1);
        m1.agregarCurso(c2);
        m1.agregarCurso(c3);
        m1.agregarCurso(c4);

        Matricula m2 = new Matricula(2, a2, "2026-2");
        m2.agregarCurso(c1);
        m2.agregarCurso(c3);

        // Alumno suspendido intenta matricularse (igual se puede registrar, pero se ve el estado)
        Matricula m3 = new Matricula(3, a3, "2026-2");
        m3.agregarCurso(c2);

        System.out.println("=== MATRÍCULAS REGISTRADAS ===");
        m1.mostrarMatricula();
        System.out.println();
        m2.mostrarMatricula();
        System.out.println();
        m3.mostrarMatricula();
    }
}
