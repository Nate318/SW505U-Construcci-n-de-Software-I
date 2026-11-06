public class Docente {
    private int codigo;
    private String nombres;
    private String especialidad;

    public Docente(int codigo, String nombres, String especialidad) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.especialidad = especialidad;
    }

    public int getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getEspecialidad() { return especialidad; }

    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return nombres + " (" + especialidad + ")";
    }
}
