package bq3.Presenter;


import bq3.Entity.Arm.Infantry;
import bq3.Entity.Constant;
import bq3.Entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Choose Arm type that under related nations
 */

public class SelectArmyFrame extends JFrame{
    /**
     * SelectArmyFrame itself
     */
    private SelectArmyFrame frame;

    /**
     * players
     */
    private String name;

    /**
     * Store Infantry, Armored Vehicle, Tank
     */
    private Panel panel1;

    /**
     * Store Fighters and Bombers
     */
    private Panel panel2;

    /**
     * Store Constructions
     */
    private Panel panel3;

    /**
     * 描述显示
     * Describtion
     */
    private JTextArea textField;

    /**
     * Infantry
     */
    private JLabel label;

    /**
     * Armored Vehicle
     */
    private JLabel label1;

    /**
     * Tank
     */
    private JLabel label2;

    /**
     * Fighters
     */
    private JLabel label3;

    /**
     * Bombers
     */
    private JLabel label4;

    /**
     *  Battery
     */
    private JLabel label5;

    /**
     * Bunkers
     */
    private JLabel label6;

    /**
     * Military Camp
     */
    private JLabel label7;

    /**
     * Airport
     */
    private JLabel label8;

    /**
     * Battle
     */
    private JLabel label9;

    /**
     * 锁对象
     */
    private Object lock;

    /**
     * 玩家对象
     */
    private Player player;

    public SelectArmyFrame(String name, Object lock, Player player1) {
        this.name = name;
        this.lock = lock;
        this.player = player1;
        this.setTitle("Select Army" + name);
        this.setSize((int) Constant.getWidths(),(int)Constant.getHeights());
        this.setBounds(460, 300, 680, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLocationRelativeTo(null);
        textField = new JTextArea(10, 30);
        textField.setFont(new Font(null, 0, 20));
        textField.setOpaque(false);
        textField.setEditable(false);

        this.setImg();
        this.setMouseListener();

        this.add(panel1);
        this.add(panel2);
        this.add(textField);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.frame = this;
    }

    public void setImg() {
        panel1 = new Panel();

        label = new JLabel();
        ImageIcon img = new ImageIcon("infantry4p1.png");
        img.setImage(img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        label.setBounds(166, 98, 103, 51);
        label.setIcon(img);

        label1 = new JLabel();
        ImageIcon img1 = new ImageIcon("tank4p1.png");
        img1.setImage(img1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        label1.setBounds(166, 98, 103, 51);
        label1.setIcon(img1);

        label2 = new JLabel();
        ImageIcon img2 = new ImageIcon("1.png");
        img2.setImage(img2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        label2.setBounds(166, 98, 103, 51);
        label2.setIcon(img2);

        panel2 = new Panel();

        label3 = new JLabel();
        ImageIcon img3 = new ImageIcon("1.png");
        img3.setImage(img3.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        label3.setBounds(166, 98, 103, 51);
        label3.setIcon(img3);

        label4 = new JLabel();
        ImageIcon img4 = new ImageIcon("1.png");
        img4.setImage(img4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        label4.setBounds(166, 98, 103, 51);
        label4.setIcon(img4);

        panel1.add(label);
        panel1.add(label1);
        panel1.add(label2);
        panel2.add(label3);
        panel2.add(label4);
    }

    public void setMouseListener() {
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(name, "Infantry");
                player.addArm(new Infantry(new Map(), 5, 10));
                frame.setVisible(false);
                synchronized (lock) {
                    lock.notify();
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                textField.setText("Germany \n" +
                        "  National Spirit\n" +
                        "   -Lightning war, tank + movement points\n" +
                        "  Special Unit\n" +
                        "   -Tiger Tank + attack + defense");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                textField.setText("");
            }
        });
    }
}

