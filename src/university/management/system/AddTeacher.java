package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddTeacher extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfadd, tfphone, tfemail, tfadh, tfx, tfx2;
    JLabel labelemid;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit,cann;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()% 90000L) + 10000L);
    
    AddTeacher(){
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        
        JLabel lname = new JLabel("Name:");
        lname.setBounds(50, 150, 100, 30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
         
        JLabel lfname = new JLabel("Father's Name:");
        lfname.setBounds(400, 150, 200, 30);
        lfname.setFont(new Font("serif",Font.BOLD,20));
        add(lfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        
        JLabel empid = new JLabel("Employee Id:");
        empid.setBounds(50, 200, 200, 30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);
        
        labelemid = new JLabel("F450"+first4);
        labelemid.setBounds(200, 200, 200, 30);
        labelemid.setFont(new Font("serif",Font.BOLD,20));
        add(labelemid);
        
        
        JLabel lbdob = new JLabel("Date of Birth:");
        lbdob.setBounds(400, 200, 200, 30);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        
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
        
        
        JLabel lbadh = new JLabel("Adhar Number:");
        lbadh.setBounds(400, 300, 200, 30);
        lbadh.setFont(new Font("serif",Font.BOLD,20));
        add(lbadh);
        
        tfadh = new JTextField();
        tfadh.setBounds(600, 300, 150, 30);
        add(tfadh);
        
        
        JLabel lbmarksx = new JLabel("Graduation (%):");
        lbmarksx.setBounds(50, 350, 200, 30);
        lbmarksx.setFont(new Font("serif",Font.BOLD,20));
        add(lbmarksx);
        
        tfx = new JTextField();
        tfx.setBounds(200, 350, 150, 30);
        add(tfx);
        
        
        JLabel lbmarksx2 = new JLabel("Post-Graduation (%):");
        lbmarksx2.setBounds(400, 350, 200, 30);
        lbmarksx2.setFont(new Font("serif",Font.BOLD,20));
        add(lbmarksx2);
        
        tfx2 = new JTextField();
        tfx2.setBounds(600, 350, 150, 30);
        add( tfx2);
        
        
        JLabel lbcou = new JLabel("Qualification:");
        lbcou.setBounds(50, 400, 200, 30);
        lbcou.setFont(new Font("serif",Font.BOLD,20));
        add(lbcou);
        
        String course[] = {"M.Tech","MBA","MCA","MSc","MA","PHD"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        
        JLabel lbbranch = new JLabel("Department:");
        lbbranch.setBounds(400, 400, 200, 30);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch);
        
        String branch[] = {"Computer-Science", "Electronics", "Mechanical", "Civil" ,"IT", "Mathematics","English","Physics"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 200, 30);
        cbcourse.setBackground(Color.white);
        add(cbbranch);
        
        
        submit = new JButton("Submit");
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
    String name = tfname.getText();
    String fname = tffname.getText();
    String empid = labelemid.getText();
    String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
    String address = tfadd.getText();
    String phone = tfphone.getText();
    String email = tfemail.getText();
    String adhar = tfadh.getText();
    String ug = tfx.getText();
    String pg = tfx2.getText();
    String Qualification = (String) cbcourse.getSelectedItem();
    String Department = (String) cbbranch.getSelectedItem();

    if (ae.getSource() == submit) {
        try {
            String query = "insert into teacher values('" + name + "','" + fname + "','" + empid + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + adhar + "','" + ug + "','" + pg + "','" + Qualification + "','" + Department + "')";

            ConnectionF conn = new ConnectionF();
            conn.stm.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}

    
    public static void main(String[] args){
        AddTeacher as = new AddTeacher();
    }
}
