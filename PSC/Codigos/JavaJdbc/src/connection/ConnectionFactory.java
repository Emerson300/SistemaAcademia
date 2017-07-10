/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author emerson
 */
public class ConnectionFactory {
    private static final String Driver ="com.mysql.jdbc.Driver";
    private static final String Url ="jdbc:mysql://localhost:3306/dbProjeto";
    private static final String User ="root";
    private static final String Pass ="root";
    
  
    public static Connection getConnection() {
        try {
            Class.forName(Driver);
            return DriverManager.getConnection (Url, User, Pass);
      
        }catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro na Conexao",ex);
        }
        
    }   
            
    public static void closeConnection (Connection con){
       
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro"+ex);
            }
        }
  
    }     
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
       
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro"+ex);
            }
        }
        closeConnection(con);
    }   
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
       
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro"+ex);
            }
        }
        closeConnection(con,stmt);
    }    
    
}
