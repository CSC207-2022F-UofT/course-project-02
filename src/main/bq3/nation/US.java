package bq3.nation;

public class US extends Nation{
    public US() {
        super("United States");
    }

    @Override
    public Object[] getArms() {
        return new Object[]{"Infantry", "Armored Vechicle", "Tank"};
    }

    @Override
    public void National_Spirit() {

    }
}
