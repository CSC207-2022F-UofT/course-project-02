package main.listener;

import main.Entity.Constant;
import main.Presenter.Login;
import main.Presenter.LoginFrame;
import main.Presenter.Map;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginListener {

    public void listener(Login login) {
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //点击开始游戏
                //Click to open the game
                //打开上次游戏（还没做，等全做好了再加）
                if(e.getButton()==1&
                        e.getX()<=200&
                        e.getY()>=220&
                        e.getY()<=270){
                    if(Constant.getByx()==0){
                        new LoginFrame();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Cannot open repeatedly");
                    }
                }
                //设置（还没写）
                if (e.getX()<=200&
                        e.getY()>=370&
                        e.getY()<=420){
                    if(Constant.getByx()==0){
                        Constant.setByx(1);
                        //repaint();
                        new Map().map();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Cannot open repeatedly");
                    }
                }
                //退出游戏
                //Exit the game
                if (e.getX()<=100&
                        e.getY()>=450&
                        e.getY()<=520&
                        Constant.isMultyxz()) {
                    System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Constant.setMultyxz(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
