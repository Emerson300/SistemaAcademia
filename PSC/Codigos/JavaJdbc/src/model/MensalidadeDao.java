/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Mensalidade;
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
public class MensalidadeDao {
    public void Create(Mensalidade mensalidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into mensalidade ( nome,data,valor,obs) values (?,?,?,?)");
            stmt.setString(1, mensalidade.getNome());
            stmt.setDate(2, mensalidade.getData());
            stmt.setFloat(3, mensalidade.getValor());
            stmt.setString(4, mensalidade.getObs());
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Mensalidade");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Mensalidade> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Mensalidade> mensalidades =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from mensalidade");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Mensalidade mensalidade = new Mensalidade();
                
                mensalidade.setId(rs.getInt("id"));
                mensalidade.setNome(rs.getString("nome"));
                mensalidade.setData(rs.getDate("data"));
                mensalidade.setValor(rs.getFloat("valor"));
                mensalidade.setObs(rs.getString("obs"));
                
                mensalidades.add(mensalidade);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return mensalidades;
        
    }
    
     public void  Update(Mensalidade mensalidade){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update mensalidade Set nome=?,data=?,valor=?,obs=? Where id = ?");
            stmt.setString(1, mensalidade.getNome());
            stmt.setDate(2, mensalidade.getData());
            stmt.setFloat(3, mensalidade.getValor());
            stmt.setString(4, mensalidade.getObs());
            
            stmt.setInt(5, mensalidade.getId());
            
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
   
    public void  Delete(Mensalidade mensalidade){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from mensalidade where id = ?");
             stmt.setInt(1, mensalidade.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Mensalidade Excluida com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Avaliação!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}
