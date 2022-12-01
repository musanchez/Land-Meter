/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DEmpresa {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void obtRegistros() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GENERAL].[EMPRESA]";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }

    }

    public boolean guardarEmpresa(Empresa a) {
        boolean guardado = false;
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_EMPRESA", a.getID_Empresa());
            rs.updateString("NOMBRE_EMPRESA", a.getNombreEmpresa());
            rs.updateString("TELEFONO", a.getTelefonoEmpresa());
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

    public ArrayList<String> listarEmpresas() throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        this.obtRegistros();
        while (rs.next()) {
            lista.add(rs.getString("NOMBRE_EMPRESA"));
        }
        return lista;

    }

    public String getEmpId(String nom) {
        String id = "";
        String query = "SELECT [ID_EMPRESA]\n"
                + "FROM [GENERAL].[EMPRESA]\n"
                + "WHERE [NOMBRE_EMPRESA] = " + "'" + nom + "'";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
            rs.next();
            id = rs.getString("ID_EMPRESA");
        } catch (SQLException ex) {
            System.out.println("Error al obtener registro!");
        }
        return id;
    }
    public boolean inEmpresa(String ruc) {
        boolean res = false;
        int cant;
        String tSQL = "SELECT COUNT(*) CANT FROM"
                + " [GENERAL].[EMPRESA] WHERE [ID_EMPRESA] = ?";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ps.setString(1, ruc);
            rs = ps.executeQuery();
            rs.next();
            cant = rs.getInt("CANT");
            if (cant > 0) {
                res = true;
            }
            
        } catch (SQLException ex) {
            System.out.println("Hubo un error al obtener el registro");
        }
        return res;
    }
    

}
