package Java_Q;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{

    JButton submit, next;
    public static int count = 0;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int score = 0;
    JLabel qno, question;
    String[][] q = new String[10][5];
    String[][] pa = new String[10][1];
    String[][] qa = new String[10][2];
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;

    String username;
    Quiz(String username){
        this.username = username;
        setBounds(200, 200, 800, 450);
        getContentPane().setBackground(Color.black);
        setTitle("JAVA-Q");
        setLayout(null);

        ImageIcon i1;
        i1 = new ImageIcon(ClassLoader.getSystemResource("Java_Q/icons/OIP.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(530,140,350,350);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        qno.setBounds(45, 50, 50, 30);
        qno.setForeground(Color.yellow);
        add(qno);

        question = new JLabel("");
        question.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        question.setForeground(Color.yellow);
        question.setBounds(70, 50, 600, 30);
        add(question);

        q[0][0] = "What is the default value of short variable?";
        q[0][1] = "0.0";
        q[0][2] = "0";
        q[0][3] = "Null";
        q[0][4] = "Not defined";

        q[1][0] = "This is the parent of Error and Exception classes.";
        q[1][1] = "Throwable";
        q[1][2] = "Catchable";
        q[1][3] = "MainError";
        q[1][4] = "MainException";

        q[2][0] = "Which of the following is a reserved keyword in Java?";
        q[2][1] = "object";
        q[2][2] = "strictfp";
        q[2][3] = "main";
        q[2][4] = "system";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "Which of the following is not a Java features?";
        q[4][1] = "Dynamic";
        q[4][2] = "Architecture Neutral";
        q[4][3] = "Use of pointers";
        q[4][4] = "Object-oriented";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which package contains the Random class?";
        q[6][1] = "java.util package";
        q[6][2] = "java.lang package";
        q[6][3] = "java.awt package";
        q[6][4] = "java.io package";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following for loop declaration is not valid?";
        q[9][1] = "for ( int i = 99; i >= 0; i / 9 )";
        q[9][2] = "for ( int i = 7; i <= 77; i += 7 )";
        q[9][3] = "for ( int i = 20; i >= 2; - -i )";
        q[9][4] = "for ( int i = 2; i <= 20; i = 2* i )";

        qa[0][1] = "0";
        qa[1][1] = "Throwable";
        qa[2][1] = "strictfp";
        qa[3][1] = "Marker Interface";
        qa[4][1] = "Use of pointers";
        qa[5][1] = "Remote interface";
        qa[6][1] = "java.util package";
        qa[7][1] = "Java Archive";
        qa[8][1] = "java.lang.StringBuilder";
        qa[9][1] = "for ( int i = 99; i >= 0; i / 9 )";


        opt1 = new JRadioButton("");
        opt1.setBounds(70, 115, 400, 30);
        opt1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        opt1.setBackground(Color.black);
        opt1.setForeground(Color.ORANGE);
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setBounds(70, 145, 400, 30);
        opt2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        opt2.setBackground(Color.black);
        opt2.setForeground(Color.ORANGE);
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setBounds(70, 175, 400, 30);
        opt3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        opt3.setBackground(Color.black);
        opt3.setForeground(Color.ORANGE);
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setBounds(70, 205, 400, 30);
        opt4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        opt4.setBackground(Color.black);
        opt4.setForeground(Color.ORANGE);
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        submit = new JButton("Submit");
        submit.setBounds(335, 330, 125, 22);
        submit.setBackground(new Color(102,51,0));
        submit.setFont(new Font("Colonna MT",Font.ITALIC,20));
        submit.setEnabled(false);
        submit.setForeground(Color.yellow);
        submit.addActionListener(this);
        add(submit);

        next = new JButton("Next");
        next.setBounds(200, 330, 125, 22);
        next.setBackground(new Color(102,51,0));
        next.setFont(new Font("Colonna MT",Font.ITALIC,20));
        next.setForeground(Color.yellow);
        next.addActionListener(this);
        add(next);

        start(0);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if(options.getSelection() == null){
                pa[count][0] = "";
            }else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        }else if(ae.getSource() == submit){
            ans_given = 1;
            if(options.getSelection() == null){
                pa[count][0] = "";
            }else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            for(int i =0 ; i < pa.length ; i++){
                if(pa[i][0].equals(qa[i][1])){
                    score+=10;
                }else if(pa[i][0].equals("")){
                    score += 0;
                }else{
                    score -=5;
                }
            }
            this.setVisible(false);
            new Score(username, score).setVisible(true);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("OCR A Extended", Font.ITALIC, 19));


        if(timer > 0) {
            g.drawString(time, 510, 145);
        }else {
            g.drawString("Times Up!!", 520, 145);
        }

        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        }else if(timer < 0){
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }

                for(int i =0 ; i < pa.length ; i++){
                    if(pa[i][0].equals(qa[i][1])){
                        score+=10;
                    }
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
            }else{
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count){
        qno.setText("" + (count + 1) + ". ");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
    }

    public static void main(String[] args){
        new Quiz("").setVisible(true);
    }
}

