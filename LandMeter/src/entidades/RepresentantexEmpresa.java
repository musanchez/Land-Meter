/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author User
 */
public class RepresentantexEmpresa {
    private String IDEmpresa;
    private String IDPersona;
    private Date fecha = new Date();
    private Date fecha_fin = null;

    public String getIDEmpresa() {
        return IDEmpresa;
    }

    public void setIDEmpresa(String IDEmpresa) {
        this.IDEmpresa = IDEmpresa;
    }

    public String getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(String IDPersona) {
        this.IDPersona = IDPersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public RepresentantexEmpresa(String IDEmpresa, String IDPersona) {
        this.IDEmpresa = IDEmpresa;
        this.IDPersona = IDPersona;
    }
}
