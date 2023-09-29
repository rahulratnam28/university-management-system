
package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;


public class EnterMarks extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbsem;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfsub6,tfsub7,tfsub8,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5,tfmarks6,v,tfmarks7,tfmarks8;
    JButton submit, cancel;
    
    EnterMarks(){
        
        setSize(850,700);
        setLocation(300,80);
        setLayout(null);
        
        getContentPane().setBackground(Color.orange);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon16.png"));
        Image i2 = i1.getImage().getScaledInstance(280, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 120, 400, 500);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Students");
        heading.setBounds(230, 0, 500, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel lbrn = new JLabel("Select Roll Number");
        lbrn.setBounds(50,80,200,20);
        lbrn.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbrn);
        
        crollno = new Choice();
        crollno.setBounds(250,80,150,25);
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
        
        JLabel lbsem = new JLabel("Select semester");
        lbsem.setBounds(50,110,200,20);
        lbsem.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbsem);
        
        String semester[] ={"1st Semester","2st Semester","3st Semester","4st Semester","5st Semester","6st Semester","7st Semester","8st Semester"};
        cbsem = new JComboBox(semester);
        cbsem.setBounds(250,110,150,20);
        //cbsem.setBackground(Color.white);
        add(cbsem);
        
        JLabel lbentersub = new JLabel("Enetr Subject");
        lbentersub.setBounds(100,150,200,40);
        lbentersub.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbentersub);
        
        JLabel lbentermarks = new JLabel("Enetr Marks");
        lbentermarks.setBounds(270,150,200,40);
        lbentermarks.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 190, 200, 30);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 30);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 270, 200, 30);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 310, 200, 30);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 350, 200, 30);
        add(tfsub5);
        
        tfsub6 = new JTextField();
        tfsub6.setBounds(50, 390, 200, 30);
        add(tfsub6);
        
        tfsub7 = new JTextField();
        tfsub7.setBounds(50, 430, 200, 30);
        add(tfsub7);
        
        tfsub8 = new JTextField();
        tfsub8.setBounds(50, 470, 200, 30);
        add(tfsub8);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 190, 150, 30);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 230, 150, 30);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 270, 150, 30);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 310, 150, 30);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250, 350, 150, 30);
        add(tfmarks5);
        
        tfmarks6 = new JTextField();
        tfmarks6.setBounds(250, 390, 150, 30);
        add(tfmarks6);
        
        tfmarks7 = new JTextField();
        tfmarks7.setBounds(250, 430, 150, 30);
        add(tfmarks7);
        
        tfmarks8 = new JTextField();
        tfmarks8.setBounds(250, 470, 150, 30);
        add(tfmarks8);
        
        submit = new JButton("Submit");
        submit.setBounds(90, 550, 150, 25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,20));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 550, 150, 25);
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            try{
                ConnectionF conn = new ConnectionF();
                
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"','"+tfsub6.getText()+"','"+tfsub7.getText()+"','"+tfsub8.getText()+"')";
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"','"+tfmarks6.getText()+"','"+tfmarks7.getText()+"','"+tfmarks8.getText()+"')";
      
                
                conn.stm.executeUpdate(query1);
                conn.stm.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        EnterMarks em = new EnterMarks();
    }
    
}
