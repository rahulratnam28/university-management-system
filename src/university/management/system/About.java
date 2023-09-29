package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    
    About(){
        setSize(800,550);
        setLocation(400,150);
        getContentPane().setBackground(Color.pink);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/amitycap.jpg"));
        Image i2 = i1.getImage().getScaledInstance(320, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 500, 300);
        add(image);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(50, 20, 300, 150);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel name = new JLabel("Devloped By: Rahul Ratnam");
        name.setBounds(70, 250, 550, 40);
        name.setFont(new Font("Tahoma",Font.BOLD,30));
        add(name);
        
        JLabel roll = new JLabel("Roll Number: A453145022026");
        roll.setBounds(70, 300, 550, 40);
        roll.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(roll);
        
        JLabel cls = new JLabel("Class: MCA-III");
        cls.setBounds(70, 350, 550, 40);
        cls.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(cls);
        
        JLabel eml = new JLabel("Contact: rhlrtnm@gmail.com");
        eml.setBounds(70, 400, 550, 40);
        eml.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(eml);
        
        
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String [] args){
        About a = new About();
    }
    
}
