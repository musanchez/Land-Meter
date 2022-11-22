/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author megan
 */
public class Sondeo {
    private Proyecto IDProyecto;
    private Date fecha;
    private String coordenadas;

    public Sondeo() {
    }

    public Sondeo(Proyecto IDProyecto, Date fecha, String coordenadas) {
        this.IDProyecto = IDProyecto;
        this.fecha = fecha;
        this.coordenadas = coordenadas;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Proyecto getIDProyecto() {
        return IDProyecto;
    }

    public void setIDProyecto(Proyecto IDProyecto) {
        this.IDProyecto = IDProyecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Sondeo{" + "IDProyecto=" + IDProyecto + ", fecha=" + fecha + ", coordenadas=" + coordenadas + '}';
    }
    
    
}
