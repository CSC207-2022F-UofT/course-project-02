package main.Test;

import main.Entity.Constant;
import main.Usecase.GetLoction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetLocation {

    @Test
    public void testLoction() {
        Constant.addallcells();
        GetLoction getLoction = new GetLoction(1);
        assertEquals("Plain", getLoction.getTerrain());
        getLoction = new GetLoction(2);
        assertEquals("Swamp", getLoction.getTerrain());
        getLoction = new GetLoction(3);
        assertEquals("Plain", getLoction.getTerrain());
        getLoction = new GetLoction(4);
        assertEquals("Plain", getLoction.getTerrain());
        getLoction = new GetLoction(5);
        assertEquals("Plain", getLoction.getTerrain());
    }

}
