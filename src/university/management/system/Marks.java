package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton cancel;
    JTable table;
    
    Marks(String rollno){
        this.rollno = rollno;
        
        setSize(500,600);
        setLocation(500,100);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.pink);
        
        JLabel heading = new JLabel("Amity University");
        heading.setBounds(120, 10, 500, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2023");
        subheading.setBounds(90, 60, 500, 25);
        subheading.setFont(new Font("Tahoma",Font.BOLD,22));
        add(subheading);
        
        JLabel lbroll = new JLabel("Roll Number: "+rollno);
        lbroll.setBounds(60, 110, 500, 25);
        lbroll.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lbroll);
        
        JLabel lbsem = new JLabel();
        lbsem.setBounds(60, 140, 500, 25);
        lbsem.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbsem);
        
        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 25);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 25);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 25);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 25);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 25);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);
        
        JLabel sub6 = new JLabel();
        sub6.setBounds(100, 350, 500, 25);
        sub6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub6);
        
        JLabel sub7 = new JLabel();
        sub7.setBounds(100, 380, 500, 25);
        sub7.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub7);
        
        JLabel sub8 = new JLabel();
        sub8.setBounds(100, 410, 500, 25);
        sub8.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub8);
        
        try{
            ConnectionF conn = new ConnectionF();
            
            ResultSet rs1 = conn.stm.executeQuery("select * from subject where rollno = '"+rollno+"' ");
            
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                sub6.setText(rs1.getString("subject6"));
                sub7.setText(rs1.getString("subject7"));
                sub8.setText(rs1.getString("subject8"));
            }
            ResultSet rs2 = conn.stm.executeQuery("select * from marks where rollno = '"+rollno+"' ");
            
            while(rs2.next()){
                sub1.setText(sub1.getText() +"--------"+ rs2.getString("mark1"));
                sub2.setText(sub2.getText() +"--------"+ rs2.getString("mark2"));
                sub3.setText(sub3.getText() +"--------"+ rs2.getString("mark3"));
                sub4.setText(sub4.getText() +"--------"+ rs2.getString("mark4"));
                sub5.setText(sub5.getText() +"--------"+ rs2.getString("mark5"));
                sub6.setText(sub6.getText() +"--------"+ rs2.getString("mark6"));
                sub7.setText(sub7.getText() +"--------"+ rs2.getString("mark7"));
                sub8.setText(sub8.getText() +"--------"+ rs2.getString("mark8"));
                
                lbsem.setText("Semester: "+ rs2.getString("semester"));
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        Marks ms = new Marks("");
    }
}
