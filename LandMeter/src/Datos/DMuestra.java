/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.Muestra;
import entidades.Sondeo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

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
    
    public boolean guardarMuestra1(Muestra a) {
        boolean guardado = false;
        this.obtRegistros();
        try {
            rs.moveToInsertRow();
            rs.updateString("ID_MUESTRA", a.getIDMuestra());
            //rs.updateDouble("PESO INICIAL", string1);
            rs.updateString("COORDENADAS", a.getCoordenadas().getCoordenadas());
            rs.updateString("ID_PERSONA", a.getEnsayista().getID_Persona());
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
    
    public DefaultTableModel mostrarMuestras(String idConsulta) {
        // muestra datos de vista creada en sql
        DefaultTableModel dtm = new DefaultTableModel() {

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String encabezados[] = {"ID Muestra", "Peso Inicial","Peso Final","ID Ensayista","Nombre","Correo","Telefono"};
        dtm.setColumnIdentifiers(encabezados);

        //muestra datos de consulta en sql
        try {
            ResultSet rs_consultaMuestra = null;
            conn = Conexion.obtConexion();
            String ConsultaSQL = "SELECT ID_MUESTRA,(CASE WHEN PESO_INICIAL IS NULL THEN '0'\n" +
            "END) AS PESO_INICIAL, (CASE WHEN PESO_FINAL IS NULL THEN '0' END) AS PESO_FINAL,P.ID_PERSONA, P.NOMBRE_PERSONA,P.CORREO,P.TELEFONO\n" +
            "FROM [GRANULOMETRIA].[MUESTRA] M INNER JOIN [GENERAL].[PERSONA] P ON M.ID_PERSONA=P.ID_PERSONA\n" +
            "WHERE COORDENADAS = " +idConsulta;
            ps = conn.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
           
            rs_consultaMuestra = ps.executeQuery();

            while (rs_consultaMuestra.next()) {
                Object registro[] = new Object[7];
                registro[0] = rs_consultaMuestra.getString("ID_MUESTRA");
                registro[1] = rs_consultaMuestra.getDouble("PESO_INICIAL");
                registro[2] = rs_consultaMuestra.getDouble("PESO_FINAL");
                registro[3] = rs_consultaMuestra.getString("ID_PERSONA");
                registro[4] = rs_consultaMuestra.getString("NOMBRE_PERSONA");
                registro[5] = rs_consultaMuestra.getString("CORREO");
                registro[6] = rs_consultaMuestra.getString("TELEFONO");
                dtm.addRow(registro);
            }

        } catch (SQLException ex) {
            System.out.println("Error al mostrar muestras del Sondeo: " + ex.getMessage());

        }
        return dtm;
    }

     public boolean editarMuestra(Muestra muestra) {

        /*
        boolean resp = false;
        this.obtRegistros();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                if(rs.getString("ID_MUESTRA").equals(muestra.getIDMuestra()) {
                rs.updateString(string, string1);
                  // rs.updateString("COORDENADAS", sondeo.getCoordenadas());
                  //  rs.updateDate("FECHA", fecha);
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar sondeo: " + ex.getMessage());
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
    */
        return false;
    }
   
    
}
