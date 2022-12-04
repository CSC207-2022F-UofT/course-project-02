package bq3.listener;

import bq3.Login;
import bq3.SelectCountryFrame;
import bq3.nation.Germany;
import bq3.nation.Japan;
import bq3.nation.UK;
import bq3.nation.US;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectCountryListener {

    public void listener(SelectCountryFrame frame) {
        frame.getLabel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(frame.getName(), "Germany");
                frame.getPlayer().setNation(new Germany());
                frame.setVisible(false);
                synchronized (frame.getLock()) {
                    frame.getLock().notify();
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
                frame.getTextField().setText("Germany \n" +
                        "  National Spirit\n" +
                        "   -Lightning war, tank + movement points\n" +
                        "  Special Unit\n" +
                        "   -Tiger Tank + attack + defense");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                frame.getTextField().setText("");
            }
        });
        frame.getLabel1().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(frame.getName(), "United Kindom");
                frame.getPlayer().setNation(new UK());
                frame.setVisible(false);
                synchronized (frame.getLock()) {
                    frame.getLock().notify();
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
                frame.getTextField().setText("United Kindom\n" +
                        "  National Spirit\n" +
                        "   -We shall never surrender - army defense ++\n" +
                        "  Special Unit:\n" +
                        "   -Spit Fire fighters + attack");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                frame.getTextField().setText("");
            }
        });
        frame.getLabel2().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(frame.getName(), "United States");
                frame.getPlayer().setNation(new US());
                frame.setVisible(false);
                synchronized (frame.getLock()) {
                    frame.getLock().notify();
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
                frame.getTextField().setText("United States\n" +
                        "                         National Spirit\n" +
                        "   -World’s Factory: +productivity\n" +
                        "  Special Units:\n" +
                        "   -B52 bombers +attack");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                frame.getTextField().setText("");
            }
        });
        frame.getLabel3().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(frame.getName(), "Imperial Japan");
                frame.getPlayer().setNation(new Japan());
                frame.setVisible(false);
                synchronized (frame.getLock()) {
                    frame.getLock().notify();
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
                frame.getTextField().setText("Imperial Japan\n" +
                        "National Spirit\n" +
                        "   -Bushido Army attack / 2 when blood < 50%\n" +
                        "  Special Unit\n" +
                        "   -Type 95 Light tank ++ movement - defense");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                frame.getTextField().setText("");
            }
        });
        frame.getLabel4().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Login.PLAY_COUNTRY_MAP.put(frame.getName(), "Soviet Union");
                frame.getPlayer().setNation(new Germany());
                frame.setVisible(false);
                synchronized (frame.getLock()) {
                    frame.getLock().notify();
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
                frame.getTextField().setText("Soviet Union\n" +
                        "  National Spirit:\n" +
                        "   -Winter Fighters: Snowy location attack+ defense+\n" +
                        "        P(snow) + in captured region");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                frame.getTextField().setText("");
            }
        });
    }
}
