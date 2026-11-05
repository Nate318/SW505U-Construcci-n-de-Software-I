// Clase Alumno - encapsula los datos del estudiante
public class Alumno {

    // Atributos privados (encapsulación)
    private int codigo;
    private String nombres;
    private String apellidos;
    private String correo;
    private int cicloRelativo;
    // Estados: 1=Regular, 2=Egresado, 3=Bachiller, 4=Suspendido
    private int estado;

    // Constructor
    public Alumno(int codigo, String nombres, String apellidos, String correo, int cicloRelativo, int estado) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cicloRelativo = cicloRelativo;
        this.estado = estado;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public int getCicloRelativo() {
        return cicloRelativo;
    }

    public int getEstado() {
        return estado;
    }

    // Setters
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCicloRelativo(int cicloRelativo) {
        this.cicloRelativo = cicloRelativo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    // Devuelve el estado en texto
    public String getEstadoTexto() {
        switch (estado) {
            case 1: return "Regular";
            case 2: return "Egresado";
            case 3: return "Bachiller";
            case 4: return "Suspendido";
            default: return "Desconocido";
        }
    }

    // Muestra la info del alumno
    public void mostrarInfo() {
        System.out.println("--- Alumno ---");
        System.out.println("Código     : " + codigo);
        System.out.println("Nombres    : " + nombres + " " + apellidos);
        System.out.println("Correo     : " + correo);
        System.out.println("Ciclo      : " + cicloRelativo);
        System.out.println("Estado     : " + getEstadoTexto());
    }
}
