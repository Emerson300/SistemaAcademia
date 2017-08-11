/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Despesa;
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
public class DespesaDao {
    public void Create(Despesa despesa) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into despesa ( nome,data,valor,obs) values (?,?,?,?)");
            stmt.setString(1, despesa.getNome());
            stmt.setDate(2, despesa.getData());
            stmt.setFloat(3, despesa.getValor());
            stmt.setString(4, despesa.getObs());
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Despesa");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Despesa> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Despesa> despesas =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from despesa");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Despesa despesa = new Despesa();
                
                despesa.setId(rs.getInt("id"));
                despesa.setNome(rs.getString("nome"));
                despesa.setData(rs.getDate("data"));
                despesa.setValor(rs.getFloat("valor"));
                despesa.setObs(rs.getString("obs"));
                
                despesas.add(despesa);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return despesas;
        
    }
    
     public void  Update(Despesa despesa){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update despesa Set nome=?,data=?,valor=?,obs=? Where id = ?");
            stmt.setString(1, despesa.getNome());
            stmt.setDate(2, despesa.getData());
            stmt.setFloat(3, despesa.getValor());
            stmt.setString(4, despesa.getObs());
            
            stmt.setInt(5, despesa.getId());
            
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso!");
             
            //seila
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    public void  Delete(Despesa despesa){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from despesa where id = ?");
             stmt.setInt(1, despesa.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Despesa Excluida com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Avaliação!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    
}
