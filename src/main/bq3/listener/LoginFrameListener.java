package bq3.listener;

import bq3.Constant;
import bq3.LoginFrame;
import bq3.Map;
import bq3.SelectCountryFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrameListener {
    public void listen(JButton loginButton, JTextField textField, JPasswordField passwordField, JFrame frame) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String msg = "";
                if (textField.getText() == null || textField.getText().length() == 0) {
                    msg = "The Account should not be empty";
                } else if (passwordField.getPassword().length == 0) {
                    msg = "The password should not be empty";
                } else if (isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
                    msg = "account and password does not match";
                }
                if (!msg.equals("")) {
                    JDialog mistakeCase = new JDialog(frame, "Hint");
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
                        synchronized (LoginFrame.lock) {
                            new SelectCountryFrame("player 1", LoginFrame.lock1, Constant.getPlayer1());
                        }
                    });
                    t1.start();
                    // 启动第二个线程 第二个玩家进行等待
                    Thread t2 = new Thread(() -> {
                        synchronized (LoginFrame.lock1) {
                            try {
                                LoginFrame.lock1.wait();
                                new SelectCountryFrame("player 2", LoginFrame.lock2, Constant.getPlayer2());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t2.start();
                    // 玩家选择国家后继续
                    Thread t3 = new Thread(() -> {
                        synchronized (LoginFrame.lock2) {
                            /*while(true) {
                                if (Login.PLAY_COUNTRY_MAP.size() > 1) break;
//                                System.out.println(1);
                            }*/
                            try {
                                LoginFrame.lock2.wait();
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
        String pwd = LoginFrame.accountMap.get(account);
        return !password.equals(pwd);
    }
}
