/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import Datos.DMuestra;
import Datos.DSondeo;
import entidades.Empresa;
import entidades.Persona;
import entidades.Proyecto;
import entidades.RepresentantexEmpresa;
import entidades.Sondeo;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;


/**
 *
 * @author Synthia Pamella
 */
public class FrmSondeos extends javax.swing.JFrame {
    
    DSondeo dsondeo = new DSondeo();
   //  Proyecto proyecto = new Proyecto();
    

    /**
     * Creates new form FrmSondeos
     */
    public FrmSondeos() {
        
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTfCoordenadasSondeo = new javax.swing.JTextField();
        jTfFechaSondeo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfIdProyect = new javax.swing.JTextField();
        jBtnGuardarSondeo = new javax.swing.JButton();
        jTfNomProyecto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblRegistrosSondeos = new javax.swing.JTable();
        jBtnEditarSondeo = new javax.swing.JButton();
        jBtnEliminarSondeo = new javax.swing.JButton();
        jBtnMuestras = new javax.swing.JButton();
        jBtnReg1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Sondeos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel2.setText("Datos Generales Sondeo");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel3.setText("Coordenadas:");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel4.setText("Fecha del sondeo:");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel5.setText("Proyecto");

        jTfIdProyect.setEnabled(false);

        jBtnGuardarSondeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complementos/img/guardarFI.png"))); // NOI18N
        jBtnGuardarSondeo.setText("Guardar");
        jBtnGuardarSondeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarSondeoActionPerformed(evt);
            }
        });

        jTfNomProyecto.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel6.setText("ID:");

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel7.setText("Nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTfCoordenadasSondeo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTfFechaSondeo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfIdProyect, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(jTfNomProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(288, Short.MAX_VALUE)
                    .addComponent(jBtnGuardarSondeo)
                    .addGap(28, 28, 28)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTfIdProyect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfNomProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTfFechaSondeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTfCoordenadasSondeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(223, Short.MAX_VALUE)
                    .addComponent(jBtnGuardarSondeo)
                    .addContainerGap()))
        );

        jTblRegistrosSondeos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblRegistrosSondeos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblRegistrosSondeosMouseClicked(evt);
            }
        });
        jTblRegistrosSondeos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTblRegistrosSondeosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTblRegistrosSondeos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        jBtnEditarSondeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complementos/img/editarFI.png"))); // NOI18N
        jBtnEditarSondeo.setText("Editar");
        jBtnEditarSondeo.setEnabled(false);
        jBtnEditarSondeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarSondeoActionPerformed(evt);
            }
        });

        jBtnEliminarSondeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complementos/img/eliminarFI.png"))); // NOI18N
        jBtnEliminarSondeo.setText("Eliminar");
        jBtnEliminarSondeo.setEnabled(false);
        jBtnEliminarSondeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarSondeoActionPerformed(evt);
            }
        });

        jBtnMuestras.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jBtnMuestras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complementos/img/muestras.png"))); // NOI18N
        jBtnMuestras.setText("Muestras");
        jBtnMuestras.setEnabled(false);
        jBtnMuestras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMuestrasActionPerformed(evt);
            }
        });

        jBtnReg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complementos/img/regresar.png"))); // NOI18N
        jBtnReg1.setText("Regresar");
        jBtnReg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReg1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jBtnReg1)
                        .addGap(59, 59, 59)
                        .addComponent(jBtnEditarSondeo)
                        .addGap(55, 55, 55)
                        .addComponent(jBtnEliminarSondeo)
                        .addGap(55, 55, 55)
                        .addComponent(jBtnMuestras)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnReg1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jBtnEditarSondeo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnMuestras)
                            .addComponent(jBtnEliminarSondeo))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGuardarSondeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarSondeoActionPerformed
        // TODO add your handling code here:
        Date fechaSondeo = new Date();
        SimpleDateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
        
        try{
            fechaSondeo = formato.parse(jTfFechaSondeo.getText());
            System.out.println(fechaSondeo);
        } catch(Exception ex ){
           JOptionPane.showMessageDialog(this,"Error al guardar fecha", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        try{
            
        String coordenadas = jTfCoordenadasSondeo.getText();
        
        Proyecto idProyecto = new Proyecto();
        
        idProyecto.setIDProyecto(jTfIdProyect.getText());
        
        Sondeo sondeo = new Sondeo(idProyecto,fechaSondeo,coordenadas);
        
        dsondeo.guardarSondeo(sondeo);
        JOptionPane.showMessageDialog(this,"Registro Guardado", "Sondeo",JOptionPane.INFORMATION_MESSAGE);
         
        }catch(Exception ex){
        JOptionPane.showMessageDialog(this,"Error al guardar", "Sondeo",JOptionPane.WARNING_MESSAGE);
        }
       jTblRegistrosSondeos.setModel(dsondeo.mostrarSondeos(FrmSondeos.jTfIdProyect.getText()));  
       limpiar();
    }//GEN-LAST:event_jBtnGuardarSondeoActionPerformed

    private void jTblRegistrosSondeosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTblRegistrosSondeosKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            ubicarDatosSondeos();
        }
    }//GEN-LAST:event_jTblRegistrosSondeosKeyReleased

    private void jTblRegistrosSondeosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblRegistrosSondeosMouseClicked
        // TODO add your handling code here:
        ubicarDatosSondeos();
    }//GEN-LAST:event_jTblRegistrosSondeosMouseClicked

    private void jBtnEditarSondeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarSondeoActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
       // Proyecto proyecto, Date fecha, String coordenadas
        Proyecto idP = new Proyecto();
        idP.setIDProyecto(jTfIdProyect.getText());
        String coordenadas = jTfCoordenadasSondeo.getText();
        System.out.println(idP.getIDProyecto());
        //String coordenadasA = jTfCoordenadasSondeo.getText();
        
         // conversion fecha java a sq
         Date fechaSondeo = new Date();
         SimpleDateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
         
        try{
            
            fechaSondeo = formato.parse(jTfFechaSondeo.getText());
            Sondeo sondeo = new Sondeo(idP,fechaSondeo,coordenadas);
            dsondeo.editarSondeo(sondeo);
            limpiar();
            
            /*
            if(dsondeo.editarSondeo(sondeo)){
                JOptionPane.showMessageDialog(this, "Registro Editado.",
                "Sondeo",JOptionPane.INFORMATION_MESSAGE);
             }
            
            */
            
        } catch(Exception ex ){
           JOptionPane.showMessageDialog(this,"Error al guardar Sondeo", "Error",JOptionPane.WARNING_MESSAGE);
        }
        jTblRegistrosSondeos.setModel(dsondeo.mostrarSondeos(FrmSondeos.jTfIdProyect.getText()));  
        jBtnEditarSondeo.setEnabled(false);
        jBtnEliminarSondeo.setEnabled(false);
        jBtnGuardarSondeo.setEnabled(true);
        
    }//GEN-LAST:event_jBtnEditarSondeoActionPerformed

    private void jBtnEliminarSondeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarSondeoActionPerformed
        // TODO add your handling code here:
         this.verificarDatosVacios();
        int resp = JOptionPane.showConfirmDialog(this, "??Desea eliminar este registro?",
                "Sondeo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(resp ==0){
            if(dsondeo.eliminarSondeo(jTfCoordenadasSondeo.getText())){
                JOptionPane.showMessageDialog(this, "Sondeo Eliminado",
                        "Sondeo",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al eliminar",
                        "Sondeo",JOptionPane.WARNING_MESSAGE);
            }
        }
        jTblRegistrosSondeos.setModel(dsondeo.mostrarSondeos(FrmSondeos.jTfIdProyect.getText()));
        limpiar();
    }//GEN-LAST:event_jBtnEliminarSondeoActionPerformed

    private void jBtnMuestrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMuestrasActionPerformed
        // TODO add your handling code here:
        DMuestra dm = new DMuestra();
        FrmMuestras frm = new FrmMuestras();
        frm.setVisible(true);
        this.setVisible(false);
        frm.jTfIdSondeo.setText(this.jTfCoordenadasSondeo.getText());
        FrmMuestras.TblMuestras.setModel(dm.mostrarMuestras(jTfCoordenadasSondeo.getText()));
    }//GEN-LAST:event_jBtnMuestrasActionPerformed

    private void jBtnReg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReg1ActionPerformed
        // TODO add your handling code here:
        FrmDatosProyectos frmReg2 = new FrmDatosProyectos();
        frmReg2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnReg1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSondeos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSondeos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSondeos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSondeos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSondeos().setVisible(true);
            }
        });
    }
    
    private void ubicarDatosSondeos() {
        
        int fila = jTblRegistrosSondeos.getSelectedRow();
        Object coordenadas = this.jTblRegistrosSondeos.getValueAt(fila, 0);
        Object fecha = this.jTblRegistrosSondeos.getValueAt(fila, 1);
       

        String coordenadasSondeo = String.valueOf(coordenadas);
        String fechaSondeo = String.valueOf(fecha);
        //  Date  = String.valueOf(descripcion);
         /*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formato = simpleDateFormat.format(fecha);
        java.sql.Date fechaSondeo = java.sql.Date.valueOf(formato);
        */

        this.jTfCoordenadasSondeo.setText(coordenadasSondeo);
       // jTfCoordenadasSondeo.setEditable(false);
        this.jTfFechaSondeo.setText(fechaSondeo);

            jBtnGuardarSondeo.setEnabled(false);
            jBtnEditarSondeo.setEnabled(true);
            jBtnEliminarSondeo.setEnabled(true);
            jBtnMuestras.setEnabled(true);
          
    }
    
    private void verificarDatosVacios() {
        
        if (jTfCoordenadasSondeo.getText().equals("") || jTfCoordenadasSondeo.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que los campos"
                    + " no esten vac??os.", "Sondeo", JOptionPane.WARNING_MESSAGE);
            jTfCoordenadasSondeo.requestFocus();
            
        }
        
        if (jTfFechaSondeo.getText().equals("") || jTfFechaSondeo.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que los campos"
                    + " no esten vac??os.", "Sondeo", JOptionPane.WARNING_MESSAGE);
            jTfFechaSondeo.requestFocus();
            
        }
        
        
    }
    
    private void limpiar(){
        jTfCoordenadasSondeo.setText("");
        jTfFechaSondeo.setText("");
        jTfFechaSondeo.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditarSondeo;
    private javax.swing.JButton jBtnEliminarSondeo;
    private javax.swing.JButton jBtnGuardarSondeo;
    private javax.swing.JButton jBtnMuestras;
    private javax.swing.JButton jBtnReg1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTblRegistrosSondeos;
    private javax.swing.JTextField jTfCoordenadasSondeo;
    private javax.swing.JTextField jTfFechaSondeo;
    public static javax.swing.JTextField jTfIdProyect;
    public static javax.swing.JTextField jTfNomProyecto;
    // End of variables declaration//GEN-END:variables
}
