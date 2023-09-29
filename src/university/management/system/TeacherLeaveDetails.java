package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JTable table;
    JButton search, print, cancel;
    
    TeacherLeaveDetails(){
        
        getContentPane().setBackground(Color.orange);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(180,20,150,20);
        add(cEmpId);
        
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1200, 800);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(1200,700);
        setLocation(150,50);
        
        setVisible(true);
        
      }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            String query = "select * from teacherleave where empid = '" +cEmpId.getSelectedItem()+ "'";
            try{
                ConnectionF conn = new ConnectionF();
                ResultSet rs = conn.stm.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main (String [] args){
        TeacherLeaveDetails sld = new TeacherLeaveDetails();
    }
    
}

