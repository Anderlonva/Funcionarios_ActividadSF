package controlador;

import dao.FuncionarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Funcionario;

/**
 *
 * @author Anderson Londoño
 */
public class ControladorFuncionario {
    
    private FuncionarioDAO funcionarioDAO;

    public ControladorFuncionario(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }
    
     public DefaultTableModel llenarTabla(){
     
         DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        model.addColumn("Documento");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Sexo");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        model.addColumn("Fecha Nacimiento");
        List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
        String [] registros = new String[7];
        for (Funcionario f: funcionarios){
            registros[0] = String.valueOf(f.getDocumento());
            registros[1] = f.getNombre();
            registros[2] = f.getApellido();
            registros[3] = f.getSexo();
            registros[4] = f.getDireccion();
            registros[5] = f.getTelefono();
            registros[6] = f.getFechaNacimiento().toString();
            model.addRow(registros);
        }
        return model;
     
     }
     
     public int guardarFuncionario(Funcionario funcionario){
     
         return funcionarioDAO.guardar(funcionario);
         
     }
     
     public Funcionario listaPorDocumento(String documento){
     
         return funcionarioDAO.buscarPorId(documento);
     }
     
     public int actualizar(Funcionario funcionario){
     
         return funcionarioDAO.actualizar(funcionario);
     
     }
     
     public void borrar(int documento) {
     
         funcionarioDAO.borrar(documento);
     }
     
}
