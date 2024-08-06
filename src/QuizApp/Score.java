package QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    JButton playagain,Exit;

    public Score(String name,int score){
    setBounds(190,130,900,500);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Amazing Quiz");
    ImageIcon icon = new ImageIcon(getClass().getResource("/icons/quiz.png"));
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sports.png"));
    Image i2 = i1.getImage().getScaledInstance(480,480,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image= new JLabel(i3);
    image.setBounds(0,-20,480,500);
    add(image);

    JLabel thankyou = new JLabel("Thanks for playing!!");
    thankyou.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
    thankyou.setBounds(530,60,300,45);
    thankyou.setForeground(new Color(0x1919AF));
    add(thankyou);

    JLabel thankyou1 = new JLabel(name);
    thankyou1.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
    thankyou1.setBounds(530,110,300,45);
    add(thankyou1);

    JLabel result = new JLabel("Score :         "+score);
    result.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
    result.setBounds(530,165,300,45);
    add(result);

        playagain = new JButton("Play Again");
        playagain.setBounds(550,255,100,25);
        playagain.setBackground(new Color(0x0E90BA));
        playagain.setForeground(Color.white);
        playagain.addActionListener(this);
        add(playagain);

        Exit = new JButton("Exit");
        Exit.setBounds(700,255,100,25);
        Exit.setBackground(new Color(0x0E90BA));
        Exit.setForeground(Color.white);
        Exit.addActionListener(this);
        add(Exit);

        getRootPane().setDefaultButton(playagain);

    setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Exit){
            System.exit(0);
        }else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Score("User",0);
    }
}
