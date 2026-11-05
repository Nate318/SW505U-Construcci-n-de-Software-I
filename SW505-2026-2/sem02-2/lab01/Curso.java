// Clase Curso - encapsula los datos de un curso
public class Curso {

    private int codigo;
    private String nombre;
    private int creditos;
    private int ciclo;
    private Docente docente;

    // Constructor
    public Curso(int codigo, String nombre, int creditos, int ciclo, Docente docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.ciclo = ciclo;
        this.docente = docente;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getCiclo() {
        return ciclo;
    }

    public Docente getDocente() {
        return docente;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    // Muestra info del curso
    public void mostrarInfo() {
        System.out.println("--- Curso ---");
        System.out.println("Código   : " + codigo);
        System.out.println("Nombre   : " + nombre);
        System.out.println("Créditos : " + creditos);
        System.out.println("Ciclo    : " + ciclo);
        System.out.println("Docente  : " + docente.getNombres() + " " + docente.getApellidos());
    }
}
