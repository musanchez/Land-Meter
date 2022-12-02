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
    private Persona ensayista;

    public Muestra() {
    }

    public Persona getEnsayista() {
        return ensayista;
    }

    public void setEnsayista(Persona ensayista) {
        this.ensayista = ensayista;
    }

    public Muestra(String IDMuestra, double pesoInicial, double pesoFinal, Sondeo coordenadas, Persona ensayista) {
        this.IDMuestra = IDMuestra;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.coordenadas = coordenadas;
        this.ensayista = ensayista;
    }
    

    public Muestra(String IDMuestra, Sondeo coordenadas) {
        this.IDMuestra = IDMuestra;
        this.coordenadas = coordenadas;
    }

    public Muestra(String IDMuestra, Sondeo coordenadas, Persona ensayista) {
        this.IDMuestra = IDMuestra;
        this.coordenadas = coordenadas;
        this.ensayista = ensayista;
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

    @Override
    public String toString() {
        return "Muestra{" + "IDMuestra=" + IDMuestra + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", coordenadas=" + coordenadas + '}';
    }
    
    
}
