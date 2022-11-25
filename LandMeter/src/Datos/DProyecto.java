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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DProyecto {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void obtRegistros() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GENERAL].[PROYECTO]";
            ps = conn.prepareStatement(tSQL,
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
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_PROYECTO", a.getIDProyecto());
            rs.updateString("NOMBRE_PROYECTO", a.getNombreProyecto());
            rs.updateString("DESCRIPCION", a.getDescripcion());
            rs.updateString("ID_PERSONA", a.getRepresentante().getID_Persona());
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
    
    public DefaultTableModel mostrarProyectos(){
        // muestra datos de vista creada en sql
    DefaultTableModel dtm = new DefaultTableModel();
    String encabezados[] = {"Nombre","Descripcion","Empresa", "Representante","Telefono"};
    dtm.setColumnIdentifiers(encabezados);
     
    //muestra datos de vista creada en sql
    try{
        ResultSet rs_vistaProyecto = null;
        conn = Conexion.obtConexion();
        String ConsultaSQL = "SELECT * FROM VW_PROYECTO";
        ps = conn.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.HOLD_CURSORS_OVER_COMMIT);
        rs_vistaProyecto = ps.executeQuery();
        
        while(rs_vistaProyecto.next()){
          Object registro [] = new Object[5];
          registro[0] = rs_vistaProyecto.getString("NOMBRE_PROYECTO");
          registro[1] = rs_vistaProyecto.getString("DESCRIPCION");
          registro[2] = rs_vistaProyecto.getString("NOMBRE_EMPRESA");
          registro[3] = rs_vistaProyecto.getString("REPRESENTANTE");
          registro[4] = rs_vistaProyecto.getString("TELEFONO");
          dtm.addRow(registro);
        }
        
    }catch(SQLException ex){
         System.out.println("Error al mostrar datos del Proyecto: " + ex.getMessage());
        }
    return dtm;
    }
    
    
}
