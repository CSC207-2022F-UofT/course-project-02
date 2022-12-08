package main.Entity;

import main.Entity.Weather.Rain;
import main.Entity.Weather.Snow;
import main.Entity.Weather.Sunny;
import main.Entity.Weather.Weather;
import main.Presenter.Map;
import main.Entity.cell.Cell;

import java.awt.*;
import java.util.ArrayList;

public class Constant {

    static Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();
    static double widths = screenSize.getWidth();
    static double heights = screenSize.getHeight();


    static int height=820;
    static int width=1500;
    //距左边的距离
    //Distance to the left bound
    static int map_1=50;
    //距上边的距离
    //Distance to the upper bound
    static int map_2=70;
    //距右边的距离
    //Distance to the right bound
    static int map_3 = (int)widths-50;
    //距下边的距离
    //Distance to the lower bound
    static int map_4 = (int)heights-50;
    //字体
    //Font
    static String title="Times";
    //鼠标坐标
    //Mouse Location
    static int Mouse_X;
    static int Mouse_Y;

    static boolean Left_click=false;
    static boolean Right_click=false;
    //允许打开窗口yxz
    //Allow opening the yxz window
    static boolean multyxz;
    static int byx=0;
    //是否画兵
    //Decide whether we are going to paint the army
    static int paint;
    //谁的回合
    //Decide which player's turn
    static int state=0;

    static int i;
    static ArrayList<Cell> point = new ArrayList<>();
    static Cell c1 =new Cell(50*5+10+ Constant.getMap_1(),50*5+10+Constant.getMap_2());
//    static Cell c2 =new Cell(50*20+10+ Constant.getMap_1(),50*5+10+Constant.getMap_2());
//    static Cell c3 =new Cell(50*20+10+ Constant.getMap_1(),50*5*2+10+Constant.getMap_2());



    public static int cellnum=0;

    static Player player1=new Player();
    static Player player2=new Player();

    static Player[] allplayers = {player1,player2};
    static int term4p = 1;

    static Image bg = Toolkit.getDefaultToolkit().getImage("img/3.jpg");
    static Image p1 = Toolkit.getDefaultToolkit().getImage("img/5.png");

    static String armpic = "img/5.png";

    static int weather=0;
    static Cell nowcell;
    static Map map;
    static int pnum=1;

    static Weather[] weatherList={new Sunny(),new Rain(),new Snow()};









    public static Cell getNowcell() {
        return nowcell;
    }

    public static void setNowcell(int nowcell) {
        Constant.nowcell = Constant.getCell(nowcell);
    }

    public static Weather[] getWeatherList() {
        return weatherList;
    }

    public static int getPnum() {
        return pnum;
    }

    public static void setPnum(int pnum) {
        Constant.pnum = pnum;
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        Constant.map = map;
    }

    public static String getArmpic() {
        return armpic;
    }

    public static void setArmpic(String armpic) {
        Constant.armpic = armpic;
    }

    public static int getTerm4p() {
        return term4p;
    }

    public static void setTerm4p(int term4p) {
        Constant.term4p = term4p;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        Constant.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        Constant.player2 = player2;
    }

    public static Player[] getAllplayers() {
        return allplayers;
    }

    public static int getWeather() {
        return weather;
    }

    public static void setWeather(int weather) {
        Constant.weather = weather;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Constant.i = i;
    }

    public static void addallcells() {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 4; k++) {
                Cell cell =new Cell(100+150*j,250+150*k);
                point.add(cell);
            }
        }
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if(j!=4||k!=3){
                    Cell cell =new Cell(550+150*j,100+150*k);
                    point.add(cell);
                }
            }
        }
        Cell cell =new Cell(1300,400);
        point.add(cell);
        Cell cell1 =new Cell(1300,550);
        point.add(cell1);
        cellnum=12+24+1+1;
    }

    public static void setCanProduce(){
        for (int j = 0; j < cellnum; j++) {
            if(getCell(j).getId()==4||getCell(j).getId()==5||
                    getCell(j).getId()==8||getCell(j).getId()==9){
                Constant.getCell(j).setP1CanProduce(true);
            }
        }
        for (int j = 0; j < cellnum; j++) {
            if(getCell(j).getId()==34||getCell(j).getId()==29||
                    getCell(j).getId()==35||getCell(j).getId()==30){
                Constant.getCell(j).setP2CanProduce(true);
            }
        }
    }

    public static Cell getCell(int i) {
        for (int j = 0; j < cellnum; j++) {
            if(j==i){
                return point.get(j);
            }
        }
        return c1;
    }

    public static int getPointnum() {
        return cellnum;
    }

    public static void setPointnum(int pointnum) {
        Constant.cellnum = pointnum;
    }
    public static int getByx() {
        return byx;
    }
    public static void setByx(int byx) {
        Constant.byx = byx;
    }

    public static Image getP1() {
        return p1;
    }

    public static void setP1(Image p1) {
        Constant.p1 = p1;
    }

    public static int getState() {
        return state;
    }
    public static void setState(int state) {
        Constant.state = state;
    }

    public static Image getBg() {
        return bg;
    }

    public static void setBg(Image bg) {
        Constant.bg = bg;
    }


    public static int getPaint() {
        return paint;
    }

    public static void setPaint(int paint) {
        Constant.paint = paint;
    }

    public static boolean isMultyxz() {
        return multyxz;
    }

    public static void setMultyxz(boolean multyxz) {
        Constant.multyxz = multyxz;
    }

    public static int getMouse_X() {
        return Mouse_X;
    }

    public static void setMouse_X(int mouse_X) {
        Mouse_X = mouse_X;
    }

    public static int getMouse_Y() {
        return Mouse_Y;
    }

    public static void setMouse_Y(int mouse_Y) {
        Mouse_Y = mouse_Y;
    }

    public static boolean isLeft_click() {
        return Left_click;
    }

    public static void setLeft_click(boolean left_click) {
        Left_click = left_click;
    }

    public static boolean isRight_click() {
        return Right_click;
    }

    public static void setRight_click(boolean right_click) {
        Right_click = right_click;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Constant.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Constant.width = width;
    }

    public static int getMap_1() {
        return map_1;
    }

    public static void setMap_1(int map_1) {
        Constant.map_1 = map_1;
    }

    public static int getMap_2() {
        return map_2;
    }

    public static void setMap_2(int map_2) {
        Constant.map_2 = map_2;
    }

    public static int getMap_3() {
        return map_3;
    }

    public static void setMap_3(int map_3) {
        Constant.map_3 = map_3;
    }

    public static int getMap_4() {
        return map_4;
    }

    public static void setMap_4(int map_4) {
        Constant.map_4 = map_4;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Constant.title = title;
    }

    public static double getWidths() {
        return widths;
    }

    public static void setWidths(double widths) {
        Constant.widths = widths;
    }

    public static double getHeights() {
        return heights;
    }

    public static void setHeights(double heights) {
        Constant.heights = heights;
    }
}
