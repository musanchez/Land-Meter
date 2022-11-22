/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author megan
 */
public class Muestra {
    
    private String IDMuestra;
    private double pesoInicial;
    private double pesoFinal;
    private Sondeo coordenadas;

    public Muestra() {
    }

    public Muestra(String IDMuestra, double pesoInicial, double pesoFinal, Sondeo coordenadas) {
        this.IDMuestra = IDMuestra;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.coordenadas = coordenadas;
    }

    public Sondeo getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Sondeo coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getIDMuestra() {
        return IDMuestra;
    }

    public void setIDMuestra(String IDMuestra) {
        this.IDMuestra = IDMuestra;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }
    
    
}