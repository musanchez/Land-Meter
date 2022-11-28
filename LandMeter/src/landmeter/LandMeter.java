/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package landmeter;

import formularios.FrmInicio;
import static java.time.Clock.system;
/**
 *
 * @author megan
 */
public class LandMeter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String id = "1";
        //String Consulta = "SELECT COORDENADAS, FECHA FROM [GENERAL].[SONDEO] WHERE ID_PROYECTO ="+id;
        //System.out.println(Consulta);
       FrmInicio frm = new FrmInicio();
       
       frm.setVisible(true);
        
    }
    
}
