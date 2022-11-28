/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.Muestra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ale05
 */
public class DMuestra {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void obtRegistros() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GRANULOMETRIA].[MUESTRA]";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros de muestra: " + ex.getMessage());
        }
    }
    
    public boolean guardarMuestra(Muestra a) {
        boolean guardado = false;
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_MUESTRA", a.getIDMuestra());
            //rs.updateDouble("PESO INICIAL", string1);
            //rs.updateString("COORDENADAS", a.getCoordenadas());
            
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        } catch (SQLException ex) {
            System.out.println("Error al guardar al sondeo: " + ex.getMessage());
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
