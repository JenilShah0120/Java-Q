package Java_Q;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Score extends JFrame implements ActionListener{
    JButton home, exit, fb;
    JLabel label3, label4;
    JTextArea t_area;
    JList b;



    Score(String username, int score){
        setBounds(200, 200, 800, 450);
        getContentPane().setBackground(Color.black);
        setTitle("JAVA-Q");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Java_Q/icons/OIP.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(10, 30, 380, 390);
        add(l1);

        JLabel l2 = new JLabel("Thankyou " + username + " for Playing JAVA-Q");
        l2.setBounds(45, 30, 700, 30);
        l2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 26));
        l2.setForeground(new Color(229, 226, 32));
        add(l2);


        t_area = new JTextArea();
        t_area.setBounds(545, 150,205,100);
        t_area.setBackground(new Color(90,50,0));
        t_area.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
        t_area.setForeground(Color.yellow);
        t_area.setVisible(false);
        add(t_area);


        label3 = new JLabel("Your Score is  " + score);
        label3.setBounds(460, 150, 300, 30);
        label3.setFont(new Font("Algerian", Font.PLAIN, 30));
        label3.setForeground(new Color(229, 226, 32));
        label3.setVisible(true);
        add(label3);

        label4= new JLabel("Give your FeedBack");
        label4.setBounds(445, 130, 305, 20);
        label4.setForeground( Color.ORANGE);
        label4.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 14));
        label4.setVisible(false);
        add(label4);

        String[] feedback= {"Bad", "Good", "Amazing"};
        b=new JList<>(feedback);
        b.setBounds(445, 150,98, 100);
        b.setFont(new Font("Colonna MT",Font.PLAIN,23));
        b.setForeground(Color.yellow);
        b.setBackground(new Color(90,50,0));
        b.setVisible(false);
        add(b);


        home = new JButton("Play Again");
        home.setBounds(445,270,145,20);
        home.setForeground(Color.yellow);
        home.setFont(new Font("Colonna MT",Font.ITALIC,16));
        home.setBackground(new Color(102,51,0));
        home.addActionListener(this);
        add(home);

        exit = new JButton("Exit");
        exit.setBounds(605,270,145,20);
        exit.setForeground(Color.yellow);
        exit.setFont(new Font("Colonna MT",Font.ITALIC,16));
        exit.setBackground(new Color(102,51,0));
        exit.setVisible(false);
        exit.addActionListener(this);
        add(exit);

        fb = new JButton("FeedBack");
        fb.setBounds(605,270,145,20);
        fb.setForeground(Color.yellow);
        fb.setFont(new Font("Colonna MT",Font.ITALIC,16));
        fb.setBackground(new Color(102,51,0));
        fb.setVisible(true);
        fb.addActionListener(this);
        add(fb);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == home){
            this.setVisible(false);
            new Home();
        }
        else if(ae.getSource()== fb){
            label3.setVisible(false);
            fb.setVisible(false);
            exit.setVisible(true);
            t_area.setVisible(true);
            label4.setVisible(true);
            b.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Have Nice Day!!!");
            System.exit(0);
        }
    }

    public static void main(String[] args){

        new Score("", 0).setVisible(true);
    }
}

