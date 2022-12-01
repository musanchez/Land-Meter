/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Persona;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class DProyecto {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    DefaultTableModel dtm;

    public void obtRegistros(String x) {
        try {
            conn = Conexion.obtConexion();

            ps = conn.prepareStatement(x,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros: " + ex.getMessage());
        }
    }

    public boolean guardarProyecto(Proyecto a) {
        boolean guardado = false;
        this.obtRegistros("SELECT * FROM [GENERAL].[PROYECTO]");
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_PROYECTO", a.getIDProyecto());
            rs.updateString("NOMBRE_PROYECTO", a.getNombreProyecto());
            rs.updateString("DESCRIPCION", a.getDescripcion());
            rs.updateString("ID_PERSONA", a.getRepxemp().getIDPersona());
            rs.updateString("ID_EMPRESA", a.getRepxemp().getIDEmpresa());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        } catch (SQLException ex) {
            System.out.println("Error al guardar datos del Proyecto: " + ex.getMessage());
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

    public DefaultTableModel mostrarProyectos() {
        // muestra datos de vista creada en sql
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String encabezados[] = {"Proyecto", "Descripcion", "ID", "Empresa", "ID", "Telefono", "Representante", "ID", "Telefono", "Correo"};
        dtm.setColumnIdentifiers(encabezados);

        //muestra datos de vista creada en sql
        try {
            ResultSet rs_vistaProyecto = null;
            conn = Conexion.obtConexion();
            String ConsultaSQL = "SELECT * FROM VW_PROYECTO";
            ps = conn.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs_vistaProyecto = ps.executeQuery();

            while (rs_vistaProyecto.next()) {
                Object registro[] = new Object[10];
                registro[0] = rs_vistaProyecto.getString("NOMBRE_PROYECTO");
                registro[1] = rs_vistaProyecto.getString("DESCRIPCION");
                registro[2] = rs_vistaProyecto.getString("ID_PROYECTO");
                registro[3] = rs_vistaProyecto.getString("NOMBRE_EMPRESA");
                registro[4] = rs_vistaProyecto.getString("ID_EMPRESA");
                registro[5] = rs_vistaProyecto.getString("TELEFONO_EMPRESA");
                registro[6] = rs_vistaProyecto.getString("NOMBRE_PERSONA");
                registro[7] = rs_vistaProyecto.getString("ID_PERSONA");
                registro[8] = rs_vistaProyecto.getString("TELEFONO");
                registro[9] = rs_vistaProyecto.getString("CORREO");
                dtm.addRow(registro);
            }

        } catch (SQLException ex) {
            System.out.println("Error al mostrar datos del Proyecto: " + ex.getMessage());
        }
        return dtm;
    }

    /*public ArrayList<Proyecto> listarProyecto(){
       ArrayList<Proyecto> lista = new ArrayList<>();
       try{
           this.obtRegistros("SELECT [NOMBRE_PROYECTO]VP FROM [VW_PROYECTO]VP WHERE VP.NOMBRE_PROYECTO='?'");
           while (rs.next()){
               lista.add(new Proyecto(
               rs.getString("NOMBRE_PROYECTO"),
               rs.getString("DESCRIPCION"),
               rs.getString("DESCRIPCION"),
               rs.getString("ID_PERSONA")
               ));
           }
       }catch(SQLException ex){
           System.out.println("Error al listar autor "+ex.getMessage());
       }finally{
           try{
               if(rs != null){
                   rs.close();
               }
               
               if(ps != null){
                   ps.close();
               }
               
               if(conn != null){
                   Conexion.cerrarConexion(conn);
               }
           }catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
       return lista;
   }*/
    /*public boolean existeProyecto(String nombreProyecto) {
        boolean resp = false;
        this.obtRegistros("SELECT [NOMBRE_PROYECTO]VP FROM [VW_PROYECTO]VP WHERE VP.NOMBRE_PROYECTO='?'");
        try {
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("NOMBRE_PROYECTO") == nombreProyecto) {
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar proyecto: " + ex.getMessage());
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

        return resp;
    }*/
    public boolean inProyecto(String id_pro) {
        boolean res = false;
        int cant;
        String tSQL = "SELECT COUNT(*) CANT FROM"
                + " [GENERAL].[PROYECTO] WHERE [ID_PROYECTO] = ?";
        try {
            conn = Conexion.obtConexion();
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            ps.setString(1, id_pro);
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
