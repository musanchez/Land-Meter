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
    
    public RepresentantexEmpresa(String IDEmpresa, String IDPersona, Date fecha) {
        this.IDEmpresa = IDEmpresa;
        this.IDPersona = IDPersona;
        this.fecha = fecha;
    }

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
    
}
