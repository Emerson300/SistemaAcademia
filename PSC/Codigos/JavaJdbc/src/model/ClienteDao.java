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
            stmt = con.prepareStatement("insert into cliente (nome,idade,telefone,sexo,peso,altura,estado,cidade,bairro,numero,rua)values(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getSexo());
            stmt.setFloat(5, cliente.getPeso());
            stmt.setFloat(6, cliente.getAltura());
            stmt.setString(7, cliente.getEstado());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getBairro());
            stmt.setInt(10,  cliente.getNumero());
            stmt.setString(11, cliente.getRua());
            
            
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "erro dao");
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
            stmt = con.prepareStatement("Select *from cliente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setPeso(rs.getFloat("peso"));
                cliente.setAltura(rs.getFloat("altura"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setRua(rs.getString("rua"));
            
                cliente.add(cliente);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
        
    }
}




