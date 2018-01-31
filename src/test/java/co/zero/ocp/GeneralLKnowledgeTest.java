package co.zero.ocp;

import org.junit.Test;

import static co.zero.ocp.GeneralKnowledge.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GeneralLKnowledgeTest {
    @Test
    public void verifyConstructor() {
        GeneralKnowledge instance = new GeneralKnowledge();
        assertNotNull(instance);
    }

    @Test
    public void verifyOverloadingResolutionTypes() {
        String stringResult = GeneralKnowledge.overloadingPrint("9");
        String intResult = GeneralKnowledge.overloadingPrint(9);

        byte number = 9;
        String byteResult = GeneralKnowledge.overloadingPrint(number);

        Integer integer = new Integer(9);
        String integerResult = GeneralKnowledge.overloadingPrint(integer);

        String doubleResult = GeneralKnowledge.overloadingPrint(1.5);

        assertEquals(STRING, stringResult);
        assertEquals(INT, intResult);
        assertEquals(OBJECT, integerResult);
        assertEquals(SHORT, byteResult);
        assertEquals(OBJECT, doubleResult);
    }

    @Test
    public void verifyOverloadingUp() {
        String intResult = GeneralKnowledge.overloadingUp(1);
        String stringResult = GeneralKnowledge.overloadingUp("Something");

        assertEquals(INTEGER, intResult);
        assertEquals(OBJECT, stringResult);
    }

    @Test
    public void verifyOverloadingDown() {
        String intRetult = GeneralKnowledge.overloadingDown(1);

        assertEquals(OBJECT, intRetult);
    }
}
