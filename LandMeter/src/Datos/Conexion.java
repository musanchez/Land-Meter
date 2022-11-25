/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.sql.*;
/**
 *
 * @author User
 */
public class Conexion {
    private static Conexion conx = null;
    private static Connection con = null;
    private static String url = "jdbc:sqlserver://localhost;" + "databaseName=LANDMETER;"
            + "Persist Security Info=True;";
    private static String user = "sa";
    private static String password = "gonzalez123";
    private Conexion() {
    }
    public static Conexion obtInstancia() {
        if (conx==null) {
            conx = new Conexion();
        }
        return conx;
    }
    public static Connection obtConexion() {
        if (estaConectado() == false) {
            Conexion.crearConexion();
        }
        return con;
        
    }
    @SuppressWarnings("UseSpecificCatch")
    public static boolean estaConectado() {
        boolean resp = false;
        try {
            
        } catch (Exception e) {
            System.out.println("Error al consu"
                    + "ltar el estado de"
                    + " la conexion: " + e.getMessage());
        }
        return resp;
    }
    
    public static void crearConexion() {
        try {
            Class.forName("com.microsoft.sqlse"
            + "rver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);
            
        } 
        catch (ClassNotFoundException e) {
            con=null;
            System.out.println("Error al cargar el driver: " + e.getMessage());
            
        }
        catch (SQLException e) {
            con=null;
            System.out.println("Error al establecer la conexion:" + e.getMessage());
        }
        
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static void cerrarConexion(Connection con) { 
        if (estaConectado() != false) {
            try {
                con.close();
            } catch(SQLException e) {
                e.printStackTrace();
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }    
}
