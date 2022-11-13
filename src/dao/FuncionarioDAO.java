package dao;

import java.util.List;
import modelo.Funcionario;

/**
 *
 * @author Anderson Londoño
 */
public interface FuncionarioDAO {
    
    List<Funcionario> listarFuncionarios();
    
    Funcionario buscarPorId(String documento);
    
    int guardar(Funcionario funcionario);
    
    int actualizar(Funcionario funcionario);
    
    void borrar(int documento);
}
