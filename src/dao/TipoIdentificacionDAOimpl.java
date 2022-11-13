package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.TipoIdentificacion;
import utils.Mensajes;

/**
 *
 * @author Anderson Londoño
 */
public class TipoIdentificacionDAOimpl implements TipoIdentificacionDAO {

    private Conexion conexion = new Conexion();

    @Override
    public List<TipoIdentificacion> listarTiposIdentificacion() {

        List<TipoIdentificacion> tiposIdentificacion = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        String sql = "select * from tipo_identificacion";

        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
                
                tipoIdentificacion.setId(rs.getInt("id"));
                tipoIdentificacion.setNombre(rs.getString("nombre"));
                tipoIdentificacion.setDescripcion(rs.getString("descripcion"));
                
                tiposIdentificacion.add(tipoIdentificacion);
           }
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            
            Mensajes.mensajeError("Error Al Listar Los Tipos de Id", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

        return tiposIdentificacion;

    }

}
