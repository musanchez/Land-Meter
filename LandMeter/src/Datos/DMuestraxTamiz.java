/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.MuestraxTamiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DMuestraxTamiz {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void obtRegistros() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GRANULOMETRIA].[TAMIZXMUESTRA]";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros de muestra: " + ex.getMessage());
        }
    }

    public void agregarMuestraxTamiz(MuestraxTamiz a) {
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_MUESTRA", a.getMuestra().getIDMuestra());
            //rs.updateDouble("PESO INICIAL", string1);
            rs.updateInt("COD_TAMIZ", a.getTamiz().getId());
            rs.updateDouble("PESO_RETENIDO", a.getPesoRetenido());
            rs.insertRow();
            rs.moveToCurrentRow();
        } catch (SQLException ex) {
            System.out.println("Error al guardar muestra: " + ex.getMessage());
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
    }
    
    
    
    

}
