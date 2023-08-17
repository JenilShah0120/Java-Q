package Java_Q;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton next, exit;
    JTextField t_field;
    JComboBox<String> c_box1;

    Home(){

        setBounds(200,200,800,450);
        getContentPane().setBackground(Color.BLACK);
        setTitle("JAVA-Q");
        setLayout(null);

        ImageIcon i1;
        i1 = new ImageIcon(ClassLoader.getSystemResource("Java_Q/icons/OIP.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(10,10,380,390);
        add(l1);

        JLabel l4 = new JLabel("Let's Test Your");
        l4.setForeground(Color.yellow);
        l4.setBounds(480,90,200,20);
        l4.setFont(new Font("OCR A Extended",Font.ITALIC,13));
        add(l4);

        JLabel l2 = new JLabel("JAVA-Q");
        l2.setFont(new Font("Matura MT Script Capitals",Font.BOLD,30));
        l2.setForeground(new Color(255,153,51));
        l2.setBounds(500,90,400,100);
        add(l2);

        JLabel l3 = new JLabel("Enter Your Name");
        l3.setFont(new Font("Copperplate Gothic Light",Font.ITALIC,16));
        l3.setForeground(new Color(246,236,100));
        l3.setBounds(518,140,400,100);
        add(l3);

        t_field = new JTextField();
        t_field.setBounds(500,215,200,20);
        t_field.setFont(new Font("Copperplate Gothic Light",Font.BOLD,17));
        add(t_field);

        String[] course = {"Select Course","10+2(Science)","Bachelor's Degree","Master's Degree","PhD","Deploma"};
        c_box1= new JComboBox<>(course);
        c_box1.setBounds(500,240,200,20);
        c_box1.addActionListener(this);
        add(c_box1);

        next = new JButton("Let's Start");
        next.setBounds(445,280,145,22);
        next.setForeground(Color.yellow);
        next.setFont(new Font("Colonna MT",Font.ITALIC,20));
        next.setBackground(new Color(102,51,0));
        next.setEnabled(false);
        next.addActionListener(this);
        add(next);

        exit = new JButton("Exit");
        exit.setBounds(605,280,145,22);
        exit.setForeground(Color.yellow);
        exit.setFont(new Font("Colonna MT",Font.ITALIC,20));
        exit.setBackground(new Color(102,51,0));
        exit.addActionListener(this);
        add(exit);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == c_box1){
            next.setEnabled(true);
        }else  if (ae.getSource() == next){
            String name = t_field.getText();
            this.setVisible(false);
            new Rules(name);
        }else{
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
