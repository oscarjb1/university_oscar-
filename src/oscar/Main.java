/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oscar;

import ch.randelshofer.quaqua.QuaquaLookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author OSCAR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    //UIManager.setLookAndFeel(new QuaquaLookAndFeel());
                } catch (Exception e) {
                }
                new Menu().setVisible(true);
            }
        });
    }
}