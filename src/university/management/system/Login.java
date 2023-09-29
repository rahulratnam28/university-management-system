package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login, can; //Globally declare
    JTextField tfuser,  pfpass;
   
    Login(){
        
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        
        JLabel lbuser = new JLabel("Username");
        lbuser.setBounds(40,20, 100, 25);
        add(lbuser);
        
        tfuser = new JTextField();
        tfuser.setBounds(150, 20, 150, 25);
        add(tfuser);
        
        
        
        JLabel lbpass = new JLabel("Password");
        lbpass.setBounds(40,70, 100, 25);
        add(lbpass);
        
        pfpass = new  JPasswordField();
        pfpass.setBounds(150, 70, 150, 25);
        add(pfpass);
        
        login = new JButton("Submit");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,20));
        add(login);
        
        can = new JButton("Cancel");
        can.setBounds(180, 140, 120, 30);
        can.setBackground(Color.blue);
        can.setForeground(Color.white);
        can.addActionListener(this);
        can.setFont(new Font("serif",Font.BOLD,20));
        add(can);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);
        
        setSize(600,300);
        setLocation(500, 250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent af){
        if(af.getSource() == login){
        String username = tfuser.getText();
        String password = pfpass.getText();
        
        String query = "select * from login where username= '"+username+"' and password= '"+ password+"'";
        
        try{
            ConnectionF conn = new ConnectionF();
           ResultSet rs = conn.stm.executeQuery(query);
           
           if(rs.next()){
               setVisible(false);
               Project p =new Project();
           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid User");
               setVisible(false);
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else if (af.getSource() == can){
        setVisible(false);
    }
    }
   
    public static void main(String [] args){
        Login l = new Login();
    }
}
