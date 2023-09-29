package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JTable table;
    JButton search, print,update, add, cancel;
    
    TeacherDetails(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by  Employee ID");
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
            ResultSet rs = conn.stm.executeQuery("select * from teacher");
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1289, 800);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(320, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(1300,800);
        setLocation(160,25);
        getContentPane().setBackground(Color.orange);
        
        setVisible(true);
        
      }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() ==search){
            String query = "select * from teacher where empid = '" +cEmpId.getSelectedItem()+ "'";
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
        else if (ae.getSource() == update){
            setVisible(true);
            new UpdateTeacher();
        }
        else if (ae.getSource() == add){
            setVisible(true);
            new AddTeacher();
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main (String [] args){
        TeacherDetails sd = new TeacherDetails();
    }
    
}
