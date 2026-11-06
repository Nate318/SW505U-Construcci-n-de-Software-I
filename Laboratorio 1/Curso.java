public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;
    private Docente docente;

    public Curso(String codigo, String nombre, int creditos, Docente docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public Docente getDocente() { return docente; }

    public void setDocente(Docente docente) { this.docente = docente; }

    @Override
    public String toString() {
        return codigo + " " + nombre + " (" + creditos + " créditos) - Docente: " + docente;
    }
}
