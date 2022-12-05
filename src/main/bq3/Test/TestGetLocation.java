package bq3.Test;

import bq3.Entity.Constant;
import bq3.Usecase.GetLoction;
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
