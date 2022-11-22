/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author megan
 */
public class Tamiz {
    
    private String tamanioPul;
    private String tamanioMm;

    public Tamiz() {
    }

    public Tamiz(String tamanioPul, String tamanioMm) {
        this.tamanioPul = tamanioPul;
        this.tamanioMm = tamanioMm;
    }

    public String getTamanioMm() {
        return tamanioMm;
    }

    public void setTamanioMm(String tamanioMm) {
        this.tamanioMm = tamanioMm;
    }

    public String getTamanioPul() {
        return tamanioPul;
    }

    public void setTamanioPul(String tamanioPul) {
        this.tamanioPul = tamanioPul;
    }

    @Override
    public String toString() {
        return "Tamiz{" + "tamanioPul=" + tamanioPul + ", tamanioMm=" + tamanioMm + '}';
    }
    
    
}
