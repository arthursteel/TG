package Model;

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
public class Usuario {
    public Connection conectarBD(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=arthur&password=123";
            conn = DriverManager.getConnection(url);
        }catch(Exception e){}
        return conn;
    }
    public String nome="";
    public boolean result = false;
    public boolean verificarUsuario(String login, String senha){
        String sql = "";
        Connection conn = conectarBD();
        sql += "select nome from usuarios ";
        sql += "onde login =" + "'" + login + "'";
        sql += "e senha =" + "'" + senha + "'";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                result = true;
                nome = rs.getString("nome");
            }
        }catch (Exception e){
            
        }
        return result;
    }
}
