package bq3.nation;

public class Germany extends Nation{

    public Germany() {
        super("Germany");
    }


    @Override
    public Object[] getArms() {
        return new Object[]{"Infantry", "Armored Vechicle", "Tank", "Tiger Tank"};
    }

    @Override
    public void National_Spirit() {

    }
}
