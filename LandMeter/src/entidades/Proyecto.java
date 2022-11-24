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
    private String IDPersona;

    public Proyecto(String nombreProyecto, String IDProyecto, String descripcion, String IDPersona) {
        this.nombreProyecto = nombreProyecto;
        this.IDProyecto = IDProyecto;
        this.descripcion = descripcion;
        this.IDPersona = IDPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String IDProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.IDProyecto = IDProyecto;
    }

    public String getIDProyecto() {
        return IDProyecto;
    }

    public void setIDProyecto(String IDProyecto) {
        this.IDProyecto = IDProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "nombreProyecto=" + nombreProyecto + ", IDProyecto=" + IDProyecto + '}';
    }

    public String getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(String IDPersona) {
        this.IDPersona = IDPersona;
    }
    
    
    
}
