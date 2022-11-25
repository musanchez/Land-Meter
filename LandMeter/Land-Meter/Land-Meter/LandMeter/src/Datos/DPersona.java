/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DPersona {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    // tipo = 1 -> representante, tipo = 2 -> ensayista, tipo = 3 -> persona
    public void obtRegistros(int tipo) {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "";
            if (tipo == 1) {
                tSQL = "SELECT * FROM [GENERAL].[REPRESENTANTE]";
            }
            if (tipo == 2) {
                tSQL = "SELECT * FROM [GENERAL].[ENSAYISTA]";
            }
            if (tipo == 3) {
                tSQL = "SELECT * FROM [GENERAL].[PERSONA]";
            }
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }
    }
        /*
        op sigue
        las mismas reglas
        */
    public boolean guardarPersona(Persona a, int op) {
        boolean guardado = false;
        this.obtRegistros(op);
        try {
            rs.moveToInsertRow();
            if (op == 3) {
                rs.updateString("NOMBRE_PERSONA", a.getNombre());
                rs.updateString("ID_PERSONA", a.getID_Persona());
                rs.updateString("TELEFONO", a.getTelefono());
                rs.updateString("CORREO", a.getCorreo());
            } else {
                rs.updateString("ID_PERSONA", a.getID_Persona());
            }
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        } catch (SQLException ex) {
            System.out.println("Error al guardar al autor: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    Conexion.cerrarConexion(conn);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return guardado;
    }

}
