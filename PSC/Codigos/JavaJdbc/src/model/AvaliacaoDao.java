/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Avaliacao;
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
public class AvaliacaoDao {
    
     public void Create(Avaliacao avaliacao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into avaliacao (nome,altura,peso,bracoDir,bracoEsq,antiBracoDir,antiBracoEsq,pernaDir,pernaEsq,coxaDir,coxaEsq,Abdomen,\n" +
"                                       cintura,quadril,subescapular,triceps,suprailiaca,abdomenDobra,radio,femur,obs)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, avaliacao.getNome());
            stmt.setString(2, avaliacao.getAltura());
            stmt.setString(3, avaliacao.getPeso());
            stmt.setString(4, avaliacao.getBracoDir());
            stmt.setString(5, avaliacao.getBracoEsq());
            stmt.setString(6, avaliacao.getAntiBracoDir());
            stmt.setString(7, avaliacao.getAntiBracoEsq());
            stmt.setString(8, avaliacao.getPernaDir());
            stmt.setString(9, avaliacao.getPernaEsq());
            stmt.setString(10, avaliacao.getCoxaDir());
            stmt.setString(11, avaliacao.getCoxaEsq());
            stmt.setString(12, avaliacao.getAbdomen());
            stmt.setString(13, avaliacao.getCintura());
            stmt.setString(14, avaliacao.getQuadril());
            stmt.setString(15, avaliacao.getSubescapular());
            stmt.setString(16, avaliacao.getSuprailiaca());
            stmt.setString(17, avaliacao.getTriceps());
            stmt.setString(18, avaliacao.getAbdomenDobra());
            stmt.setString(19, avaliacao.getRadio());
            stmt.setString(20, avaliacao.getFemur());
            stmt.setString(21, avaliacao.getObs());
            
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Avaliação");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Avaliacao> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Avaliacao> avaliacoes =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from avaliacao");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Avaliacao avaliacao = new Avaliacao();
                
                avaliacao.setId(rs.getInt("id"));
                avaliacao.setNome(rs.getString("nome"));
                avaliacao.setAltura(rs.getString("altura"));
                avaliacao.setPeso(rs.getString("peso"));
                avaliacao.setBracoDir(rs.getString("bracoDir"));
                avaliacao.setBracoEsq(rs.getString("bracoEsq"));
                avaliacao.setAntiBracoDir(rs.getString("antiBracoDir"));
                avaliacao.setAntiBracoEsq(rs.getString("antiBracoEsq"));
                avaliacao.setPernaDir(rs.getString("pernaDir"));
                avaliacao.setPernaEsq(rs.getString("pernaEsq"));
                avaliacao.setCoxaDir(rs.getString("coxaDir"));
                avaliacao.setCoxaEsq(rs.getString("coxaEsq"));
                avaliacao.setAbdomen(rs.getString("abdomen"));
                avaliacao.setCintura(rs.getString("cintura"));
                avaliacao.setQuadril(rs.getString("quadril"));
                avaliacao.setSubescapular(rs.getString("subescapular"));
                avaliacao.setSuprailiaca(rs.getString("suprailiaca"));
                avaliacao.setTriceps(rs.getString("triceps"));
                avaliacao.setAbdomenDobra(rs.getString("abdomenDobra"));
                avaliacao.setRadio(rs.getString("radio"));
                avaliacao.setFemur(rs.getString("femur"));
                avaliacao.setObs(rs.getString("Obs"));
                
                avaliacoes.add(avaliacao);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacoes;
        
    }
    
     public void  Update(Avaliacao avaliacao){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update avaliacao Set nome=?,altura=?,peso=?,bracoDir=?,bracoEsq=?,antiBracoDir=?,antiBracoEsq=?,pernaDir=?,pernaEsq=?,coxaDir=?,coxaEsq=?,abdomen=?,\n" +
"                                       cintura=?,quadril=?,subescapular=?,triceps=?,suprailiaca=?,abdomenDobra=?,radio=?,femur=?,obs=? Where id = ?");
            stmt.setString(1, avaliacao.getNome());
            stmt.setString(2, avaliacao.getAltura());
            stmt.setString(3, avaliacao.getPeso());
            stmt.setString(4, avaliacao.getBracoDir());
            stmt.setString(5, avaliacao.getBracoEsq());
            stmt.setString(6, avaliacao.getAntiBracoDir());
            stmt.setString(7, avaliacao.getAntiBracoEsq());
            stmt.setString(8, avaliacao.getPernaDir());
            stmt.setString(9, avaliacao.getPernaEsq());
            stmt.setString(10, avaliacao.getCoxaDir());
            stmt.setString(11, avaliacao.getCoxaEsq());
            stmt.setString(12, avaliacao.getAbdomen());
            stmt.setString(13, avaliacao.getCintura());
            stmt.setString(14, avaliacao.getQuadril());
            stmt.setString(15, avaliacao.getSubescapular());
            stmt.setString(16, avaliacao.getSuprailiaca());
            stmt.setString(17, avaliacao.getTriceps());
            stmt.setString(18, avaliacao.getAbdomenDobra());
            stmt.setString(19, avaliacao.getRadio());
            stmt.setString(20, avaliacao.getFemur());
            stmt.setString(21, avaliacao.getObs());
            
            stmt.setInt(22, avaliacao.getId());
            
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
   
    public void  Delete(Avaliacao avaliacao){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from avaliacao where id = ?");
             stmt.setInt(1, avaliacao.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Avaliação Excluida com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Avaliação!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}
