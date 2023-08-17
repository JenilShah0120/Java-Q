package Java_Q;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    JButton back, start;
    String username;
    JCheckBox check_box;

    Rules(String username){
        this.username = username;
        setBounds(200, 200, 800, 450);
        getContentPane().setBackground(Color.BLACK);
        setTitle("JAVA-Q");
        setLayout(null);

        ImageIcon i1;
        i1 = new ImageIcon(ClassLoader.getSystemResource("Java_Q/icons/OIP.jpg"));
        JLabel l3 = new JLabel(i1);
        l3.setBounds(400,50,380,250);
        add(l3);

        JLabel l1 = new JLabel("Welcome " + username + " to Java-Q");
        l1.setForeground(new Color(30, 144, 255));
        l1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 28));
        l1.setBounds(50, 20, 700, 30);
        l1.setForeground(new Color(255,153,51));
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l2.setBounds(30, 70, 600, 200);
        l2.setText(
                "<html>"+
                        "1. All the questions are compulsory" + "<br><br>" +
                        "2. You have only 15 seconds for each Quetion" + "<br><br>" +
                        "3. You will get +10 marks for each correct answer." + "<br><br>" +
                        "4. You will get -5 marks for each Incorrect answer "+"<br><br>" +
                        "5. Best of luck and Enjoy" + "<br><br>" +
                        "<html>"
        );

        l2.setForeground(new Color(255,255,0));
        add(l2);

        check_box = new JCheckBox();
        check_box.setBounds(20,290,290,25);
        check_box.setText(
               "Term and Conditions Accepted"
        );
        check_box.setBackground(Color.BLACK);
        check_box.setForeground(Color.white);
        check_box.setFont(new Font("Bookman Old Style",Font.BOLD,14));
        check_box.addActionListener(this);
        add(check_box);

        back = new JButton("Back");
        back.setBounds(405, 330, 125, 22);
        back.setBackground(new Color(102,51,0));
        back.setFont(new Font("Colonna MT",Font.ITALIC,20));
        back.setForeground(Color.yellow);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(270, 330, 125, 22);
        start.setBackground(new Color(102,51,0));
        start.setFont(new Font("Colonna MT",Font.ITALIC,20));
        start.setEnabled(false);
        start.setForeground(Color.yellow);
        start.addActionListener(this);
        add(start);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == check_box) {
            start.setEnabled(true);
        }
            if (ae.getSource() == back) {
                this.setVisible(false);
                new Home().setVisible(true);
            } else if (ae.getSource() == start) {
                this.setVisible(false);
                new Quiz(username).setVisible(true);
            }

    }

    public static void main(String[] args){

        new Rules("");
    }
}
