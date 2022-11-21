package bq3;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

/**
 * 登录界面UI
 */
public class LoginFrame {

    /**
     * 锁对象 1
     */
    public static final Object lock = new Object();

    /**
     * 锁对象 2
     */
    public static final Object lock1 = new Object();

    /**
     * 锁对象 2
     */
    public static final Object lock2 = new Object();

    /**
     * 主体框架
     */
    private JFrame frame;

    /**
     * 账号标签
     */
    private JLabel loginAccount;

    /**
     * 账号文本
     */
    private JTextField textField;

    /**
     * 密码标签
     */
    private JLabel loginPwd;

    /**
     * 密码文本
     */
    private JPasswordField passwordField;

    /**
     * 登录按钮
     */
    private JButton loginButton;

    /**
     * 用户列表
     */
    private HashMap<String, String> accountMap = new HashMap<>();

    public LoginFrame() {
        accountMap.put("admin", "admin");
        setFrame();
        listen();
    }

    public void setFrame() {
        frame = new JFrame("兵棋");
        frame.setBounds(460, 300, 380, 160);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setLocationRelativeTo(null);

        loginAccount = new JLabel("账户");
        textField = new JTextField("", 30);

        loginPwd = new JLabel("密码");
        passwordField = new JPasswordField("", 30);

        loginButton = new JButton("登录");

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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String msg = "";
                if (textField.getText() == null || textField.getText().length() == 0) {
                    msg = "账号不能为空";
                } else if (passwordField.getPassword().length == 0) {
                    msg = "密码不能为空";
                } else if (isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
                    msg = "账户与密码未匹配";
                }
                if (!msg.equals("")) {
                    JDialog mistakeCase = new JDialog(frame, "提示");
                    mistakeCase.setBounds(400, 500, 200, 100);
                    mistakeCase.setLocationRelativeTo(null);

                    JTextField fieldOfError = new JTextField(msg, 25);
                    fieldOfError.setEditable(false);
                    fieldOfError.setBorder(new LineBorder(Color.WHITE, 0));
                    fieldOfError.setHorizontalAlignment(JTextField.CENTER);
                    mistakeCase.add(fieldOfError);
                    frame.setVisible(false);
                    mistakeCase.setVisible(true);
                    mistakeCase.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    // 添加 dialog 关闭事件
                    mistakeCase.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            mistakeCase.setVisible(false);
                            frame.setVisible(true);
                        }
                    });
                } else {
                    frame.setVisible(false);
                    Thread t1 = new Thread(() -> {
                        synchronized (lock) {
                          //  new SelectCountryFrame("player 1", lock1, Constant.getPlayer1());
                            new SelectArmyFrame("player 1", lock1, Constant.getPlayer1());
                        }
                    });
                    t1.start();
                    // 启动第二个线程 第二个玩家进行等待
                    Thread t2 = new Thread(() -> {
                        synchronized (lock1) {
                            try {
                                lock1.wait();
                                new SelectCountryFrame("player 2", lock2, Constant.getPlayer2());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t2.start();
                    // 玩家选择国家后继续
                    Thread t3 = new Thread(() -> {
                        synchronized (lock2) {
                            /*while(true) {
                                if (Login.PLAY_COUNTRY_MAP.size() > 1) break;
//                                System.out.println(1);
                            }*/
                            try {
                                lock2.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Constant.addallcells();
                            Constant.setCanProduce();
                            new Map().map();
                        }
                    });
                    t3.start();
                }
            }
        });
    }

    /**
     * 判断是否登录
     * @param account 用户名
     * @param password 密码
     * @return true/false
     */
    public boolean isLogin(String account, String password) {
        String pwd = accountMap.get(account);
        return !password.equals(pwd);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}