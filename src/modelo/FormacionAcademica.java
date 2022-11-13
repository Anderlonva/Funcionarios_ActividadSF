package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Anderson Londoño
 */
public class FormacionAcademica {
    
    private int id;
    private Date fechaInicio; //-----------
    private Date fechaFinal; //-----------
    private Estado estado;
    private Nivel nivel;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;
    private Universidad universidad;
    private Funcionario funcionario;

    public FormacionAcademica() {
    }

    public FormacionAcademica(int id, Date fechaInicio, Date fechaFinal, Estado estado, Nivel nivel, LocalDate fechaCreacion, LocalDate fechaActualizacion, Universidad universidad, Funcionario funcionario) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.nivel = nivel;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.universidad = universidad;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
   
    
}
