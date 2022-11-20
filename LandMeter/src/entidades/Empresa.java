/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author megan
 */
public class Empresa {
    
    private String ID_Empresa;
    private String nombreEmpresa;
    private String telefonoEmpresa;

    public Empresa() {
    }

    public Empresa(String ID_Empresa, String nombreEmpresa, String telefonoEmpresa) {
        this.ID_Empresa = ID_Empresa;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getID_Empresa() {
        return ID_Empresa;
    }

    public void setID_Empresa(String ID_Empresa) {
        this.ID_Empresa = ID_Empresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    
}

