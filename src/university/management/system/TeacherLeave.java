package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener{
    
    Choice cempid, ctime;
    JTextField tfx;
    JDateChooser dcdate;
    JButton submit,cann;
    
    TeacherLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.orange);
        
        JLabel heading = new JLabel("Apply Leave(Teacher)");
        heading.setBounds(40,30,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        
        JLabel lbempid = new JLabel("Search by Employee Id");
        lbempid.setBounds(60,100,250,20);
        lbempid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbempid);
        
        cempid = new Choice();
        cempid.setBounds(60,130,200,20);
        add(cempid);
        
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbdate = new JLabel("Date");
        lbdate.setBounds(60,180,250,20);
        lbdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbdate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);
        
        JLabel lbday = new JLabel("How many days");
        lbday.setBounds(60, 260, 250, 20);
        lbday.setFont(new Font("serif",Font.PLAIN,20));
        add(lbday);
        
        tfx = new JTextField();
        tfx.setBounds(60, 290, 100, 25);
        add(tfx);
        
        JLabel lbtime = new JLabel("Time Duration");
        lbtime.setBounds(60,340,220,20);
        lbtime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbtime);
        
        ctime = new Choice();
        ctime.setBounds(60,370,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 435, 100, 25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,20));
        add(submit);
        
        cann = new JButton("Cancel");
        cann.setBounds(200, 435, 100, 25);
        cann.setBackground(Color.blue);
        cann.setForeground(Color.white);
        cann.addActionListener(this);
        cann.setFont(new Font("serif",Font.BOLD,20));
        add(cann);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == submit){
               String empid = cempid.getSelectedItem();
               String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
               String day = tfx.getText();
               String duration = ctime.getSelectedItem();
               
               String query = "insert into teacherleave values('" +empid+ "','" +date+ "','" +day+ "','" +duration+ "')";
               
               try{
                    ConnectionF conn = new ConnectionF();
                    conn.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Leave Confiemed");
                    setVisible(false);
               }
               catch(Exception e){
                   e.printStackTrace();
                   
               }
            }
            else{
                setVisible(false);
            }
        }
    
    public static void main (String[] args){
        TeacherLeave sl = new TeacherLeave();
    }
    
}
