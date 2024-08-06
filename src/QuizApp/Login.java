package QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton Exit,Rules,Start;
    JTextField Nameinp;
    public Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icons/travel.png"));
        JLabel image=new JLabel(ic);
        image.setBounds(0,0,480,500);
        add(image);

        JLabel heading = new JLabel("Amazing Quiz");
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setBounds(530,60,300,45);
        //heading.setForeground(Color.red);                      // either this
        heading.setForeground(new Color(204,10,2)); // this is called rgb colors. (creating obj of color)
        add(heading);

        JLabel Ename = new JLabel("Enter your name");
        Ename.setFont(new Font("Algerian",Font.CENTER_BASELINE,16));
        Ename.setBounds(610,140,300,45);
        Ename.setForeground(Color.black);                      // either this
        //Ename.setForeground(new Color(204,10,2)); // this is called rgb colors. (creating obj of color)
        add(Ename);

        Nameinp = new JTextField();
        Nameinp.setBounds(570,175,230,25);
        Nameinp.setFont(new Font("Mongolian",Font.ITALIC,15));
        Nameinp.setForeground(new Color(1, 5, 66));
        add(Nameinp);

        Rules = new JButton("Rules");
        Rules.setBounds(570,215,100,25);
        Rules.setBackground(new Color(0x0E90BA));   // Using color helper
        Rules.setForeground(Color.white);
        Rules.addActionListener(this);
        add(Rules);

        Exit = new JButton("Exit");
        Exit.setBounds(700,215,100,25);
        Exit.setBackground(new Color(0x0E90BA));   // Using color helper
        Exit.setForeground(Color.white);
        Exit.addActionListener(this);
        add(Exit);

        Start = new JButton("Start");
        Start.setBounds(635,255,100,25);
        Start.setBackground(new Color(0x0E90BA));
        Start.setForeground(Color.white);
        Start.addActionListener(this);
        add(Start);

        setBounds(190,130,900,500);
        setVisible(true);
        setResizable(false);
        getRootPane().setDefaultButton(Rules);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Rules) {
            String name = Nameinp.getText();
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name to see the rules.","Warning",JOptionPane.WARNING_MESSAGE);
            } else {
                new Rules(name);
                setVisible(false);
                System.out.println("Opening Rules");
            }

        } else if (e.getSource() == Exit) {
            setVisible(false);
            System.out.println("Exiting");
        } else if (e.getSource() == Start) {
            String name= Nameinp.getText();
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name to start the quiz.","Warning",JOptionPane.WARNING_MESSAGE);
            } else {
                new Start(name);
                setVisible(false);
                System.out.println("Opening Start");
            }

        }


//        else {
//            setVisible(false); // for exit
//        }


    }

    public static void main(String[] agrs){
        new Login();
        System.out.println("Opening Login");
    }







}
