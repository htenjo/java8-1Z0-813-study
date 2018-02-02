package co.zero.ocp;

import org.junit.Test;

import static co.zero.ocp.GeneralKnowledge.Circle;
import static co.zero.ocp.GeneralKnowledge.Figure;
import static co.zero.ocp.GeneralKnowledge.Figure3D;
import static co.zero.ocp.GeneralKnowledge.INT;
import static co.zero.ocp.GeneralKnowledge.INTEGER;
import static co.zero.ocp.GeneralKnowledge.OBJECT;
import static co.zero.ocp.GeneralKnowledge.SHORT;
import static co.zero.ocp.GeneralKnowledge.STRING;
import static co.zero.ocp.GeneralKnowledge.Shape;
import static co.zero.ocp.GeneralKnowledge.ShapeEqualsOk;
import static co.zero.ocp.GeneralKnowledge.ShapeEqualsWrong;
import static co.zero.ocp.GeneralKnowledge.Triangle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GeneralLKnowledgeTest {
    @Test
    public void constructor_works_whenNewIsCall() {
        GeneralKnowledge instance = new GeneralKnowledge();
        assertNotNull(instance);
    }

    @Test
    public void overloading_resolveUp_whenUsingDifferentTypes() {
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
    public void overloading_resolveUp_whenThereIsNotExactType() {
        String intResult = GeneralKnowledge.overloadingUp(1);
        String stringResult = GeneralKnowledge.overloadingUp("Something");

        assertEquals(INTEGER, intResult);
        assertEquals(OBJECT, stringResult);
    }

    @Test
    public void overloading_resolveUp_whenThereIsLowerTypes() {
        String intRetult = GeneralKnowledge.overloadingDown(1);

        assertEquals(OBJECT, intRetult);
    }

    @Test
    public void override_hiddeParentMethod_whenChildMethodUseCovariantParameters() {
        ShapeEqualsWrong shape1 = new ShapeEqualsWrong(1, 2);
        ShapeEqualsWrong shape2 = new ShapeEqualsWrong(1, 2);
        Object shape3 = new ShapeEqualsWrong(1, 2);
        Object shape4 = shape1;

        assertTrue(shape1.equals(shape2)); //Not overriding, just using the method that hides the equals from Object
        assertFalse(shape1.equals(shape3)); //As parameter Object, then using the equals from Object
        assertFalse(shape3.equals(shape1)); //Static type is Object, dynamic is Shape1, however equals is not...
        assertFalse(shape3.equals(shape4)); //overridden then equals from Object is used

    }

    @Test
    public void override_works_whenChildMethodSignatureIsSameAsParent() {
        ShapeEqualsOk shape1 = new ShapeEqualsOk(1, 2);
        ShapeEqualsOk shape2 = new ShapeEqualsOk(1, 2);
        Object shape3 = new ShapeEqualsOk(1, 2);

        assertTrue(shape1.equals(shape2));
        assertTrue(shape1.equals(shape3));
        assertTrue(shape3.equals(shape1));
    }

    @Test
    public void override_works_whenExactSignature() {
        Circle circle1 = new Circle(1, 1);
        Shape shape1 = circle1;
        Integer param = new Integer(1);
        Object objectParam = param;
        Triangle triangle1 = new Triangle(1, 2);
        Shape shape2 = triangle1;

        assertTrue(circle1.getName(1).equals("OverrideOK"));
        assertTrue(shape1.getName(1).equals("OverrideOK"));
        assertTrue(circle1.getName(param).equals("OverrideInteger")); //Not override
        assertTrue(circle1.getName(objectParam).equals("OverrideObject")); //Not override

        assertTrue(triangle1.getWrapperName(new Long(1)).equals("OverrideOK"));
        assertTrue(triangle1.getWrapperName(1L).equals("OverrideLowerLong")); //Not override
    }

    @Test
    public void override_works_whenChildMethodUsesCovariantReturn() {
        Figure figure = new Figure();
        Figure figure3d = new Figure3D();

        assertTrue(figure.drawFigure() instanceof Shape);
        assertTrue(figure.drawFigure().getName(1).equals("Shape1"));

        assertTrue(figure3d.drawFigure() instanceof Circle);
        assertTrue(figure3d.drawFigure().getName(1).equals("OverrideOK"));
    }
}