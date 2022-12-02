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
    private Proyecto proyecto;
    private Date fecha;
    private String coordenadas;

    public Sondeo() {
    }

    public Sondeo(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Sondeo(Proyecto proyecto, Date fecha, String coordenadas) {
        this.proyecto = proyecto;
        this.fecha = fecha;
        this.coordenadas = coordenadas;
    }

  

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Sondeo{" + "proyecto=" + proyecto + ", fecha=" + fecha + ", coordenadas=" + coordenadas + '}';
    }

    
  
    
    
}
