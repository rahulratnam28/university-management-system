package university.management.system;

import javax.swing.*;
import java.awt.*;



public class Start extends JFrame implements Runnable{
    
    Thread t;
    
    Start(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/afirst.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 740, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        setVisible(true);
        
//        setLocation(250,50);
//        setSize(1000,700);
        int x=1;
        for(int i=2; i<=600; i+=4, x+=1){
            setLocation(600-((i+x)/2),350-(i/2));
            setSize(i+4*x, i+x);
            
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                
            }
        }
        
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
        }
        catch(Exception e){
            
        }
        
    }
    
    public static void main(String [] args){
        Start s = new Start();
        Login ln =new Login();
    }
    
}
