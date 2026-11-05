// Clase Docente - encapsula los datos del profesor
public class Docente {

    private int codigo;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String correo;

    // Constructor
    public Docente(int codigo, String nombres, String apellidos, String especialidad, String correo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.correo = correo;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    // Setters
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Muestra la info del docente
    public void mostrarInfo() {
        System.out.println("--- Docente ---");
        System.out.println("Código       : " + codigo);
        System.out.println("Nombres      : " + nombres + " " + apellidos);
        System.out.println("Especialidad : " + especialidad);
        System.out.println("Correo       : " + correo);
    }
}
