/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jessyca.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jessyca
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
            }
        
        
        
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           
                // busca o writer
               
                                
                // buscando os parâmetros no request
                String nome = request.getParameter("nome");
                String endereco = request.getParameter("endereco");
                String email = request.getParameter("email");
                String dataEmTexto = request
                        .getParameter("dataNascimento");
                Calendar dataNascimento = null;
                
                // fazendo a conversão da data
                try {
                    Date date = 
                            new SimpleDateFormat("dd/MM/yyyy")
                            .parse(dataEmTexto);
                    dataNascimento = Calendar.getInstance();
                    dataNascimento.setTime(date);
                } catch (ParseException e) {
                    out.println("Erro de conversão da data");
                    return; //para a execução do método
                }
                
                // monta um objeto contato
                Contato contato = new Contato();
                contato.setNome(nome);
                contato.setEndereco(endereco);
                contato.setEmail(email);
                contato.setDataNascimento(dataNascimento);
                
                // salva o contato
                
        try {
            ContatoDAO dao;
            dao = new ContatoDAO();
            dao.adiciona(contato);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdicionaContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                
                // imprime o nome do contato que foi adicionado
                out.println("<html>");
                out.println("<body>");
                out.println("Contato " + contato.getNome() +
                        " adicionado com sucesso");
                out.println("</body>");
                out.println("</html>");
        }
    }

 

