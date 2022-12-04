package bq3;

import bq3.listener.LoginFrameListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

/**
 * Login UI
 */
public class LoginFrame {

    /**
     * Lock Object 1
     */
    public static final Object lock = new Object();

    /**
     * Lock Object 2
     */
    public static final Object lock1 = new Object();

    /**
     * Lock Object 3
     */
    public static final Object lock2 = new Object();

    /**
     * Main frame
     */
    private JFrame frame;

    /**
     * Account tag
     */
    private JLabel loginAccount;

    /**
     * Account text
     */
    private JTextField textField;

    /**
     * Password Label
     */
    private JLabel loginPwd;

    /**
     * Password text
     */
    private JPasswordField passwordField;

    /**
     * Login button
     */
    private JButton loginButton;

    /**
     * User List
     */
    public static HashMap<String, String> accountMap = new HashMap<>();

    public LoginFrame() {
        accountMap.put("admin", "admin");
        setFrame();
        listen();
    }

    public void setFrame() {
        frame = new JFrame("兵棋");
        frame.setBounds(460, 300, 400, 160);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setLocationRelativeTo(null);

        loginAccount = new JLabel("Account");
        textField = new JTextField("", 30);

        loginPwd = new JLabel("Password");
        passwordField = new JPasswordField("", 30);

        loginButton = new JButton("Login");

        frame.add(loginAccount);
        frame.add(textField);
        frame.add(loginPwd);
        frame.add(passwordField);
        frame.add(loginButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new SelectCountryFrame());
    }

    /**
     * 监听点击按钮
     */
    public void listen() {
        new LoginFrameListener().listen(loginButton, textField, passwordField, frame);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}