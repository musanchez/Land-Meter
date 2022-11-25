/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author megan
 */
public class Proyecto {
    
    private String nombreProyecto;
    private String IDProyecto;
    private String descripcion;
    private Persona representante;

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getIDProyecto() {
        return IDProyecto;
    }

    public void setIDProyecto(String IDProyecto) {
        this.IDProyecto = IDProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public void setRepresentante(Persona representante) {
        this.representante = representante;
    }

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String IDProyecto, String descripcion, Persona representante) {
        this.nombreProyecto = nombreProyecto;
        this.IDProyecto = IDProyecto;
        this.descripcion = descripcion;
        this.representante = representante;
    }

    
    
}
