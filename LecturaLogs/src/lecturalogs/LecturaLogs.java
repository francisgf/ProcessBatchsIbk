/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturalogs;

import com.lectura.logs.entities.Logs;
import com.lectura.logs.logic.LecturaLogsInterface;
import com.lectura.logs.logic.impl.LecturaLogsImpl;
import com.lectura.logs.view.ViewPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 15-AX222LA
 */
public class LecturaLogs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            LecturaLogsInterface lectura = new LecturaLogsImpl();
            Logs log = lectura.filterError(null, args.length > 0 ? args[0] : "")
                    .stream()
                    .findFirst()
                    .orElseThrow(Exception::new);

            int resp = JOptionPane.showConfirmDialog(null, "Ha ocurrido un error al ejecutar los Bacheros: \n" + log.getText() + "\n ¿Desea visualizar los logs?", "ERROR", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (resp == 0) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        ViewPrincipal viewPrincipal = new ViewPrincipal();
                        viewPrincipal.setPath(args.length > 0 ? args[0] : "");
                        viewPrincipal.setVisible(true);
                    }
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se encontró errores en el proceso", "Información", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(LecturaLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
