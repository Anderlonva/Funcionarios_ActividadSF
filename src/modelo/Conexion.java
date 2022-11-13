package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utils.Mensajes;

/**
 *
 * @author Anderson Londoño
 */
public class Conexion {
    
   private Connection con;
    
    public Conexion(){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/actividad_softwareSeguro?serverTimezone=UTC", "root", "thiago21");
                            // se agrega en la libreria conector 8.0 y se cuadra la zona horaria en la base de datos  
        } catch (ClassNotFoundException | SQLException e) {
           
            Mensajes.mensajeError("Error de conexion ", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error: "+e, "Acceso a la base de datos", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    public Connection getConnection(){
        return con;
    }
}
