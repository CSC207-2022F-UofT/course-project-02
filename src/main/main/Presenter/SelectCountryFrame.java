package main.Presenter;

import main.Entity.Player;
import main.Entity.nation.Germany;
import main.Entity.nation.Japan;
import main.Entity.nation.UK;
import main.Entity.nation.US;
import main.server.MouseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Select country
 */
public class SelectCountryFrame extends JFrame implements MouseService {

    /**
     * SelectCountryFrame self
     */
    private SelectCountryFrame frame;

    /**
     * Player Name
     */
    private String name;

    public String getName() {
        return name;
    }

    /**
     * First row country
     */
    private Panel panel1;

    /**
     * Deposit in the second row of countries
     */
    private Panel panel2;

    /**
     * Description display
     */
    private JTextArea textField;

    public JTextArea getTextField() {
        return textField;
    }

    /**
     * Country 1
     */
    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    /**
     * Country 2
     */
    private JLabel label1;

    public JLabel getLabel1() {
        return label1;
    }

    /**
     * Country 3
     */
    private JLabel label2;

    public JLabel getLabel2() {
        return label2;
    }

    /**
     * Country 4
     */
    private JLabel label3;

    public JLabel getLabel3() {
        return label3;
    }

    /**
     * Country 5
     */
    private JLabel label4;

    public JLabel getLabel4() {
        return label4;
    }

    /**
     * Lock object
     */
    private Object lock;

    public Object getLock() {
        return lock;
    }

    /**
     * Player object
     */
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public SelectCountryFrame(String name, Object lock, Player player1) {
        this.name = name;
        this.lock = lock;
        this.player = player1;
        this.setTitle("Select Country" + name);
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
        ImageIcon img = new ImageIcon("img/Nazi Germany.png");
        img.setImage(img.getImage().getScaledInstance(210, 120, Image.SCALE_DEFAULT));
        label.setBounds(166, 98, 310, 100);
        label.setIcon(img);

        label1 = new JLabel();
        ImageIcon img1 = new ImageIcon("img/UK.png");
        img1.setImage(img1.getImage().getScaledInstance(210, 120, Image.SCALE_DEFAULT));
        label1.setBounds(166, 98, 310, 100);
        label1.setIcon(img1);

        label2 = new JLabel();
        ImageIcon img2 = new ImageIcon("img/US.png");
        img2.setImage(img2.getImage().getScaledInstance(210, 120, Image.SCALE_DEFAULT));
        label2.setBounds(166, 98, 310, 100);
        label2.setIcon(img2);

        panel2 = new Panel();

        label3 = new JLabel();
        ImageIcon img3 = new ImageIcon("img/Imperial Japan.png");
        img3.setImage(img3.getImage().getScaledInstance(210, 120, Image.SCALE_DEFAULT));
        label3.setBounds(166, 98, 310, 100);
        label3.setIcon(img3);

        label4 = new JLabel();
        ImageIcon img4 = new ImageIcon("img/Soviet Union.png");
        img4.setImage(img4.getImage().getScaledInstance(210, 120, Image.SCALE_DEFAULT));
        label4.setBounds(166, 98, 310, 100);
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
                Login.PLAY_COUNTRY_MAP.put(name, "Germany");
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
                Login.PLAY_COUNTRY_MAP.put(name, "United Kindom");
                player.setNation(new UK());
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
                        "   -World???s Factory: +productivity\n" +
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
