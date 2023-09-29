package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    Project(){
        setSize(1540,850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/athird.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        //New Information
        JMenu inf = new JMenu("New Information");
        inf.setForeground(Color.blue);
        mb.add(inf);
        
        JMenuItem facInf = new JMenuItem("New Faculty Information");
        facInf.setBackground(Color.pink);
        facInf.setForeground(Color.black);
        facInf.addActionListener(this);
        inf.add(facInf);
        
        JMenuItem stuInf = new JMenuItem("New Student Information");
        stuInf.setBackground(Color.pink);
        stuInf.setForeground(Color.black);
        stuInf.addActionListener(this);
        inf.add(stuInf);
        
        
        //View Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.blue);
        mb.add(details);
        
        JMenuItem fd = new JMenuItem("Faculty Details");
        fd.setBackground(Color.pink);
        fd.setForeground(Color.black);
        fd.addActionListener(this);
        details.add(fd);
        
        JMenuItem sd = new JMenuItem("Student details");
        sd.setBackground(Color.pink);
        sd.setForeground(Color.black);
        sd.addActionListener(this);
        details.add(sd);
        
        //Apply Leave
        JMenu al = new JMenu("Apply Leave");
        al.setForeground(Color.blue);
        mb.add(al);
        
        JMenuItem fl = new JMenuItem("Faculty Leave");
        fl.setBackground(Color.pink);
        fl.setForeground(Color.black);
        fl.addActionListener(this);
        al.add(fl);
        
        JMenuItem sl = new JMenuItem("Student Leave");
        sl.setBackground(Color.pink);
        sl.setForeground(Color.black);
        sl.addActionListener(this);
        al.add(sl);
        
        JMenu jld = new JMenu("Leave Details");
        jld.setForeground(Color.blue);
        mb.add(jld);
        
        JMenuItem fld = new JMenuItem("Faculty Leave Details");
        fld.setBackground(Color.pink);
        fld.setForeground(Color.black);
        fld.addActionListener(this);
        jld.add(fld);
        
        JMenuItem sld = new JMenuItem("Student Leave details");
        sld.setBackground(Color.pink);
        sld.setForeground(Color.black);
        sld.addActionListener(this);
        jld.add(sld);
        
    
        //Update Details
        JMenu ud = new JMenu("Update Details");
        ud.setForeground(Color.blue);
        mb.add(ud);
        
        JMenuItem ufd = new JMenuItem("Update Faculty Details");
        ufd.setBackground(Color.pink);
        ufd.setForeground(Color.black);
        ufd.addActionListener(this);
        ud.add(ufd);
        
        JMenuItem usd = new JMenuItem("Update Student details");
        usd.setBackground(Color.pink);
        usd.setForeground(Color.black);
        usd.addActionListener(this);
        ud.add(usd);
        
        
        
        // Examination
        JMenu e = new JMenu("Examination");
        e.setForeground(Color.blue);
        mb.add(e);
        
        JMenuItem es = new JMenuItem("Examination Results");
        es.setBackground(Color.pink);
        es.setForeground(Color.black);
        es.addActionListener(this);
        e.add(es);
        
        JMenuItem ue = new JMenuItem("Enter Marks");
        ue.setBackground(Color.pink);
        ue.setForeground(Color.black);
        ue.addActionListener(this);
        e.add(ue);
        
        
        //Fee Details
        JMenu fed = new JMenu("Fee Details");
        fed.setForeground(Color.blue);
        mb.add(fed);
        
        JMenuItem fs = new JMenuItem("Fee Structure");
        fs.setBackground(Color.pink);
        fs.setForeground(Color.black);
        fs.addActionListener(this);
        fed.add(fs);

        JMenuItem pf = new JMenuItem("Pay Fee");
        pf.setBackground(Color.pink);
        pf.setForeground(Color.black);
        pf.addActionListener(this);
        fed.add(pf);
        
        JMenu about = new JMenu("About");
        about.setForeground(Color.blue);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.pink);
        ab.setForeground(Color.black);
        ab.addActionListener(this);
        about.add(ab);
        
        
        //Exit
        JMenu ext = new JMenu("Exit");
        ext.setForeground(Color.blue);
        mb.add(ext);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.red);
        ex.setForeground(Color.white);
        ex.addActionListener(this);
        ext.add(ex);
        
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }
        else if(msg.equals("New Student Information")){
            new AddStudent();
        }
        else if(msg.equals("Faculty Details")){
            new TeacherDetails();
        }
        else if(msg.equals("Student details")){
            new StudentDetails();
        }
        else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Student Leave details")){
            new StudentLeaveDetails();
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Update Student details")){
            new UpdateStudent();
        }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
        else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }
        else if(msg.equals("About")){
            new About();
        } 
        else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if(msg.equals("Pay Fee")){
            new PayFee();
        } 

    }
    
    public static void main(String[] args){
        
        Project p = new Project();
    }
}
