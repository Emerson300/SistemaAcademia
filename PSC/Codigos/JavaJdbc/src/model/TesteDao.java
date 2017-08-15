/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Teste;
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
public class TesteDao {
     public void Create(Teste teste) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into teste ( nome,nomeProfessor,data,obs) values (?,?,?,?)");
            stmt.setString(1, teste.getNome());
            stmt.setString(2, teste.getNomeProfessor());
            stmt.setDate(3, teste.getData());
            stmt.setString(4, teste.getObs());
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Agendar Teste");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Teste> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Teste> testes =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from teste");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Teste teste = new Teste();
                
                teste.setId(rs.getInt("id"));
                teste.setNome(rs.getString("nome"));
                teste.setNomeProfessor(rs.getString("nomeProfessor"));
                teste.setData(rs.getDate("data"));
                teste.setObs(rs.getString("obs"));
                
                testes.add(teste);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return testes;
        
    }
    
     public void  Update(Teste teste){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update teste Set nome=?,nomeProfessor=?,data=?,obs=? Where id = ?");
            stmt.setString(1, teste.getNome());
            stmt.setDate(2, teste.getData());
            stmt.setString(3, teste.getNomeProfessor());
            stmt.setString(4, teste.getObs());
            
            stmt.setInt(5, teste.getId());
            
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
   
    public void  Delete(Teste teste){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from teste where id = ?");
             stmt.setInt(1, teste.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Teste de carga Excluido com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Teste de Carga!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}
