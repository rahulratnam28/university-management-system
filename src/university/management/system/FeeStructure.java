package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{
    
    Choice cou;
    
    FeeStructure(){
        
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        
        getContentPane().setBackground(Color.green);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(380, 10, 400, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        
        JTable table = new JTable();
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,90,1000,700);
        add(jsp);
        
        setVisible(true);
    }
    
    public static void main (String [] args){
        FeeStructure fs = new FeeStructure();
    }
    
}
