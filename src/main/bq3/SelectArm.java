package bq3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import bq3.Map;

public class SelectArm implements ActionListener{
    private JFrame window;
    private JPanel panel;
    private JLabel infantry;
    private JLabel ArmoredV;
    private JLabel Tank;
    private JLabel Fighters;
    private JLabel Bombers;
    private JButton infb;
    private JButton amvb;
    private JButton tankb;
    private JButton b4;
    private JButton b5;
    private JFrame map;

    /*
    * Construct the window, Initialize the elements, and add all elements needed
    * */
    public SelectArm(Map map){
        //transfer data from map
        this.map = map;

        //set up the window(JFrame)
        this.window = new JFrame();
        this.window.setTitle("Choose Arm");
        this.window.setBounds(460, 300, 680, 700);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set up
        this.panel = new JPanel();
        this.window.getContentPane().add(this.panel);

        //initialize buttons
        ImageIcon inf = new ImageIcon("./img/infantry4p1.png");
        ImageIcon amv = new ImageIcon("./img/av4p1.png");
        ImageIcon tk = new ImageIcon("./img/tank4p1.png");
        this.infb = new JButton("$10",inf);
        this.amvb = new JButton("$30", amv);
        this.tankb = new JButton("$50", tk);

        this.infb.setBounds(50, 300, 100, 50 );
        this.amvb.setBounds(170, 300, 100, 50);
        this.tankb.setBounds(290, 300, 100, 50);

        //add action listener to button
        this.infb.addActionListener(this);
        this.amvb.addActionListener(this);
        this.tankb.addActionListener(this);

        //add buttons to panel
        this.panel.add(infb);
        this.panel.add(amvb);
        this.panel.add(tankb);
//        this.infantry = new JLabel(inf);
//        this.ArmoredV = new JLabel(amv);
//        this.Tank = new JLabel(tk);
//        this.infb = new JButton("Produce Infantry");
//        this.amvb = new JButton("Produce Armored Vehicle");
//        this.tankb = new JButton("Produce Tank");

        map.getContentPane().add(this.window);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.infb){

        }

        else if(e.getSource() == this.amvb){

        }

        else if(e.getSource() == this.tankb){

        }
    }

}
