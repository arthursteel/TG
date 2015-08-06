/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author arthurtakashi
 */
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Login {
    Connection con;
    Statement st;
    ResultSet rs;
 
    JFrame f = new JFrame("login de usuario");
    JLabel u = new JLabel("nome de usuario");
    JLabel s = new JLabel("senha do usuario");
    JTextField t = new JTextField(12);
    JTextField t1 = new JTextField(12);
    JButton b = new JButton("login");
    
    //construtor
    public Login(){
        connect();
        frame();
    }

    //função de conecção
    public void connect() {
        try{
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName(driver);
            
            String db = "jdbc:odbc:login";
            con = DriverManager.getConnection(db);
            st = con.createStatement();
        }catch(Exception ex){
            System.out.println("falha no connect");
        }
    }

    //função de layout
    private void frame() {
        f.setSize(450, 369);//dimensionamento
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        JPanel p = new JPanel();
        p.add(u);
        p.add(t);
        p.add(s);
        p.add(t1);
        p.add(b);
        
        f.add(p);
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    String usuario = t.getText().trim();
                    String passe = t1.getText().trim();

                    String sql = "'selecionar usuario, senha de login onde usuario - '" +usuario+"'e senha = '" +passe+ "'";
                    int count = 0;
                    try {
                        while(rs.next()){
                            count += 1;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (count ==1){
                        JOptionPane.showMessageDialog(null, "usuario encontrado, acesso permitido");
                    }else if (count >1){
                        JOptionPane.showMessageDialog(null, "usuario duplicado, acesso negado");
                    }else{
                        JOptionPane.showMessageDialog(null, "usuario não encontrado");
                    }
            }catch(Exception ex) {
                System.out.println("erro de checagem");
            }
            }
        });
    }
    public static void main(String[] args){
        new Login();
    }
}
