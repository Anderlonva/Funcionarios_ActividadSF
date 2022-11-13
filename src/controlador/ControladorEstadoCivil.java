package controlador;

import dao.EstadoCivilDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.EstadoCivil;

/**
 *
 * @author Anderson Londoño
 */
public class ControladorEstadoCivil {
    
    private EstadoCivilDAO estadoCivilDAO;

    public ControladorEstadoCivil(EstadoCivilDAO estadoCivilDAO) {
        this.estadoCivilDAO = estadoCivilDAO;
    }
    
    public DefaultComboBoxModel llenarSelectEstadoCivil(){
    
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<EstadoCivil> estadoCivils = estadoCivilDAO.listarEstadoCivil();
        for(EstadoCivil e : estadoCivils){
        
            modelo.addElement(e.getNombre());
            
        }
         
         
         
        return modelo;
    }
}
