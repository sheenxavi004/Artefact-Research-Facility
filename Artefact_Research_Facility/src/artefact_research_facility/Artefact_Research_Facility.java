/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefact_research_facility;

import javax.swing.UIManager;

/**
 *
 * @author sheenxavi004
 */
public class Artefact_Research_Facility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    try {
            // Set System L&F
    try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new LogIn();
    } 
    catch(Exception e) {
        System.out.println(e);
    }
    
  }
    
}
