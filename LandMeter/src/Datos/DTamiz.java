/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.Tamiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DTamiz {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void obtRegistrosTam() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GRANULOMETRIA].[TAMIZ]";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }
    }

    public ArrayList<Tamiz> listarTam() throws SQLException {
        ArrayList<Tamiz> lista = new ArrayList<Tamiz>();
        obtRegistrosTam();
        while (rs.next()) {
            lista.add(new Tamiz(rs.getString("TAMANO_PULGADA"), rs.getString("TAMANO_MM"),
                    rs.getInt("COD_TAMIZ")));
        }
        return lista;
    }
    public Tamiz genTamiz(String tamMm) {
        Tamiz tam = new Tamiz();
        String query = "SELECT * FROM [GRANULOMETRIA].[TAMIZ] WHERE [TAMANO_MM] = '"+tamMm+"'";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
            rs.next();
            tam.setId(rs.getInt("COD_TAMIZ"));
            tam.setTamanioMm(tamMm);
            tam.setTamanioPul(rs.getString("TAMANO_PULGADA"));

        } catch (SQLException ex) {
            System.out.println("Error al obtener registro!");
        }
        return tam;
    }
}