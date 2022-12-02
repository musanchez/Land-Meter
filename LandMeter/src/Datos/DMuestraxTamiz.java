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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
            String tSQL = "SELECT * FROM [GRANULOMETRIA].[TAMIZXMUESTRA] ORDER BY COD_TAMIZ ASC";
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

    public ArrayList<Double> porRetPar() {
        ArrayList<Double> pesos = new ArrayList<Double>();
        int count = 0;
        double sum1 = 0;
        double sum2 = 0;
        try {
            this.obtRegistros();
            while (rs.next()) {
                pesos.add(rs.getDouble("PESO_RETENIDO"));
                if (count < 10) {
                    sum1 += pesos.get(count);
                } else {
                    sum2 += pesos.get(count);
                }
                count++;
            }
            for (int i = 0; i < 19; i++) {
                if (i < 10) {
                    pesos.set(i, pesos.get(i) / sum1 * 100);
                } else {
                    pesos.set(i, pesos.get(i) / sum2 * 100);
                }

            }

        } catch (SQLException e) {
            System.out.println("Error al obtener pesos ret");
        }
        return pesos;
    }

    public ArrayList<Double> listarPesos() throws SQLException {
        ArrayList<Double> lista = new ArrayList<Double>();
        this.obtRegistros();
        while (rs.next()) {
            lista.add(rs.getDouble("PESO_RETENIDO"));
        }
        return lista;

    }

    public DefaultTableModel mostrargGranulometria1() {
        // muestra datos de vista creada en sql
        DefaultTableModel dtm = new DefaultTableModel() {

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String encabezados[] = {"Tamaño mm", "Tamaño pulg", "Peso Retenido", "% Retenido Parcial", "% Retenido Acumulado", "% Pasa"};
        dtm.setColumnIdentifiers(encabezados);

        //muestra datos de consulta en sql
        try {
            ResultSet rs_consultaGranulometria1 = null;
            conn = Conexion.obtConexion();
            String ConsultaSQL = "SELECT T.TAMANO_MM, T.TAMANO_PULGADA, TM.PESO_RETENIDO\n"
                    + "FROM [GRANULOMETRIA].[TAMIZXMUESTRA] AS TM INNER JOIN [GRANULOMETRIA].[TAMIZ] AS T ON TM.COD_TAMIZ=T.COD_TAMIZ INNER JOIN [GRANULOMETRIA].[MUESTRA] AS M ON TM.ID_MUESTRA=M.ID_MUESTRA\n"
                    + "WHERE T.COD_TAMIZ<11 ORDER BY T.COD_TAMIZ ASC";
            ps = conn.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);

            rs_consultaGranulometria1 = ps.executeQuery();
            try {

                while (rs_consultaGranulometria1.next()) {
                    Object registro[] = new Object[6];
                    registro[0] = rs_consultaGranulometria1.getString("TAMANO_MM");
                    registro[1] = rs_consultaGranulometria1.getString("TAMANO_PULGADA");
                    registro[2] = rs_consultaGranulometria1.getDouble("PESO_RETENIDO");

                    /*registro[3] = rs_consultaMuestra.getString("ID_PERSONA");
                registro[4] = rs_consultaMuestra.getString("NOMBRE_PERSONA");
                registro[5] = rs_consultaMuestra.getString("CORREO");*/
                    dtm.addRow(registro);
                }

                ArrayList<Double> lista = listarPesos();
                for (double a : lista) {
                    System.out.println(a);
                }
                double suma = 0;
                double acumulado = 0;
                double pasa;
                for (int i = 0; i < 10; i++) {
                    suma += lista.get(i);
                }
                for (int i = 0; i < 10; i++) {
                    lista.set(i, lista.get(i) / suma * 100);
                    dtm.setValueAt(lista.get(i), i, 3);
                    dtm.setValueAt(acumulado + lista.get(i), i, 4);
                    pasa=acumulado+lista.get(i);
                    dtm.setValueAt(100 - pasa, i, 5);

                    acumulado += lista.get(i);

                }

            } catch (Exception ex) {
                System.out.println("Error en granulometria: " + ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("Error al mostrar analisis Granulometrico: " + ex.getMessage());

        }
        return dtm;
    }
    
    public DefaultTableModel mostrargGranulometria2() {
        // muestra datos de vista creada en sql
        DefaultTableModel dtm = new DefaultTableModel() {

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String encabezados[] = {"Tamaño mm", "Tamaño pulg", "Peso Retenido", "% Retenido Parcial", "% Retenido Acumulado", "% Pasa"};
        dtm.setColumnIdentifiers(encabezados);

        //muestra datos de consulta en sql
        try {
            ResultSet rs_consultaGranulometria2 = null;
            conn = Conexion.obtConexion();
            String ConsultaSQL = "SELECT T.TAMANO_MM, T.TAMANO_PULGADA, TM.PESO_RETENIDO\n"
                    + "FROM [GRANULOMETRIA].[TAMIZXMUESTRA] AS TM INNER JOIN [GRANULOMETRIA].[TAMIZ] AS T ON TM.COD_TAMIZ=T.COD_TAMIZ INNER JOIN [GRANULOMETRIA].[MUESTRA] AS M ON TM.ID_MUESTRA=M.ID_MUESTRA\n"
                    + "WHERE T.COD_TAMIZ>=11 ORDER BY T.COD_TAMIZ ASC";
            ps = conn.prepareStatement(ConsultaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);

            rs_consultaGranulometria2 = ps.executeQuery();
            try {

                while (rs_consultaGranulometria2.next()) {
                    Object registro[] = new Object[6];
                    registro[0] = rs_consultaGranulometria2.getString("TAMANO_MM");
                    registro[1] = rs_consultaGranulometria2.getString("TAMANO_PULGADA");
                    registro[2] = rs_consultaGranulometria2.getDouble("PESO_RETENIDO");

                    /*registro[3] = rs_consultaMuestra.getString("ID_PERSONA");
                registro[4] = rs_consultaMuestra.getString("NOMBRE_PERSONA");
                registro[5] = rs_consultaMuestra.getString("CORREO");*/
                    dtm.addRow(registro);
                }

                ArrayList<Double> lista = listarPesos();
                for (double a : lista) {
                    System.out.println(a);
                }
                double suma = 0;
                double acumulado = 0;
                double pasa;
                for (int i = 10; i < 19; i++) {
                    suma += lista.get(i);
                }
                int fila=0;
                for (int i = 10; i < 19; i++) {
                    lista.set(i, lista.get(i) / suma * 100);
                    dtm.setValueAt(lista.get(i), fila, 3);
                    dtm.setValueAt(acumulado + lista.get(i), fila, 4);
                    pasa=acumulado+lista.get(i);
                    dtm.setValueAt(100 - pasa, fila, 5);

                    acumulado += lista.get(i);
                    fila++;

                }

            } catch (Exception ex) {
                System.out.println("Error en granulometria: " + ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("Error al mostrar analisis Granulometrico: " + ex.getMessage());

        }
        return dtm;
    }

}
