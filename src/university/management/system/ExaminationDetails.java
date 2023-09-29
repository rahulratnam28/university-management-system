package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails(){
        
        setSize(1450,600);
        setLocation(50,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.pink);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(400, 0, 500, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,20));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.blue);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1450, 450);
        add(jsp);
        
        try{
            ConnectionF conn = new ConnectionF();
            ResultSet rs = conn.stm.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == submit){
            
            setVisible(true);
            new Marks(search.getText());
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main (String[] args){
        
        ExaminationDetails ed = new ExaminationDetails();
    }
    
}
