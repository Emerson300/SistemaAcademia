/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Consulta;
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
public class ConsultaDao {
    
    
    public void Create(Consulta consulta) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into consulta (nomeCliente,nomeFuncionario,datas,obs)values(?,?,?,?)");
            stmt.setString(1, consulta.getNomeCliente());
            stmt.setString(2, consulta.getNomeFuncionario());
            stmt.setDate(3, consulta.getDatas());
            //stmt.setTime(4, consulta.getHorario());
            stmt.setString(4, consulta.getObs());
            
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Consulta");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Consulta> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Consulta> consultas =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from consulta");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Consulta consulta = new Consulta();
                
                consulta.setId(rs.getInt("id"));
                consulta.setNomeCliente(rs.getString("nomeCliente"));
                consulta.setNomeFuncionario(rs.getString("nomeFuncionario"));
                consulta.setDatas(rs.getDate("datas"));
               // consulta.setHorario(rs.getTime("horario"));
                consulta.setObs(rs.getString("obs"));
                
                consultas.add(consulta);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return consultas;
        
    }
    
     public void  Update(Consulta consulta){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update consulta Set nomeCliente=?,nomeFuncionario=?,obs=? Where id = ?");
            stmt.setString(1, consulta.getNomeCliente());
            stmt.setString(2, consulta.getNomeFuncionario());
            stmt.setDate(3, consulta.getDatas());
           // stmt.setTime(4, consulta.getHorario());
            stmt.setString(4, consulta.getObs());
            
            stmt.setInt(5, consulta.getId());
            
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    public void  Delete(Consulta consulta){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from consulta where id = ?");
             stmt.setInt(1, consulta.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Consulta Excluida com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Consulta!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
