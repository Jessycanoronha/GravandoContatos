/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jessyca.agenda.servlet;

import br.com.jessyca.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Jessyca
 */
public class ContatoDAO {
    
    private Connection connection;
    
    public ContatoDAO() throws SQLException{
        this.connection = new ConnectionFactory().getConnection();
    
    }
    
    
    public void adiciona(Contato contato) {
        String sql="insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(1,contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, (java.sql.Date) new Date(contato.getDataNascimento().getTimeInMillis()));
            
            stmt.execute();
            stmt.close();
            
        
        }catch(SQLException e){
            throw new RuntimeException(e);
    
    
    }
    
    }
    
    
    
}
