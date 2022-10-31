package bq3;

import java.awt.*;

public abstract class Gameobject {

    Image img;
    //游戏元素的横坐标
    int x;
    //游戏元素的纵坐标
    int y;
    //游戏元素的宽
    int width;
    //游戏元素的高
    int height;

    //引入主界面
    Map map;

    public Gameobject(Map map){
        this.map = map;
    }

    public Gameobject(String img, Map map) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.map = map;
    }

    public Gameobject(Map map,int x, int y) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public Gameobject(String img, int x, int y, int width, int height, Map map) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.map = map;
    }

    public Gameobject() {
    }

    public Image getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public Map getMap() {
        return map;
    }

    public void setMap(Map frame) {
        this.map = frame;
    }
    //继承元素绘制自己的方法
    public abstract void paintSelf(Graphics g);

    //获取当前游戏元素的矩形,是为碰撞检测而写
    public abstract Rectangle getRec();
}
