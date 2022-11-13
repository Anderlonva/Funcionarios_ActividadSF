package controlador;

import dao.TipoIdentificacionDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.TipoIdentificacion;

/**
 *
 * @author Anderson Londoño
 */
public class ControladorTipoIdentificacion {
    
    private TipoIdentificacionDAO identificacionDAO;

    public ControladorTipoIdentificacion() {
    }
    
    public ControladorTipoIdentificacion(TipoIdentificacionDAO identificacionDAO) {
        this.identificacionDAO = identificacionDAO;
    }
    
    public DefaultComboBoxModel llenarSelectTipoIdentificacion(){
    
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<TipoIdentificacion> listaTiposID = identificacionDAO.listarTiposIdentificacion();
        for(TipoIdentificacion t : listaTiposID ){
        
            modelo.addElement(t.getDescripcion());
            
        }
        
        return modelo;
    }
    
}
