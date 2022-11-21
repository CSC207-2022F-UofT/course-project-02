package bq3.nation;

public class Japan extends Nation{
    public Japan() {
        super("Imperial Japan");
    }

    @Override
    public Object[] getArms() {
        return new Object[]{"Infantry", "Armored Vechicle", "Tank", "Type 95 Light Tank"};
    }

    @Override
    public void National_Spirit() {

    }
}
