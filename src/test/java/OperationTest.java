import controller.Operation;
import model.Polynom;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OperationTest {
    @Test
    public void additionTests() {
        Operation op = new Operation();
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();

        p1.setPolynom("2x^4-3x^3-15x^2+32x-12");
        p1.monomyalSplit();
        p2.setPolynom("x^2-4x-12");
        p2.monomyalSplit();

        assertTrue("Correct addition result: 2x^4−3x^3−14x^2+28x−24",
                op.addPolynoms(p1, p2).toString().equals("2x^4-3x^3-14x^2+28x-24"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^3+4x^2+x+3");
        p1.monomyalSplit();
        p2.setPolynom("x^2-2x-1");
        p2.monomyalSplit();

        assertTrue("Correct addition result: 2x^3+5x^2-x+2",
                op.addPolynoms(p1, p2).toString().equals("2x^3+5x^2-x+2"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+4x+5");
        p1.monomyalSplit();
        p2.setPolynom("x^4-2x^3+9x-6");
        p2.monomyalSplit();

        assertTrue("Correct addition result: x^4-x^3+13x-1",
                op.addPolynoms(p1, p2).toString().equals("x^4-x^3+13x-1"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^5+7x^2+3x+9");
        p1.monomyalSplit();
        p2.setPolynom("-12x^4+9x^3+7");
        p2.monomyalSplit();

        assertTrue("Correct addition result: 2x^5-12x^4+9x^3+7x^2+3x+16",
                op.addPolynoms(p1, p2).toString().equals("2x^5-12x^4+9x^3+7x^2+3x+16"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^2+3x+4");
        p1.monomyalSplit();
        p2.setPolynom("-12");
        p2.monomyalSplit();

        assertTrue("Correct addition result: 2x^2+3x-8",
                op.addPolynoms(p1, p2).toString().equals("2x^2+3x-8"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+x^2-2x-6");
        p1.monomyalSplit();
        p2.setPolynom("x-7");
        p2.monomyalSplit();

        assertTrue("Correct addition result: x^3+x^2-x-13",
                op.addPolynoms(p1, p2).toString().equals("x^3+x^2-x-13"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+12x+9");
        p1.monomyalSplit();
        p2.setPolynom("0");
        p2.monomyalSplit();

        assertTrue("Correct addition result: x^2+12x+9",
                op.addPolynoms(p1, p2).toString().equals("x^2+12x+9"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("9");
        p1.monomyalSplit();
        p2.setPolynom("-4");
        p2.monomyalSplit();

        assertTrue("Correct addition result: 5",
                op.addPolynoms(p1, p2).toString().equals("5"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^12-2x^8+4x^5-9x^2+12x-4");
        p1.monomyalSplit();
        p2.setPolynom("x^3-x^2-x+1");
        p2.monomyalSplit();

        assertTrue("Correct addition result: x^12-2x^8+4x^5+x^3-10x^2+11x-3",
                op.addPolynoms(p1, p2).toString().equals("x^12-2x^8+4x^5+x^3-10x^2+11x-3"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("-x^2-3x-4");
        p1.monomyalSplit();
        p2.setPolynom("-3x^3-2x^2+1");
        p2.monomyalSplit();

        assertTrue("Correct addition result: -3x^3-3x^2-3x-3",
                op.addPolynoms(p1, p2).toString().equals("-3x^3-3x^2-3x-3"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+2x+1");
        p1.monomyalSplit();
        p2.setPolynom("-x^2-2x-1");
        p2.monomyalSplit();

        assertTrue("Correct addition result: 0",
                op.addPolynoms(p1, p2).toString().equals("0"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();
    }

    @Test
    public void subtractionTests() {
        Operation op = new Operation();
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();

        p1.setPolynom("2x^4-3x^3-15x^2+32x-12");
        p1.monomyalSplit();
        p2.setPolynom("x^2-4x-12");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 2x^4-3x^3-16x^2+36x",
                op.subtractPolynoms(p1, p2).toString().equals("2x^4-3x^3-16x^2+36x"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^3+4x^2+x+3");
        p1.monomyalSplit();
        p2.setPolynom("x^2-2x-1");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 2x^3+3x^2+3x+4",
                op.subtractPolynoms(p1, p2).toString().equals("2x^3+3x^2+3x+4"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+4x+5");
        p1.monomyalSplit();
        p2.setPolynom("x^4-2x^3+9x-6");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: -x^4+3x^3-5x+11",
                op.subtractPolynoms(p1, p2).toString().equals("-x^4+3x^3-5x+11"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^5+7x^2+3x+9");
        p1.monomyalSplit();
        p2.setPolynom("-12x^4+9x^3+7");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 2x^5+12x^4-9x^3+7x^2+3x+2",
                op.subtractPolynoms(p1, p2).toString().equals("2x^5+12x^4-9x^3+7x^2+3x+2"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^2+3x+4");
        p1.monomyalSplit();
        p2.setPolynom("-12");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 2x^2+3x+16",
                op.subtractPolynoms(p1, p2).toString().equals("2x^2+3x+16"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+x^2-2x-6");
        p1.monomyalSplit();
        p2.setPolynom("x-7");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: x^3+x^2-3x+1",
                op.subtractPolynoms(p1, p2).toString().equals("x^3+x^2-3x+1"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+12x+9");
        p1.monomyalSplit();
        p2.setPolynom("0");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: x^2+12x+9",
                op.subtractPolynoms(p1, p2).toString().equals("x^2+12x+9"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("9");
        p1.monomyalSplit();
        p2.setPolynom("-4");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 13",
                op.subtractPolynoms(p1, p2).toString().equals("13"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^12-2x^8+4x^5-9x^2+12x-4");
        p1.monomyalSplit();
        p2.setPolynom("x^3-x^2-x+1");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: x^12-2x^8+4x^5-x^3-8x^2+13x-5",
                op.subtractPolynoms(p1, p2).toString().equals("x^12-2x^8+4x^5-x^3-8x^2+13x-5"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("-x^2-3x-4");
        p1.monomyalSplit();
        p2.setPolynom("-3x^3-2x^2+1");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 3x^3+x^2-3x-5",
                op.subtractPolynoms(p1, p2).toString().equals("3x^3+x^2-3x-5"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+2x+1");
        p1.monomyalSplit();
        p2.setPolynom("x^2+2x+1");
        p2.monomyalSplit();

        assertTrue("Correct subtraction result: 0",
                op.subtractPolynoms(p1, p2).toString().equals("0"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();
    }

    @Test
    public void multiplicationTests() {
        Operation op = new Operation();
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();

        p1.setPolynom("2x^4-3x^3-15x^2+32x-12");
        p1.monomyalSplit();
        p2.setPolynom("x^2-4x-12");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: 2x^6-11x^5-27x^4+128x^3+40x^2-336x+144",
                op.multiplyPolynoms(p1, p2).toString().equals("2x^6-11x^5-27x^4+128x^3+40x^2-336x+144"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^3+4x^2+x+3");
        p1.monomyalSplit();
        p2.setPolynom("x^2-2x-1");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: 2x^5-9x^3-3x^2-7x-3",
                op.multiplyPolynoms(p1, p2).toString().equals("2x^5-9x^3-3x^2-7x-3"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+4x+5");
        p1.monomyalSplit();
        p2.setPolynom("x^4-2x^3+9x-6");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: x^7-2x^6+4x^5+6x^4-16x^3+21x-30",
                op.multiplyPolynoms(p1, p2).toString().equals("x^7-2x^6+4x^5+6x^4-16x^3+36x^2+21x-30"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^5+7x^2+3x+9");
        p1.monomyalSplit();
        p2.setPolynom("-12x^4+9x^3+7");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: -24x^9+18x^8-84x^6+41x^5-81x^4+81x^3+49x^2+21x+63",
                op.multiplyPolynoms(p1, p2).toString().equals("-24x^9+18x^8-84x^6+41x^5-81x^4+81x^3+49x^2+21x+63"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^2+3x+4");
        p1.monomyalSplit();
        p2.setPolynom("-12");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: -24x^2-36x-48",
                op.multiplyPolynoms(p1, p2).toString().equals("-24x^2-36x-48"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+x^2-2x-6");
        p1.monomyalSplit();
        p2.setPolynom("x-7");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: x^4-6x^3-9x^2+8x+42",
                op.multiplyPolynoms(p1, p2).toString().equals("x^4-6x^3-9x^2+8x+42"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+12x+9");
        p1.monomyalSplit();
        p2.setPolynom("0");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: 0",
                op.multiplyPolynoms(p1, p2).toString().equals("0"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("9");
        p1.monomyalSplit();
        p2.setPolynom("-4");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: -36",
                op.multiplyPolynoms(p1, p2).toString().equals("-36"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^12-2x^8+4x^5-9x^2+12x-4");
        p1.monomyalSplit();
        p2.setPolynom("x^3-x^2-x+1");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: x^15-x^14-x^13+x^12-2x^11+2x^10+2x^9+2x^8-4x^7-4x^6-5x^5+21x^4-6x^3-17x^2+16x-4",
                op.multiplyPolynoms(p1, p2).toString().equals("x^15-x^14-x^13+x^12-2x^11+2x^10+2x^9+2x^8-4x^7-4x^6-5x^5+21x^4-7x^3-17x^2+16x-4"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("-x^2-3x-4");
        p1.monomyalSplit();
        p2.setPolynom("-3x^3-2x^2+1");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: 3x^5+11x^4+18x^3+7x^2-3x-4",
                op.multiplyPolynoms(p1, p2).toString().equals("3x^5+11x^4+18x^3+7x^2-3x-4"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+2x+1");
        p1.monomyalSplit();
        p2.setPolynom("-x^2-2x-1");
        p2.monomyalSplit();

        assertTrue("Correct multiplication result: -x^4-4x^3-6x^2-4x-1",
                op.multiplyPolynoms(p1, p2).toString().equals("-x^4-4x^3-6x^2-4x-1"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();
    }

    @Test
    public void divisionTests() {
        Operation op = new Operation();
        Polynom p1 = new Polynom();
        Polynom p2 = new Polynom();
        Polynom rest = new Polynom();

        p1.setPolynom("2x^4-3x^3-15x^2+32x-12");
        p1.monomyalSplit();
        p2.setPolynom("x^2-4x-12");
        p2.monomyalSplit();

        assertTrue("Correct division result: 2x^2+5x+29 REST: 208x+336",
                op.dividePolynoms(p1, p2, rest).toString().equals("2x^2+5x+29") && rest.toString().equals("208x+336"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^3+4x^2+x+3");
        p1.monomyalSplit();
        p2.setPolynom("x^2-2x-1");
        p2.monomyalSplit();

        assertTrue("Correct division result: 2x+8 REST: 19x+11",
                op.dividePolynoms(p1, p2, rest).toString().equals("2x+8") && rest.toString().equals("19x+11"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+4x+5");
        p1.monomyalSplit();
        p2.setPolynom("x^4-2x^3+9x-6");
        p2.monomyalSplit();

        assertTrue("Correct division result: 0",
                op.dividePolynoms(p1, p2, rest).toString().equals("0"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^5+7x^2+3x+9");
        p1.monomyalSplit();
        p2.setPolynom("x^4+9x^3+7");
        p2.monomyalSplit();

        assertTrue("Correct division result: x-9 REST: 81x^3+7x^2-4x+72",
                op.dividePolynoms(p1, p2, rest).toString().equals("x-9") && rest.toString().equals("81x^3+7x^2-4x+72"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("2x^2+3x+4");
        p1.monomyalSplit();
        p2.setPolynom("x");
        p2.monomyalSplit();

        assertTrue("Correct division result: 2x+3 REST: 4",
                op.dividePolynoms(p1, p2, rest).toString().equals("2x+3") && rest.toString().equals("4"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3+x^2-2x-6");
        p1.monomyalSplit();
        p2.setPolynom("x-7");
        p2.monomyalSplit();

        assertTrue("Correct division result: x^2+8x+54 REST: 372",
                op.dividePolynoms(p1, p2, rest).toString().equals("x^2+8x+54") && rest.toString().equals("372"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+12x+9");
        p1.monomyalSplit();
        p2.setPolynom("1");
        p2.monomyalSplit();

        assertTrue("Correct division result: x^2+12x+9 REST: 0",
                op.dividePolynoms(p1, p2, rest).toString().equals("x^2+12x+9") && rest.toString().equals("0"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+2x+1");
        p1.monomyalSplit();
        p2.setPolynom("x+1");
        p2.monomyalSplit();

        assertTrue("Correct division result: x+1 REST: 0",
                op.dividePolynoms(p1, p2, rest).toString().equals("x+1") && rest.toString().equals("0"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^3-2x^2+1");
        p1.monomyalSplit();
        p2.setPolynom("x^2-3x-4");
        p2.monomyalSplit();

        assertTrue("Correct division result: x+1 REST: 7x+5",
                op.dividePolynoms(p1, p2, rest).toString().equals("x+1") && rest.toString().equals("7x+5"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();

        p1.setPolynom("x^2+2x+1");
        p1.monomyalSplit();
        p2.setPolynom("x^2+2x+1");
        p2.monomyalSplit();

        assertTrue("Correct division result: 1",
                op.dividePolynoms(p1, p2, rest).toString().equals("1"));

        p1.getMonoms().clear();
        p2.getMonoms().clear();
    }

    @Test
    public void derivativeTests() {
        Operation op = new Operation();
        Polynom p1 = new Polynom();

        p1.setPolynom("2x^4-3x^3-15x^2+32x-12");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 8x^3-9x^2-30x+32",
                op.derivative(p1).toString().equals("8x^3-9x^2-30x+32"));

        p1.getMonoms().clear();

        p1.setPolynom("2x^3+4x^2+x+3");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 6x^2+8x+1",
                op.derivative(p1).toString().equals("6x^2+8x+1"));

        p1.getMonoms().clear();

        p1.setPolynom("x^3+4x+5");
        p1.monomyalSplit();

        assertTrue("Correct addition result: 3x^2+4",
                op.derivative(p1).toString().equals("3x^2+4"));

        p1.getMonoms().clear();

        p1.setPolynom("-12x^4+9x^3+7");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: -48x^3+27x^2",
                op.derivative(p1).toString().equals("-48x^3+27x^2"));

        p1.getMonoms().clear();

        p1.setPolynom("2x^2+3x+4");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 2x^2+3x-8",
                op.derivative(p1).toString().equals("4x+3"));

        p1.getMonoms().clear();

        p1.setPolynom("x-7");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 1",
                op.derivative(p1).toString().equals("1"));

        p1.getMonoms().clear();

        p1.setPolynom("x^2+12x+9");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 2x+12",
                op.derivative(p1).toString().equals("2x+12"));

        p1.getMonoms().clear();

        p1.setPolynom("9");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 0",
                op.derivative(p1).toString().equals("0"));

        p1.getMonoms().clear();

        p1.setPolynom("x^12-2x^8+4x^5-9x^2+12x-4");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 12x^11-16x^7+20x^4-18x+12",
                op.derivative(p1).toString().equals("12x^11-16x^7+20x^4-18x+12"));

        p1.getMonoms().clear();

        p1.setPolynom("-3x^3-2x^2+1");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: -9x^2-4x",
                op.derivative(p1).toString().equals("-9x^2-4x"));

        p1.getMonoms().clear();

        p1.setPolynom("x^2+2x+1");
        p1.monomyalSplit();

        assertTrue("Correct derivative result: 2x+2",
                op.derivative(p1).toString().equals("2x+2"));

        p1.getMonoms().clear();
    }

    @Test
    public void integrationTests() {
        Operation op = new Operation();
        Polynom p1 = new Polynom();

        p1.setPolynom("2x^4-3x^3-15x^2+32x-12");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 2/5x^5-3/4x^4-15/3x^3+32/2x^2-12x",
                op.integration(p1).equals("2/5x^5-3/4x^4-15/3x^3+32/2x^2-12x"));

        p1.getMonoms().clear();

        p1.setPolynom("2x^3+4x^2+x+3");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 2/4x^4+4/3x^3+1/2x^2+3x",
                op.integration(p1).equals("2/4x^4+4/3x^3+1/2x^2+3x"));

        p1.getMonoms().clear();

        p1.setPolynom("x^3+4x+5");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 1/4x^4+4/2x^2+5x",
                op.integration(p1).equals("1/4x^4+4/2x^2+5x"));

        p1.getMonoms().clear();

        p1.setPolynom("-12x^4+9x^3+7");
        p1.monomyalSplit();

        assertTrue("Correct integration result: -12/5x^5+9/4x^4+7x",
                op.integration(p1).equals("-12/5x^5+9/4x^4+7x"));

        p1.getMonoms().clear();

        p1.setPolynom("2x^2+3x+4");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 2x^2+3x-8",
                op.integration(p1).equals("2/3x^3+3/2x^2+4x"));

        p1.getMonoms().clear();

        p1.setPolynom("x-7");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 1/2x^2-7x",
                op.integration(p1).equals("1/2x^2-7x"));

        p1.getMonoms().clear();

        p1.setPolynom("x^2+12x+9");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 1/3x^3+12/2x^2+9x",
                op.integration(p1).equals("1/3x^3+12/2x^2+9x"));

        p1.getMonoms().clear();

        p1.setPolynom("9");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 9x",
                op.integration(p1).equals("9x"));

        p1.getMonoms().clear();

        p1.setPolynom("x^12-2x^8+4x^5-9x^2+12x-4");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 1/13x^13-2/9x^9+4/6x^6-9/3x^3+12/2x^2-4x",
                op.integration(p1).equals("1/13x^13-2/9x^9+4/6x^6-9/3x^3+12/2x^2-4x"));

        p1.getMonoms().clear();

        p1.setPolynom("-3x^3-2x^2+1");
        p1.monomyalSplit();

        assertTrue("Correct integration result: -3/4x^4-2/3x^3+x",
                op.integration(p1).equals("-3/4x^4-2/3x^3+x"));

        p1.getMonoms().clear();

        p1.setPolynom("0");
        p1.monomyalSplit();

        assertTrue("Correct integration result: 0",
                op.integration(p1).equals("0"));

        p1.getMonoms().clear();
    }
}
