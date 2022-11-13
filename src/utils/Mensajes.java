package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Anderson Londoño
 */
public interface Mensajes {
    
    public static  boolean  mensajeConfirmacion(String titulo, String mensaje){
    
        JOptionPane jOptionPane = new JOptionPane();
        
        return jOptionPane.showConfirmDialog(null, mensaje, titulo, jOptionPane.YES_NO_OPTION) == jOptionPane.YES_OPTION;
    }
    
    public static void mensajeError(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
}
