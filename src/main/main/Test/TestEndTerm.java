package main.Test;

import main.Entity.Constant;
import main.Usecase.EndTerm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEndTerm {

    @Test
    public void testEndTerm() {
        Constant.addallcells();
        EndTerm endTerm = new EndTerm(1);
        assertEquals(2, Constant.getPnum());
        assertEquals(2, Constant.getPlayer2().getMove());
        endTerm = new EndTerm(2);
        assertEquals(1, Constant.getPnum());
        assertEquals(2, Constant.getPlayer2().getMove());
        endTerm = new EndTerm(1);
        assertEquals(2, Constant.getPnum());
        assertEquals(2, Constant.getPlayer2().getMove());
        endTerm = new EndTerm(2);
        assertEquals(1, Constant.getPnum());
        assertEquals(2, Constant.getPlayer2().getMove());
    }
}
