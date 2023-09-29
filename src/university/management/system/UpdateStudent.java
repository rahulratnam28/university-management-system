package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
    
    JTextField  tfadd, tfphone, tfemail ;
    JLabel labelrollno;
    JButton submit,cann;
    Choice crollno;
    JComboBox cbcourse,cbbranch; 
    
   
    UpdateStudent(){
        setSize(900, 650);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        add(heading);
        
        JLabel lbrn = new JLabel("Select Roll Number");
        lbrn.setBounds(50,100,200,20);
        lbrn.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbrn);
        
        crollno = new Choice();
        crollno.setBounds(250,100,200,20);
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
        lname.setBounds(50, 150, 100, 30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        add(lname);
        
        JLabel lbname = new JLabel();
        lbname.setBounds(200, 150, 150, 30);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbname);

        
        
         
        JLabel lfname = new JLabel("Father's Name:");
        lfname.setBounds(400, 150, 200, 30);
        lfname.setFont(new Font("serif",Font.BOLD,20));
        add(lfname);
        
        JLabel lbfname = new JLabel();
        lbfname.setBounds(600, 150, 150, 30);
        lbfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbfname);
        
        
        JLabel rolln = new JLabel("Roll Number:");
        rolln.setBounds(50, 200, 200, 30);
        rolln.setFont(new Font("serif",Font.BOLD,20));
        add(rolln);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif",Font.PLAIN,18));
        add(labelrollno);
        
        
        JLabel lbdob = new JLabel("Date of Birth:");
        lbdob.setBounds(400, 200, 200, 30);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
        
        JLabel lbldoc = new JLabel();
        lbldoc.setBounds(600, 200, 150, 30);
        lbldoc.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldoc);
        
        
        JLabel lbadd = new JLabel("Address:");
        lbadd.setBounds(50, 250, 200, 30);
        lbadd.setFont(new Font("serif",Font.BOLD,20));
        add(lbadd);
        
        tfadd = new JTextField();
        tfadd.setBounds(200, 250, 150, 30);
        add(tfadd);
        
        
        JLabel lbphone = new JLabel("Phone Number:");
        lbphone.setBounds(400, 250, 200, 30);
        lbphone.setFont(new Font("serif",Font.BOLD,20));
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        
        JLabel lbmail = new JLabel("Email Id:");
        lbmail.setBounds(50, 300, 200, 30);
        lbmail.setFont(new Font("serif",Font.BOLD,20));
        add(lbmail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        
        JLabel lbadh = new JLabel("Aadhaar Number:");
        lbadh.setBounds(400, 300, 200, 30);
        lbadh.setFont(new Font("serif",Font.BOLD,20));
        add(lbadh);
        
        JLabel lbadha = new JLabel();
        lbadha.setBounds(600, 300, 150, 30);
        lbadha.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbadha);
        
        
        JLabel lbmarksx = new JLabel("Class X (%):");
        lbmarksx.setBounds(50, 350, 200, 30);
        lbmarksx.setFont(new Font("serif",Font.BOLD,20));
        add(lbmarksx);
        
        JLabel lbx = new JLabel();
        lbx.setBounds(200, 350, 150, 30);
        lbx.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbx);
        
        
        JLabel lbmarksx2 = new JLabel("Class XII (%):");
        lbmarksx2.setBounds(400, 350, 200, 30);
        lbmarksx2.setFont(new Font("serif",Font.BOLD,20));
        add(lbmarksx2);
        
        JLabel lbx2 = new JLabel();
        lbx2.setBounds(600, 350, 150, 30);
        lbx2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add( lbx2);
        
        
        JLabel lbcou = new JLabel("Course:");
        lbcou.setBounds(50, 400, 200, 30);
        lbcou.setFont(new Font("serif",Font.BOLD,20));
        add(lbcou);
        
        String course[] = {"B.Tech", "BBA", "BCA", "BA" ,"BSc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        
        JLabel lbbranch = new JLabel("Branch:");
        lbbranch.setBounds(400, 400, 200, 30);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch);
        
        String branch[] = {"Computer-Science", "Electronics", "Mechanical", "Civil" ,"IT", "Mathematics","English","Physics"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 200, 30);
        cbcourse.setBackground(Color.white);
        add(cbbranch);
        
        try{
            ConnectionF conn = new ConnectionF();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = conn.stm.executeQuery(query);
            while(rs.next()){
              
                lbname.setText(rs.getString("name"));
                lbfname.setText(rs.getString("fname"));
                labelrollno.setText(rs.getString("rollno"));
                lbldoc.setText(rs.getString("dob"));
                tfadd.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                lbx.setText(rs.getString("class_x"));
                lbx2.setText(rs.getString("class_xii"));
                lbadha.setText(rs.getString("adharno"));
                lbcou.setText(rs.getString("course"));
                lbbranch.setText(rs.getString("branch"));
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
                        labelrollno.setText(rs.getString("rollno"));
                        lbldoc.setText(rs.getString("dob"));
                        tfadd.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        lbx.setText(rs.getString("class_x"));
                        lbx2.setText(rs.getString("class_xii"));
                        lbadha.setText(rs.getString("adharno"));
                        lbcou.setText(rs.getString("course"));
                        lbbranch.setText(rs.getString("branch"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
             }
        });
        
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,20));
        add(submit);
        
        cann = new JButton("Cancel");
        cann.setBounds(450, 500, 120, 30);
        cann.setBackground(Color.blue);
        cann.setForeground(Color.white);
        cann.addActionListener(this);
        cann.setFont(new Font("serif",Font.BOLD,20));
        add(cann);
        
        setVisible(true);
    }
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
    String rollno = labelrollno.getText();
    String address = tfadd.getText();
    String phone = tfphone.getText();
    String email = tfemail.getText();
    String course = (String) cbcourse.getSelectedItem();
    String branch = (String) cbbranch.getSelectedItem();

    
        try {
            String query = "update student set address='" + address + "',phone='" + phone + "',email='" + email + "',course='" + course + "',branch='" + branch + "' where rollno='"+rollno+"' ";

            ConnectionF conn = new ConnectionF();
            conn.stm.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}

    
    public static void main(String[] args){
        UpdateStudent as = new UpdateStudent();
    }
}
