package bq3.nation;

public abstract class Nation {
    private String nation;
    public Nation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }


    public void setNation(String nation) {
        this.nation = nation;
    }

    public abstract void Special_Unit();
    public abstract void National_Spirit();
}
