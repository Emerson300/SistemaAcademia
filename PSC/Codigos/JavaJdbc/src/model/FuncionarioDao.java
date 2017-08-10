/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Funcionario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author emerson
 */
public class FuncionarioDao {
    
    
    public void Create(Funcionario funcionario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into funcionario (nome,cpf,rg,estado,cidade,bairro,numero,rua,telefone,salario)values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, funcionario.getEstado());
            stmt.setString(5, funcionario.getCidade());
            stmt.setString(6, funcionario.getBairro());
            stmt.setString(7, funcionario.getNumero());
            stmt.setString(8, funcionario.getRua());
            stmt.setString(9, funcionario.getTelefone());
            stmt.setFloat(10, funcionario.getSalario());
            
            
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Funcionario");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Funcionario> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Funcionario> funcionarios =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSalario(rs.getFloat("salario"));
                
                funcionarios.add(funcionario);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
        
    }
    
     public void  Update(Funcionario funcionario){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update funcionario Set nome=?,cpf=?,rg=?,estado=?,cidade=?,bairro=?,numero=?,rua=?,telefone=?,salario=? Where id = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, funcionario.getEstado());
            stmt.setString(5, funcionario.getCidade());
            stmt.setString(6, funcionario.getBairro());
            stmt.setString(7, funcionario.getNumero());
            stmt.setString(8, funcionario.getRua());
            stmt.setString(9, funcionario.getTelefone());
            stmt.setFloat(10, funcionario.getSalario());
            stmt.setInt(11, funcionario.getId());
            
            stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    public void  Delete(Funcionario funcionario){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from funcionario where id = ?");
             stmt.setInt(1, funcionario.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Funcionario Excluido com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Funcionario!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}
