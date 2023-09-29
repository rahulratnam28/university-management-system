package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class PayFee extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsem;
    JLabel lbtoatl;
    JButton update,pay,back;
    
    PayFee(){
        setSize(950,500);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.pink);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 450, 350);
        add(image);
        
        
        JLabel lbrn = new JLabel("Select Roll No: ");
        lbrn.setBounds(40,60,150,20);
        lbrn.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbrn);
        
        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);
        
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       
        JLabel lname = new JLabel("Name:");
        lname.setBounds(40, 100, 150, 20);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        JLabel lbname = new JLabel();
        lbname.setBounds(200, 100, 150, 20);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);

        
        JLabel lfname = new JLabel("Father's Name:");
        lfname.setBounds(40, 140, 150, 20);
        lfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lfname);
        
        JLabel lbfname = new JLabel();
        lbfname.setBounds(200, 140, 150, 20);
        lbfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbfname);
        
        try{
            ConnectionF conn = new ConnectionF();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = conn.stm.executeQuery(query);
            while(rs.next()){
              
                lbname.setText(rs.getString("name"));
                lbfname.setText(rs.getString("fname"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    ConnectionF conn = new ConnectionF();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = conn.stm.executeQuery(query);
                    while(rs.next()){
                        lbname.setText(rs.getString("name"));
                        lbfname.setText(rs.getString("fname"));
                        
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
             }
        });
        
        JLabel lbcou = new JLabel("Course:");
        lbcou.setBounds(40, 180, 150, 20);
        lbcou.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbcou);
        
        String course[] = {"BTech", "BBA", "BCA", "BA-English" ,"B.Com","MCA", "MBA","MTech"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        
        JLabel lbbranch = new JLabel("Branch:");
        lbbranch.setBounds(40, 220, 150, 20);
        lbbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbbranch);
        
        String branch[] = {"Computer-Science", "Electronics", "Mechanical", "Civil" ,"IT", "Mathematics","English","Physics"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200, 220, 150, 20);
        cbcourse.setBackground(Color.white);
        add(cbbranch);
        
        JLabel lbsem = new JLabel("Semester:");
        lbsem.setBounds(40,260,150,20);
        lbsem.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lbsem);
        
        String semester[] ={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        cbsem = new JComboBox(semester);
        cbsem.setBounds(200,260,150,20);
        //cbsem.setBackground(Color.white);
        add(cbsem);
        
        JLabel total = new JLabel("Total Fee:");
        total.setBounds(40, 300, 150, 20);
        total.setFont(new Font("Tahoma",Font.BOLD,16));
        add(total);
        
        lbtoatl = new JLabel();
        lbtoatl.setBounds(200, 300, 150, 20);
        lbtoatl.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbtoatl);
        
        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.blue);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,18));
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 120, 25);
        pay.setBackground(Color.blue);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,18));
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(290, 380, 100, 25);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,18));
        add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == update){
        String course = (String) cbcourse.getSelectedItem();
        String semester = (String) cbsem.getSelectedItem();
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from fee where course= '"+course+"'");
            while(rs.next()){
                lbtoatl.setText(rs.getString(semester));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        else if(ae.getSource() == pay){
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsem.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = lbtoatl.getText();
            
            try{
            ConnectionF conn = new ConnectionF();
            
            String query = "insert into collegefee values('"+rollno+"','"+course+"','"+semester+"','"+branch+"','"+total+"')";

            conn.stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully");
            }
            catch(Exception e){
            e.printStackTrace();
            }
         }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        PayFee pf = new PayFee();
    }
    
}
