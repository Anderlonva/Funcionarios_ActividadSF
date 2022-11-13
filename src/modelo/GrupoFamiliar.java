package modelo;

/**
 *
 * @author Anderson Londoño
 */
public class GrupoFamiliar {
    
   private int id;
   private String nombre;
   private String apellido;
   private String direccion;
   private Parentesco parentesco;

    public GrupoFamiliar() {
    }

    public GrupoFamiliar(int id, String nombre, String apellido, String direccion, Parentesco parentesco) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.parentesco = parentesco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
   
   
   
}
