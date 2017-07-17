        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

import Entidades.Cliente;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author emerson
 */
public class ClienteDao{

    public void Create(Cliente cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into cliente (nome,idade,sexo,altura,peso,estado,cidade,bairro,numero,rua,telefone)values(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getSexo());
            stmt.setFloat(4, cliente.getPeso());
            stmt.setFloat(5, cliente.getAltura());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getBairro());
            stmt.setInt(9, cliente.getNumero());
            stmt.setString(10, cliente.getRua());
            stmt.setString(11, cliente.getTelefone());
            
            
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Cliente> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Cliente> clientes =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from cliente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setPeso(rs.getFloat("peso"));
                cliente.setAltura(rs.getFloat("altura"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setRua(rs.getString("rua"));
                cliente.setTelefone(rs.getString("telefone"));
                
                clientes.add(cliente);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
        
    }
    
    public void  Delete(Cliente cliente){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete * from Cliente where id = ?");
             stmt.setInt(1, cliente.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Cliente Excluido com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Cliente!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}