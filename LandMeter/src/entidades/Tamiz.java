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
    private int id;

    @Override
    public String toString() {
        return tamanioMm;
    }

    public Tamiz() {
    }

    public Tamiz(String tamanioPul, String tamanioMm, int id) {
        this.tamanioPul = tamanioPul;
        this.tamanioMm = tamanioMm;
        this.id = id;
    }

    public String getTamanioPul() {
        return tamanioPul;
    }

    public void setTamanioPul(String tamanioPul) {
        this.tamanioPul = tamanioPul;
    }

    public String getTamanioMm() {
        return tamanioMm;
    }

    public void setTamanioMm(String tamanioMm) {
        this.tamanioMm = tamanioMm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
}
