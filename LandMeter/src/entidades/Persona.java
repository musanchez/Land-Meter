/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author megan
 */
public class Persona {
    private String nombre;
    private String ID_Persona;

    public Persona() {
    }

    public Persona(String nombre, String ID_Persona) {
        this.nombre = nombre;
        this.ID_Persona = ID_Persona;
    }

    public String getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(String ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", ID_Persona=" + ID_Persona + '}';
    }
    
    
}
