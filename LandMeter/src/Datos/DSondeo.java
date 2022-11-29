/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import entidades.Sondeo;
import static formularios.FrmSondeos.jTfIdProyect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Silvio
 */
public class DSondeo {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void obtRegistros() {
        try {
            conn = Conexion.obtConexion();
            String tSQL = "SELECT * FROM [GENERAL].[SONDEO]";
            ps = conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros de sondeo: " + ex.getMessage());
        }
    }
    
    public boolean guardarSondeo(Sondeo a) {
        boolean guardado = false;
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_PROYECTO", a.getProyecto().getIDProyecto());
            //establecemos formato de la fecha para convertirla al tipo de dato que acepta sql
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formato = simpleDateFormat.format(a.getFecha());
            java.sql.Date fecha = java.sql.Date.valueOf(formato);
            rs.updateDate("FECHA", fecha);
            
            rs.updateString("COORDENADAS", a.getCoordenadas());
            
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
    
     public DefaultTableModel mostrarSondeos(String idConsulta){
        // muestra datos de vista creada en sql
        DefaultTableModel dtm = new DefaultTableModel(){

            public boolean isCellEditable(int row,int column){
                return false;
            }
        };

        String encabezados[] = {"Coordenadas","Fecha Sondeo"};
        dtm.setColumnIdentifiers(encabezados);

        //muestra datos de consulta en sql
        try{
            ResultSet rs_consultaSondeo = null;
            conn = Conexion.obtConexion();
            
            String ConsultaSQL = "SELECT COORDENADAS, FECHA FROM [GENERAL].[SONDEO] WHERE ID_PROYECTO = " +idConsulta;
            ps = conn.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs_consultaSondeo = ps.executeQuery();

            while(rs_consultaSondeo.next()){

              Object registro [] = new Object[2];
              registro[0] = rs_consultaSondeo.getString("COORDENADAS");
              registro[1] = rs_consultaSondeo.getString("FECHA");
              dtm.addRow(registro);
            }

        }catch(SQLException ex){
             System.out.println("Error al mostrar Sondeos del Proyecto: " + ex.getMessage());

            }
        return dtm;
        }
     
     
}
