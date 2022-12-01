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
import java.util.ArrayList;

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

    public void obtRegistrosRep() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT *\n"
                    + "FROM [GENERAL].[PERSONA] PER, [GENERAL].[REPRESENTANTE] REP\n"
                    + "WHERE PER.ID_PERSONA = REP.ID_PERSONA";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }

    }

    public ArrayList<Persona> listarRepresentante() throws SQLException {
        ArrayList<Persona> listaRep = new ArrayList<Persona>();
        this.obtRegistrosRep();
        while (rs.next()) {
            listaRep.add(new Persona(rs.getString("NOMBRE_PERSONA"), rs.getString("ID_PERSONA"), rs.getString("CORREO"), rs.getString("TELEFONO")));
        }
        return listaRep;

    }

    public String getNomID(String nom) {
        String id = "";
        String query = "SELECT REP.ID_PERSONA, P.NOMBRE_PERSONA, [TELEFONO], [CORREO]\n"
                + "FROM [GENERAL].[PERSONA] P INNER JOIN [GENERAL].[REPRESENTANTE] REP\n"
                + "ON P.ID_PERSONA=REP.ID_PERSONA";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
            rs.next();
            id = rs.getString("ID_PERSONA");
        } catch (SQLException ex) {
            System.out.println("Error al obtener registro!");
        }
        return id;
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

    public boolean inRepresentante(String id) {
        boolean resp = false;
        int cant;
        String tSQL = "SELECT COUNT(*) AS CANTIDAD\n"
                + "FROM [GENERAL].[REPRESENTANTE]\n"
                + "WHERE [ID_PERSONA] = '" + id + "'";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
            rs.next();
            cant = rs.getInt("CANTIDAD");
            System.out.println(cant);
            if (cant > 0) {
                resp = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error");
        }

        return resp;

    }

    public boolean inPersona(String id) {
        boolean resp = false;
        int cant;
        String tSQL = "SELECT COUNT(*) AS CANTIDAD\n"
                + "FROM [GENERAL].[PERSONA]\n"
                + "WHERE [ID_PERSONA] = '" + id + "'";
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
            System.out.println("Error");
        }

        return resp;
    }
}
