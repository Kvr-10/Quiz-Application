package QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {

    String Que[][] = new String[5][5];// Col= 1 Question + 4 Options
    String Answers[][] = new String[5][1];
    String Useranswer[][] = new String[5][1];
    JLabel heading;
    JLabel questions;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton lifeline, submit, next;
    JLabel timerLabel;

    public int timer = 15;
    public int ans_given = 0;
    public int count = 0;
    public int score = 0;
    private boolean quizCompleted = false;

    String name;
    Timer quizTimer;

    public Start(String name) {

        this.name = name;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(190, 130, 900, 500);
        getRootPane().setDefaultButton(next);
        setResizable(false);
        setTitle("Amazing Quiz");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/quiz.png"));
        setIconImage(icon.getImage());

        ImageIcon q = new ImageIcon(ClassLoader.getSystemResource("icons/basketball.png"));
        JLabel Questions = new JLabel(q);
        Questions.setBounds(10, 0, 500, 490);
        add(Questions);

        getContentPane().setBackground(Color.WHITE);

        heading = new JLabel();
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
        heading.setBounds(530, 60, 300, 25);
        heading.setForeground(new Color(0x06898E));
        add(heading);

        questions = new JLabel();
        questions.setBounds(510, 95, 550, 20);
        questions.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        questions.setForeground(Color.BLACK);
        add(questions);

        // Timer label for countdown
        timerLabel = new JLabel("Time Left: " + timer + " seconds");
        timerLabel.setBounds(700, 60, 200, 25);
        timerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        Que[0][0] = "What is the capital of India?";
        Que[0][1] = "Delhi";
        Que[0][2] = "Mumbai";
        Que[0][3] = "Patna";
        Que[0][4] = "Bangalore";

        Que[1][0] = "What is the capital of Maharashtra?";
        Que[1][1] = "Delhi";
        Que[1][2] = "Mumbai";
        Que[1][3] = "Patna";
        Que[1][4] = "Bangalore";

        Que[2][0] = "What is the capital of Bihar?";
        Que[2][1] = "Delhi";
        Que[2][2] = "Mumbai";
        Que[2][3] = "Patna";
        Que[2][4] = "Bangalore";

        Que[3][0] = "What is the capital of Karnataka?";
        Que[3][1] = "Delhi";
        Que[3][2] = "Mumbai";
        Que[3][3] = "Patna";
        Que[3][4] = "Bangalore";

        Que[4][0] = "What is the capital of Punjab?";
        Que[4][1] = "Delhi";
        Que[4][2] = "Mumbai";
        Que[4][3] = "Chandigarh";
        Que[4][4] = "Bangalore";

        Answers[0][0] = "Delhi";
        Answers[1][0] = "Mumbai";
        Answers[2][0] = "Patna";
        Answers[3][0] = "Bangalore";
        Answers[4][0] = "Chandigarh";

        opt1 = new JRadioButton();
        opt1.setBounds(530, 135, 300, 20);
        opt1.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
        opt1.setForeground(Color.BLACK);
        opt1.setBackground(Color.white);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(530, 165, 300, 20);
        opt2.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
        opt2.setForeground(Color.BLACK);
        opt2.setBackground(Color.white);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(530, 195, 300, 20);
        opt3.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
        opt3.setForeground(Color.BLACK);
        opt3.setBackground(Color.white);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(530, 225, 300, 20);
        opt4.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
        opt4.setForeground(Color.BLACK);
        opt4.setBackground(Color.white);
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(550, 370, 100, 25);
        next.setBackground(new Color(0x0E90BA));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(550, 410, 100, 25);
        submit.setBackground(new Color(0x0E90BA));
        submit.setForeground(Color.white);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(670, 370, 150, 25);
        lifeline.setBackground(new Color(0x0E90BA));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);


        begin(count);


        setVisible(true);

        startTimer();
    }

    private void startTimer() {
        quizTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer--;
                if (timer > 0) {
                    timerLabel.setText("Time Left: " + timer + " seconds");
                } else {
                    timerLabel.setText("Times up!!");
                    handleTimeout();
                }
            }
        });
        quizTimer.start();
    }

    private void handleTimeout() {
        if (quizCompleted) return;
        quizTimer.stop();
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);

        if (count == 3) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        if (count == 4) { //submit button
            if (groupoptions.getSelection() == null) {
                Useranswer[count][0] = "";
            } else {
                Useranswer[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < Useranswer.length; i++) {
                if (Useranswer[i][0] != null && Useranswer[i][0].equals(Answers[i][0])) {
                    score += 10;
                }
             }
            quizCompleted = true;
            setVisible(false);
            new Score(name, score);

        } else  { //next button(Every Question)
            if (groupoptions.getSelection() == null) {
                Useranswer[count][0] = "";
            } else {
                Useranswer[count][0] = groupoptions.getSelection().getActionCommand();
            }
        }

        count++;
        if(count<5) {
            timer = 16; // Reset timer for next question
            begin(count);
            quizTimer.restart();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                Useranswer[count][0] = "";
            } else {
                Useranswer[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 3) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            if(count<5) {
                timer = 16; // Reset timer for next question
                begin(count);
                quizTimer.restart();
            }
        } else if (e.getSource() == lifeline) {
            if (count == 0 || count == 2) {
                opt2.setEnabled(false);
                opt4.setEnabled(false);
            } else if (count == 1 || count == 3) {
                opt1.setEnabled(false);
                opt3.setEnabled(false);
            } else if (count == 4) {
                opt2.setEnabled(false);
                opt1.setEnabled(false);
            }
            lifeline.setEnabled(false);

        } else if (e.getSource() == submit) {
            if (quizCompleted) return;
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                Useranswer[count][0] = "";
            } else {
                Useranswer[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < Useranswer.length; i++) {
                if (Useranswer[i][0] != null && Useranswer[i][0].equals(Answers[i][0])) {
                    score += 10;
                }
            }
            quizCompleted = true;
            setVisible(false);
            new Score(name, score);
        }
    }

    public void begin(int count) {
        heading.setText("Question " + (count + 1));
        questions.setText(Que[count][0]);
        opt1.setText(Que[count][1]);
        opt1.setActionCommand(Que[count][1]);

        opt2.setText(Que[count][2]);
        opt2.setActionCommand(Que[count][2]);

        opt3.setText(Que[count][3]);
        opt3.setActionCommand(Que[count][3]);

        opt4.setText(Que[count][4]);
        opt4.setActionCommand(Que[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Start("User");
    }
}
