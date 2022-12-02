/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author User
 */
public class MuestraxTamiz {
    double pesoRetenido;
    Tamiz tamiz;
    Muestra muestra;

    public MuestraxTamiz(double pesoRetenido, Tamiz tamiz, Muestra muestra) {
        this.pesoRetenido = pesoRetenido;
        this.tamiz = tamiz;
        this.muestra = muestra;
    }

    public double getPesoRetenido() {
        return pesoRetenido;
    }

    public void setPesoRetenido(float pesoRetenido) {
        this.pesoRetenido = pesoRetenido;
    }

    public Tamiz getTamiz() {
        return tamiz;
    }

    public void setTamiz(Tamiz tamiz) {
        this.tamiz = tamiz;
    }

    public Muestra getMuestra() {
        return muestra;
    }

    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
}
