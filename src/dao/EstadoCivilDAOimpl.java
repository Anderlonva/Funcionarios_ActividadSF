package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.EstadoCivil;
import utils.Mensajes;

/**
 *
 * @author Anderson Londoño
 */
public class EstadoCivilDAOimpl implements EstadoCivilDAO{

    private Conexion conexion = new Conexion();
    
    @Override
    public List<EstadoCivil> listarEstadoCivil() {
         List<EstadoCivil> estadosCivils = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        String sql = "select * from estado_civil";

        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EstadoCivil estadoCivil = new EstadoCivil();
                
                estadoCivil.setId(rs.getInt("id"));
                estadoCivil.setNombre(rs.getString("nombre"));
                estadoCivil.setDescripcion(rs.getString("descripcion"));
                
                estadosCivils.add(estadoCivil);
           }
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            Mensajes.mensajeError("Error Al Listar Estado Civil", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

        return estadosCivils;
    }

    
}
