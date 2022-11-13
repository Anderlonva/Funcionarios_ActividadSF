package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Funcionario;
import utils.Mensajes;

/**
 *
 * @author Anderson Londoño
 */
public class FuncionarioDAOimpl implements FuncionarioDAO {

    Conexion conexion;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "select numero_identificacion, tipo_identificacion.descripcion, nombres, apellidos, estado_civil.nombre, sexo, direccion, telefono, fecha_nacimiento, fecha_creacion, fecha_actualizacion\n"
                + " from funcionarios join tipo_identificacion \n"
                + "on funcionarios.tipo_identificacion = tipo_identificacion.id join estado_civil \n"
                + "on funcionarios.estado_civil = estado_civil.id;";
        String sql2 = "select * from funcionarios;";
        try {
            conexion = new Conexion();
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setDocumento(rs.getInt("numero_identificacion"));
                funcionario.setNombre(rs.getString("nombres"));
                funcionario.setApellido(rs.getString("apellidos"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));

                funcionarios.add(funcionario);
            }
            con.close();
            ps.close();
            rs.close();

        } catch (SQLException e) {
            Mensajes.mensajeError("Error Al Listar Los funcionarios", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

        return funcionarios;

    }

    @Override
    public Funcionario buscarPorId(String documento) {
        Funcionario funcionario = new Funcionario();
        String sql = "select * from funcionarios where numero_identificacion = ?";

        try {
            conexion = new Conexion();
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();

            if (rs.first()) {
                funcionario.setDocumento(rs.getInt("numero_identificacion"));
                funcionario.setNombre(rs.getString("nombres"));
                funcionario.setApellido(rs.getString("apellidos"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
            }

            con.close();
            ps.close();
            rs.close();

        } catch (Exception e) {

            Mensajes.mensajeError("Error Al Buscar Por Id el funcionario", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

        return funcionario;
    }

    @Override
    public int guardar(Funcionario funcionario) {
        int resultado = 0;
        String sql = "insert into funcionarios (numero_identificacion,tipo_identificacion,nombres, apellidos, "
                + "estado_civil,sexo,direccion,telefono,fecha_nacimiento,fecha_creacion,fecha_actualizacion)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, localtime(), localtime())";

        try {
            conexion = new Conexion();
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, funcionario.getDocumento());
            ps.setInt(2, funcionario.getTipoIdentificacion().getId());
            ps.setString(3, funcionario.getNombre());
            ps.setString(4, funcionario.getApellido());
            ps.setInt(5, funcionario.getEstadoCivil().getId());
            ps.setString(6, funcionario.getSexo());
            ps.setString(7, funcionario.getDireccion());
            ps.setString(8, funcionario.getTelefono());
            ps.setString(9, funcionario.getFechaNacimiento().toString());

            resultado = ps.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario Guardado con éxito");
                ps.close();
                conexion.getConnection().close();

            }

        } catch (SQLException e) {

            Mensajes.mensajeError("Error Al Guardar El funcionario", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

        return resultado;
    }

    @Override
    public int actualizar(Funcionario funcionario) {
        int resultado = 0;
        int documento = funcionario.getDocumento();
        String sql = "update funcionarios set tipo_identificacion = ?,nombres = ?, apellidos = ?, "
                + "estado_civil = ?,sexo = ?,direccion = ?,telefono = ?,fecha_nacimiento = ?,fecha_actualizacion  = localtime()"
                + "where numero_identificacion = "+ documento;

        try {
            conexion = new Conexion();
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, funcionario.getTipoIdentificacion().getId());
            ps.setString(2, funcionario.getNombre());
            ps.setString(3, funcionario.getApellido());
            ps.setInt(4, funcionario.getEstadoCivil().getId());
            ps.setString(5, funcionario.getSexo());
            ps.setString(6, funcionario.getDireccion());
            ps.setString(7, funcionario.getTelefono());
            ps.setString(8, funcionario.getFechaNacimiento().toString());
            
            resultado = ps.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario Actualizado con éxito");
            }

            con.close();
            ps.close();

        } catch (SQLException e) {
            Mensajes.mensajeError("Error Al Actualizar El funcionario", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

        return resultado;
    }

    @Override
    public void borrar(int documento) {

        int resultado = 0;
        String sql = "delete from funcionarios where numero_identificacion = ?";

        try {
            conexion = new Conexion();
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, documento);
            resultado = ps.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario Eliminado con éxito");
            }
            con.close();
            ps.close();

        } catch (Exception e) {

            Mensajes.mensajeError("Error Al Eliminar El funcionario", e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error en la conexion con la base de datos");
        }

    }
}
