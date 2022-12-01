/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.RepresentantexEmpresa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DRepresentantexEmpresa {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void obtRegistros() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GENERAL].[REPRESENTANTEXEMPRESA]";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }
    }

    public boolean guardarRexEmp(RepresentantexEmpresa a) {
        boolean guardado = false;
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_EMPRESA", a.getIDEmpresa());
            rs.updateString("ID_PERSONA", a.getIDPersona());
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date fec = new java.sql.Date(utilDate.getTime());
            rs.updateDate("FECHA", fec);
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

    public boolean activoInRepxEmp(String id_rep, String id_emp) {
        boolean resp = false;
        int cant;
        String tSQL = "SELECT COUNT(*) CANTIDAD\n"
                + "FROM [GENERAL].[REPRESENTANTEXEMPRESA]\n"
                + "WHERE [ID_PERSONA] = '" + id_rep + "' AND [ID_EMPRESA] = '" + id_emp + "'"
                + " AND [FECHA_FIN] IS NULL";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
            rs.next();
            cant = rs.getInt("CANTIDAD");

            if (cant > 0) {
                resp = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }

    public boolean existeRepxEmp(String id_rep, String id_emp) {
        boolean resp = false;
        int cant;
        String tSQL = "SELECT COUNT(*) CANTIDAD\n"
                + "FROM [GENERAL].[REPRESENTANTEXEMPRESA]\n"
                + "WHERE [ID_PERSONA] = '" + id_rep + "' AND [ID_EMPRESA] = '" + id_emp + "'";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
            rs.next();
            cant = rs.getInt("CANTIDAD");

            if (cant > 0) {
                resp = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    
    
    // ponemos en true cuando queremos volarnos los que ya no van a ser la empresa relacionada al id
    // ponemos en false cuando vamos a hacer que la persona comience a trabajar en su empresa asignada

    public void updateEmpxRep(String id_emp, String id_rep, boolean eleccion) {
        String tSQL;
        if (eleccion == false) {
            tSQL = "UPDATE [GENERAL].[REPRESENTANTEXEMPRESA]"
                + " SET [FECHA_FIN] = NULL WHERE"
                + " (ID_PERSONA = ? AND ID_EMPRESA = ? AND FECHA_FIN IS NOT NULL)";
        } else {
            tSQL = "UPDATE [GENERAL].[REPRESENTANTEXEMPRESA]"
                    + "SET [FECHA_FIN] = GETDATE() "
                    + "WHERE (ID_PERSONA = ? AND ID_EMPRESA != ? AND FECHA_FIN IS NULL)";
        }
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL);
            ps.setString(1, id_rep);
            ps.setString(2, id_emp);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public void vincEmpxRep(String id_rep) {
        String tSQL = "UPDATE [GENERAL].[REPRESENTANTEXEMPRESA]"
                + " SET [FECHA_FIN] = GETDATE() WHERE"
                + " (ID_PERSONA = ? AND FECHA_FIN IS NULL)";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL);
            ps.setString(1, id_rep);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
