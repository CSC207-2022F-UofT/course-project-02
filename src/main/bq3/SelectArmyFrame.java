package bq3;


import bq3.Arm.ArmoredVehicle;
import bq3.Arm.Infantry;
import bq3.nation.Germany;
import bq3.nation.Japan;
import bq3.nation.UK;
import bq3.nation.US;

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
        this.setSize((int)Constant.getWidths(),(int)Constant.getHeights());
        //this.setBounds(460, 300, 680, 700);
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
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.frame = this;
    }

    public void setImg() {
        panel1 = new Panel();
        int i = 1;
        int j = 1;

        label = new JLabel();
        ImageIcon img = new ImageIcon("img/Infantry.jpg");
        img.setImage(img.getImage().getScaledInstance(i*200, i*200, Image.SCALE_DEFAULT));
        label.setBounds(i*166, i*98, i*103, i*51);
        label.setIcon(img);

        label1 = new JLabel();
        ImageIcon img1 = new ImageIcon("img/Armored_Vehicle.jpg");
        img1.setImage(img1.getImage().getScaledInstance(i*200, i*200, Image.SCALE_DEFAULT));
        label1.setBounds(i*166, i*98, i*103, i*51);
        label1.setIcon(img1);

        label2 = new JLabel();
        ImageIcon img2 = new ImageIcon("img/Tank.jpg");
        img2.setImage(img2.getImage().getScaledInstance(i*200, i*200, Image.SCALE_DEFAULT));
        label2.setBounds(i*166, i*98, i*103, i*51);
        label2.setIcon(img2);

        panel2 = new Panel();

        label3 = new JLabel();
        ImageIcon img3 = new ImageIcon("img/Fighters.jpg");
        img3.setImage(img3.getImage().getScaledInstance(i*200, i*200, Image.SCALE_DEFAULT));
        label3.setBounds(i*166, i*98, i*103, i*51);
        label3.setIcon(img3);

        label4 = new JLabel();
        ImageIcon img4 = new ImageIcon("img/Bombers.jpg");
        img4.setImage(img4.getImage().getScaledInstance(i*200, i*200, Image.SCALE_DEFAULT));
        label4.setBounds(i*166, i*98, i*103, i*51);
        label4.setIcon(img4);


        label5 = new JLabel();
        ImageIcon img5 = new ImageIcon("img/Bombers.jpg");
        img4.setImage(img5.getImage().getScaledInstance(j*200, j*200, Image.SCALE_DEFAULT));
        label5.setBounds(i*166, i*98, i*103, i*51);
        label5.setIcon(img5);

        label6 = new JLabel();
        ImageIcon img6 = new ImageIcon("img/Bombers.jpg");
        img4.setImage(img6.getImage().getScaledInstance(j*200, j*200, Image.SCALE_DEFAULT));
        label6.setBounds(i*166, i*98, i*103, i*51);
        label6.setIcon(img6);

        label7 = new JLabel();
        ImageIcon img7 = new ImageIcon("img/Bombers.jpg");
        img7.setImage(img7.getImage().getScaledInstance(j*200, j*200, Image.SCALE_DEFAULT));
        label7.setBounds(i*166, i*98, i*103, i*51);
        label7.setIcon(img7);

        label8 = new JLabel();
        ImageIcon img8 = new ImageIcon("img/Bombers.jpg");
        img7.setImage(img8.getImage().getScaledInstance(j*200, j*200, Image.SCALE_DEFAULT));
        label8.setBounds(i*166, i*98, i*103, i*51);
        label8.setIcon(img8);

        label9 = new JLabel();
        ImageIcon img9 = new ImageIcon("img/Bombers.jpg");
        img7.setImage(img9.getImage().getScaledInstance(j*200, j*200, Image.SCALE_DEFAULT));
        label9.setBounds(i*166, i*98, i*103, i*51);
        label9.setIcon(img9);

        panel1.add(label);
        panel1.add(label1);
        panel1.add(label2);
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(label5);
        panel2.add(label6);
        panel2.add(label7);
        panel2.add(label8);
        panel2.add(label9);
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
        label1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(name, "Armored_Vehicle");
                player.addArm(new ArmoredVehicle(new Map(), 5, 10));
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
                textField.setText("United Kindom\n" +
                        "  National Spirit\n" +
                        "   -We shall never surrender - army defense ++\n" +
                        "  Special Unit:\n" +
                        "   -Spit Fire fighters + attack");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                textField.setText("");
            }
        });
        label2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(name, "United States");
                player.setNation(new US());
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
                textField.setText("United States\n" +
                        "                         National Spirit\n" +
                        "   -World’s Factory: +productivity\n" +
                        "  Special Units:\n" +
                        "   -B52 bombers +attack");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                textField.setText("");
            }
        });
        label3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(name, "Imperial Japan");
                player.setNation(new Japan());
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
                textField.setText("Imperial Japan\n" +
                        "National Spirit\n" +
                        "   -Bushido Army attack / 2 when blood < 50%\n" +
                        "  Special Unit\n" +
                        "   -Type 95 Light tank ++ movement - defense");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                textField.setText("");
            }
        });
        label4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(name, "Soviet Union");
                player.setNation(new Germany());
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
                textField.setText("Soviet Union\n" +
                        "  National Spirit:\n" +
                        "   -Winter Fighters: Snowy location attack+ defense+\n" +
                        "        P(snow) + in captured region");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                textField.setText("");
            }
        });

    }
}
