package bq3.nation;

public class UK extends Nation{
    public UK() {
        super("United Kindom");
    }

    @Override
    public Object[] getArms() {
        return new Object[]{"Infantry", "Armored Vechicle", "Tank"};
    }

    @Override
    public void National_Spirit() {

    }
}
