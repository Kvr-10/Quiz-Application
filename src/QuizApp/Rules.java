package QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton Back,Start;
    public Rules(String name){
        this.name=name;
        getContentPane().setBackground(Color.white);

        JLabel Welcome =new JLabel("Welcome "+name+" to Amazing Quiz !!");
        Welcome.setBounds(20,20,700,25);
        Welcome.setFont(new Font("Viner Hand ITC",Font.BOLD,25));
        Welcome.setForeground(Color.BLACK);
        add(Welcome);

        JLabel rules =new JLabel();
        rules.setBounds(20,20,650,300);
        rules.setFont(new Font("Cascadia Code",Font.ITALIC,18));
        rules.setText(
                "<html>" +
                        "1. <b>Answer All Questions:</b> Attempt every question.<br>" +
                        "2. <b>Time Limit:</b> Answer each question within the time limit.<br>" +
                        "3. <b>One Answer:</b> Select only one option per question.<br>" +
                        "4. <b>Submit After Final Question:</b> Submit only after the last question.<br>" +
                        "5. <b>No External Help:</b> Use only your own knowledge.<br>" +
                        "6. <b>Play Fair:</b> Be honest and have fun.<br>" +
                        "7. <b>Scoring:</b> Correct answers, earn points.<br>" +
                        "8. <b>Review Results:</b> Check your score after the quiz.<br>" +
                        "</html>"
        );



        add(rules);

        Back =new JButton("Back");
        Back.setBounds(355,305,100,25);
        Back.setBackground(new Color(0x0E90BA));   // Using color helper
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        Start = new JButton("Start");
        Start.setBounds(185,305,100,25);
        Start.setForeground(Color.WHITE);
        Start.setBackground(new Color(0x0E90BA));
        Start.addActionListener(this);
        add(Start);


        setBounds(340,180,650,400);
        getRootPane().setDefaultButton(Start);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== Back){
            new Login();
            System.out.println("Back to login");
            setVisible(false);
        } else if(e.getSource() == Start){
            new Start(name);
            System.out.println("Opening start");
            setVisible(false);

        }
    }
    public static void main(String[] args) {
        new Rules("User");
    }
}
