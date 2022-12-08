package main.Entity.terrain;

/**
 * Terrain
 *
 * @author Liyuan Cao
 */
public class Terrain {

    /**
     * name
     */
    private String name;

    /**
     * describe
     */
    private String desc;

    public Terrain(){}

    public Terrain(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
