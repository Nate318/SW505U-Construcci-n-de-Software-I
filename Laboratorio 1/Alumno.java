public class Alumno {
    private int codigo;
    private String nombres;
    private String apellidos;
    private int cicloRelativo;
    private EstadoAlumno estado;

    public Alumno(int codigo, String nombres, String apellidos, int cicloRelativo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cicloRelativo = cicloRelativo;
        this.estado = EstadoAlumno.REGULAR; // todo alumno nuevo es regular
    }

    public int getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public int getCicloRelativo() { return cicloRelativo; }
    public EstadoAlumno getEstado() { return estado; }

    public void setEstado(EstadoAlumno estado) { this.estado = estado; }

    // El ciclo solo puede subir, no tiene sentido bajarlo
    public void pasarAlSiguienteCiclo() {
        cicloRelativo++;
    }

    // Solo un alumno regular puede matricularse
    public boolean puedeMatricularse() {
        return estado == EstadoAlumno.REGULAR;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombres + " " + apellidos + " | Ciclo " + cicloRelativo + " | " + estado;
    }
}
