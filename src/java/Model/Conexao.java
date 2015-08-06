/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthurtakashi
 */
import java.sql.*;

public class Conexao {
    //declaração das variaveis
    protected String sName = "localhost";
    protected String bancoDados = "mysql";
    protected String usuario = "host";
    protected String url = "jdbc:mysql://" + sName + "/" + bancoDados;
    protected String senha = "arthur";
    protected Connection conexao = null;
    protected static String status = "não conectado...";
    
    //cria um construtor
    public Conexao (){
        
    }
    
    //criação do metodo que realiza conexão com o banco
    public java.sql.Connection getConexaoMySQL() throws SQLException{
        try{
            conexao = DriverManager.getConnection(url, usuario, senha);
            String nomeDrive = "br.com.mysql.jdbc.Driver";
            Class.forName(nomeDrive);
            
            return conexao;
        }catch(ClassNotFoundException e){
            System.out.println("não foi possivel fazer a conexão com o banco de dados");
            return null;
        }
    }
    
    //criação do metodo que testa a conexão
    public java.sql.Connection testaConexao(){
        if (conexao != null){
            status = ("conexão efetuada com sucesso");
            
        }else{
            status = ("conexão não efetuada");
        }
        return conexao;
    }
    public static String statusConection(){//metodo de verificação de status de conecção
        return status;
    }
}
