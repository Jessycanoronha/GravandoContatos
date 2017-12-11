/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jessyca.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jessyca
 */
public class ConnectionFactory {
    
    String url = "jdbc:derby://localhost:1527/contato";
    String login ="root";
    String senha="root";
    
    
    public Connection getConnection() throws SQLException{
        try{
            return DriverManager.getConnection(url,login,senha);
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    
    }
    
}
