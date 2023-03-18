package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

public class RangeTest {
	private Range exampleRange;
	private Range defaultRange;
    private Range CombineRange2;
    private Range exampleRange4;
    private Range exampleRange5;
    private Range exampleRange6;
    private Range exampleRange7;
    private Range NaNRange;
    
    private Range toString1;
    private Range toString2;
    private Range toString3;
    private Range toString4;
    private Range exampleRangeintersectsDouble;
    private Range exampleRangeintersectsRange;
    
      
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	defaultRange = new Range(-10, 10);
    	exampleRange = new Range(-1, 1);	
    	CombineRange2 = new Range(1, 2);	
    	exampleRange4 = new Range(-1000000, 2000000);	
    	exampleRange5 = new Range(Double.NaN, 1);
    	exampleRange6 = new Range(-1, Double.NaN);
    	exampleRange7 = new Range(Double.NaN, Double.NaN);
    	NaNRange = new Range(Double.NaN, Double.NaN);
    	
    	//ToString() 
    	toString1 = new Range(-4, 3); 
    	toString2 = new Range(0, 0); 
    	toString3 = new Range(7.0, 21.0); 
    	toString4 = new Range(-23, -3); 
    	
    	exampleRangeintersectsDouble = new Range(1.1, 5.5);
    	exampleRangeintersectsRange = new Range(1.1, 5.5);
    }
    
    @Test
    public void testRangeConsctructorM() {
    	boolean thrown = false;
    	try {
	    	Range result = new Range(10, 5);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
    	
    	assertTrue(thrown);
    }
    
    @Test
    public void testRangeConsctructorM2() {
    	boolean thrown = false;
    	String testMsg = "";
    	try {
	    	Range result = new Range(10, 5);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    	testMsg = e.getMessage();
	    }
    	
    	assertEquals("Range(double, double): require lower (" + 10.0
                + ") <= upper (" + 5.0 + ").",testMsg);
    }
    
    @Test
    public void testPositiveValuesForGetUpperBound() {
    	// test first equivalence class from test strategy
    	Range positiveRange = new Range(1, 5);
    	
    	assertEquals("The upper bound of 1 and 5 should be 5", 5, positiveRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void testNegativeValuesForGetUpperBound() {
    	// test second equivalence class from test strategy
    	Range negativeRange = new Range(-10, -1);
    	
    	assertEquals("The upper bound of -10 and -1 should be -1", -1, negativeRange.getUpperBound(), .000000001d);
    }

    @Test
    public void testNegativeAndPositiveValuesForGetUpperBound() {
    	// test third equivalence class from test strategy
    	assertEquals("The upper bound of -10 and 10 should be 10", 10, defaultRange.getUpperBound(), .000000001d);
    }
    
    @Test	
    public void testUpperZeroValueForGetUpperBound() {
    	// test fourth equivalence class from test strategy
    	Range upperZero = new Range(-1, 0);

    	assertEquals("The upper bound of -1 and 0 should be 0", 0, upperZero.getUpperBound(), .000000001d);
    }
    
    @Test	
    public void testLowerZeroValueForGetUpperBound() {
    	// test fourth equivalence class from test strategy
    	Range lowerZero = new Range(0, 1);

    	assertEquals("The upper bound of 0 and 1 should be 1", 1, lowerZero.getUpperBound(), .000000001d);
    }
    
    @Test
    public void equalBounderiesForGetUpperBound() {
    	// test boundary value analysis - upper and lower boundaries equal
    	Range equalRange = new Range(1,1);
    	
    	assertEquals("The upper bound of 1 and 1 should be 1", 1, equalRange.getUpperBound(), .000000001d);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    
    @Test
    public void NOMValueForConstrain() {
    	// test first equivalence class from test strategy
    	assertEquals("The constrain of -10 and 10 with input 5 should be the input value", 5, defaultRange.constrain(5), .000000001d);
    }
    
    @Test
    public void UBValueForConstrain() {
    	// test boundary value analysis - the value on the upper bound 
    	assertEquals("The constrain of -10 and 10 with input 10 should be the 10", 10, defaultRange.constrain(10), .000000001d);
    }
    
    @Test
    public void AUBValueForConstrain() {
    	// test third equivalence class from test strategy
    	// test boundary value analysis - a value above the upper bound
    	assertEquals("The constrain of -10 and 10 with input 11 should be the 10", 10, defaultRange.constrain(11), .000000001d);
    }
    
    @Test
    public void BUBValueForConstrain() {
    	// test boundary value analysis - a value below the upper bound
    	assertEquals("The constrain of -10 and 10 with input 9 should be the input value", 9, defaultRange.constrain(9), .000000001d);
    }
    
    @Test
    public void ALBValueForConstrain() {
    	// test boundary value analysis - a value above the lower boundary
    	assertEquals("The constrain of -10 and 10 with input -9 should be the input", -9, defaultRange.constrain(-9), .000000001d);
    }
    
    @Test
    public void LBValueForConstrain() {
    	// test boundary value analysis - the value on the lower bound
    	assertEquals("The constrain of -10 and 10 with input -10 should be the input", -10, defaultRange.constrain(-10), .000000001d);
    }
    
    @Test
    public void BLBValueForConstrain() {
    	// test second equivalence class from test strategy
    	// test boundary value analysis - a value below the lower bound
    	assertEquals("The constrain of -10 and 10 with input -11 should be the -10", -10, defaultRange.constrain(-11), .000000001d);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////
  

    @Test
    public void NOMValueForContains() {
    	// test first equivalence class from test strategy
    	assertEquals("For the range -10 and 10 with input 5 should be true", true, defaultRange.contains(5));
    }
    
    @Test
    public void UBValueForContains() {
    	// test boundary value analysis - the value on the upper bound
    	assertEquals("For the range -10 and 10 with input 10 should be false", true, defaultRange.contains(10));
    }
    
    @Test
    public void AUBValueForContains() {
    	// test third equivalence class from test strategy
    	// test boundary value analysis - a value above the upper bound
    	assertEquals("For the range -10 and 10 with input 11 should be false", false, defaultRange.contains(11));
    }
    
    @Test
    public void BUBValueForContains() {
    	// test boundary value analysis - a value below the upper bound
    	assertEquals("For the range -10 and 10 with input 9 should be true", true, defaultRange.contains(9));
    }
    
    @Test
    public void ALBValueForContains() {
    	// test boundary value analysis - a value above the lower bound
    	assertEquals("For the range -10 and 10 with input -9 should be true", true, defaultRange.contains(-9));
    }
    
    @Test
    public void LBValueForContains() {
    	// test boundary value analysis - the value on the lower bound
    	assertEquals("For the range -10 and 10 with input -10 should be false", true, defaultRange.contains(-10));
    }
    
    @Test
    public void BLBValueForContains() {
    	// test third equivalence class from test strategy
    	// test boundary value analysis - a value above the upper bound
    	assertEquals("For the range -10 and 10 with input -11 should be false", false, defaultRange.contains(-11));
    }
    
	//////////////////////////////////////////////////////////////////////////////
	
    private Range exampleOne;
	private Range exampleTwo;
	private Range exampleThree;
	private Range exampleFour;
	private Range exampleFive;
	
	@Test 
	public void toStringOne() { 
		// test first equivalence class from test strategy
		exampleOne = new Range(-10.0, 5.0);
		assertEquals("Range[-10.0,5.0]", exampleOne.toString()); 
	} 
	
	@Test 
	public void toStringTwo() { 
		// test boundary value analysis - upper and lower boundaries equal
		exampleTwo = new Range(0, 0); 
		assertEquals("Range[0.0,0.0]", exampleTwo.toString()); 
	} 
	
	@Test 
	public void toStringThree() { 
		// test third equivalence class from test strategy
		exampleThree = new Range(15.0, 20.0);
		assertEquals("Range[15.0,20.0]", exampleThree.toString()); 
	} 
	
	@Test 
	public void toStringFour() { 
		// test fourth equivalence class from test strategy
		exampleFour = new Range(-20, -15); 
		assertEquals("Range[-20.0,-15.0]", exampleFour.toString()); 
	}
	
	@Test 
	public void toStringFive() { 
		// test fifth equivalence class from test strategy
		exampleFive= new Range(-5, 0);
		assertEquals("Range[-5.0,0.0]", exampleFive.toString()); 
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	private Range exampleOnelo;
	private Range exampleTwolo;
	private Range exampleThreelo;
	private Range exampleFourlo;
	private Range exampleFivelo;
	
	@Test
	public void LowerBoundExampleOne() {
		// test first equivalence class from test strategy
		exampleOnelo = new Range(-10, 10);
		assertEquals(-10.0, exampleOnelo.getLowerBound(), .000000001d);
	}
	
	@Test
	public void LowerBoundExampleTwo() {
		// test second equivalence class from test strategy
		exampleTwolo = new Range(-10, 0);
		assertEquals(-10, exampleTwolo.getLowerBound(), .000000001d);
	}
	
	@Test
	public void LowerBoundExampleThree() {
		// test boundary value analysis - upper and lower boundaries equal
		exampleThreelo = new Range(-10, -10);
		assertEquals(-10.0, exampleThreelo.getLowerBound(), .000000001d);
	}
	
	@Test
	public void LowerBoundExampleFour() {
		// test fourth equivalence class from test strategy
		exampleFourlo = new Range(15, 20);
		assertEquals(15.0, exampleFourlo.getLowerBound(), .000000001d);
	}
	
	@Test
	public void LowerBoundExampleFive() {
		// test fifth equivalence class from test strategy
		exampleFivelo = new Range(0, 0);
		assertEquals(0, exampleFivelo.getLowerBound(), .000000001d);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testThrowErrorForRange() {
		// pick lower > upper to throw an error
		boolean thrown = false;
	    
	    try {
	    	new Range(5, 0);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    assertTrue(thrown);
	}
	
	@Test
	public void testConstructRangeObject() {
		Range rangeObj = new Range(1, 5);
		
		assertNotNull(rangeObj);
	}
	
	//////////////////////////////////////////////////////////////////////////////

	@Test
	public void testGetLength() {
		assertEquals("The length of -10 and 10 should be 20",
		        20, defaultRange.getLength(), .000000001d);
	}

	//////////////////////////////////////////////////////////////////////////////

	@Test
	public void testFirstRangeNullForCombineIgnoringNan() {
		assertTrue("If range 1 is null then range 2 is returned",
				defaultRange.equals(Range.combineIgnoringNaN(null,defaultRange)));
	}
	
	@Test
	public void testBothRangeNullForCombineIgnoringNan() {
		assertNull("If range 1 is null and range 2 null then null is returned",
				Range.combineIgnoringNaN(null,null));
	}
	
	@Test
	public void testSecondRangeNullForCombineIgnoringNan() {
		assertTrue("If range 2 is null then range 1 is returned",
				defaultRange.equals(Range.combineIgnoringNaN(defaultRange,null)));
	}
	
	@Test
	public void testFirstRangeNaNSecondNullForCombineIgnoringNan() {
    	assertNull("If range 1 is NaN and range 2 null then null is returned",
		Range.combineIgnoringNaN(NaNRange,null));
    }
	
	@Test
    public void testFirstRangeNullSecondRangeNaNForCombineIgnoringNan() {
    	assertNull("If range 1 is null and range 2 NaN then null is returned",
		Range.combineIgnoringNaN(null,NaNRange));
    }
	
	@Test
	public void testBothRangeNaNForCombineIgnoringNan() {
		assertNull("If range 1 is NaN and range 2 NaN, null returned",
				Range.combineIgnoringNaN(NaNRange,NaNRange));
	}
	
	@Test
	public void testFirstRangeNaNForCombineIgnoringNan() {
		assertTrue("If range 1 is NaN and range 2 valid then range 2 returned",
		    	defaultRange.equals(Range.combineIgnoringNaN(NaNRange,defaultRange)));
	}
	
	@Test
	public void testSecondRangeNaNForCombineIgnoringNan() {
		assertTrue("If range 1 is valid and range 2 NaN then range 1 returned",
				defaultRange.equals(Range.combineIgnoringNaN(defaultRange,NaNRange)));
	}
	
	@Test
	public void testNormalRangeForCombineIgnoringNan() {
		Range combinedRange = new Range(-10,50);
		Range validRange = new Range(-10, 50);
    	assertTrue("Range 1 (-10, 10), Range 2 (-10, 50) then (-10, 50) is returned",
		combinedRange.equals(Range.combineIgnoringNaN(defaultRange, validRange)));
	}
	
	//////////////////////////////////////////////////////////////////////////////

	@Test
	public void testRangeNullForExpand() {
		boolean thrown = false;
	    
	    try {
	    	Range.expand(null, 0, 0);
	    	
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    assertTrue(thrown);
	}
	
//	@Test
//    public void testExpandBothRangesForExpand() {
//    	Range expandedRange = new Range(-15,15);
//    	assertTrue("Expanding the range (-10, 10) by 50% in both direction should get (-15, -15)",
//    	expandedRange.equals(Range.expand(defaultRange,0.5,0.5)));
//    }
//    @Test
//    public void testExpandReverseForExpand() {
//    	Range expandedRange = new Range(-10,10);
//    	assertTrue("Expanding the range (-10, 10) by -100% should get (-10, -10)",
//    	expandedRange.equals(Range.expand(defaultRange ,-1,-1)));
//    }
    
	//////////////////////////////////////////////////////////////////////////////
    
    @Test
    public void testZeroCrossingAllowedForShift() {
    	Range shiftedRange = new Range(5,25);
    	assertTrue("Shifting a positive of 15 with zero crossing enabled should get (5, 25)",
    	shiftedRange.equals(Range.shift(defaultRange, 15, true)));
    }
    
    @Test
    public void testZeroCrossingNotAllowedForShift() {
    	Range shiftedRange = new Range(0,25);
    	assertTrue("Shifting a positive of 15 with no zero crossing enabled should get (5, 25)",
    	shiftedRange.equals(Range.shift(defaultRange, 15, false)));
    }
    
    @Test
    public void testRangeNullForShift() {
    	boolean thrown = false;
	    
	    try {
	    	Range.shift(null, 15, true);
	    	
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    assertTrue(thrown);
    }
    
	//////////////////////////////////////////////////////////////////////////////

    @Test
    public void testRangeNullForScale() {
    	boolean thrown = false;
	    
	    try {
	    	Range.scale(null, 2);
	    	
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    assertTrue(thrown);
    }
    
    @Test
    public void testNegativeFactorForScale() {
    	boolean thrown = false;
	    
	    try {
	    	Range.scale(defaultRange, -2);
	    	
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    assertTrue(thrown);
    }
    
    @Test
    public void testNegativeFactorForScaleM() {
    	boolean thrown = false;
	    
	    try {
	    	Range.scale(defaultRange, -0.5);
	    	
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    assertTrue(thrown);
    }
    
    
    
	@Test
    public void testNegativeFactorForScaleM1() {
    	boolean thrown = false;
    	String testMsg = "";
    	
	    try {
	    	Range.scale(defaultRange, -0.5);
	    	
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    	testMsg = e.getMessage();
	    }
	    assertEquals("Negative 'factor' argument.",testMsg);
    }
	
    @Test
    public void testPositiveFactorForScale() {
    	Range scaledRange = new Range(-20,20);
    	assertTrue("Scaling a range of (-10, 10) by 2 should get a range of (-20, 20)",
    	scaledRange.equals(Range.scale(defaultRange, 2)));
    }
    
    @Test
    public void testPositiveFactorForScaleM() {
    	Range scaledRange = new Range(-5,5);
    	assertTrue(scaledRange.equals(Range.scale(defaultRange, 0.5)));
    }
    
    @Test
    public void mutantEqual() {
    	Range testRange = new Range(-5,5);
    	assertFalse(testRange.equals(new Range(-5,6)));
    }
    
    @Test
    public void mutantEqual2() {
    	Range testRange = new Range(-5,5);
    	assertFalse(testRange.equals(new Range(-5,4)));
    }
    
    @Test
    public void mutantEqual3() {
    	Range testRange = new Range(5,10);
    	assertTrue(testRange.equals(new Range(5,10)));
    }
    
    @Test
    public void mutantEqual4() {
    	Range testRange = new Range(-5,5);
    	assertFalse(testRange.equals(new Range(-6,5)));
    }
    
    @Test
    public void mutantEqual55() {
    	Range testRange = new Range(-5,5);
    	assertFalse(testRange.equals(new Range(-4,5)));
    }
    
	//////////////////////////////////////////////////////////////////////////////

    @Test
    public void testObjectNotRangeForEquals() {
    	double randomNumber = 3;
    	assertFalse("a number should not equal Range object, return false",
		defaultRange.equals(randomNumber));
    }
    
    @Test
    public void testUpperBoundNotEqualForEquals() {
    	Range differentUpperBound = new Range(-20,100);
    	assertFalse("The upper bound (-10, 20) is not equal to the upper bound (-10, 10)",
		defaultRange.equals(differentUpperBound));
	}
    
    @Test
    public void testLowerBoundNotEqualForEquals() {
    	Range differentLowerBound = new Range(-20,10);
    	assertFalse("The lower bound (-20, 10) is not equal to the lower bound (-10, 10)",
		defaultRange.equals(differentLowerBound));
	}
    
	//////////////////////////////////////////////////////////////////////////////

    @Test
    public void testValidRangeHashCode() {
    	assertEquals("test", defaultRange.hashCode(), 7.077888E7, .000000001d);
	}
    
	//////////////////////////////////////////////////////////////////////////////

	////////////LowerBound
	@Test
	public void lowerBoundNegOne() {
		assertEquals(-1, exampleRange.getLowerBound(), .000000001d);
	}
	
	@Test
	public void lowerBoundNotAboveNegOne() {
		assertNotEquals(-0.999999, exampleRange.getLowerBound(), .000000001d);
	}
	
	@Test
	public void lowerBoundNotBelowNegOne() {
		assertNotEquals(-1.000001, exampleRange.getLowerBound(), .000000001d);
	}
	
	@Test
	public void lowerBoundShouldBeNegOne() {
		assertEquals(-1000000, exampleRange4.getLowerBound(), .000000001d);
	}	
	
	////////////////ToString
	@Test 
	public void RangetoString1() { 
		assertEquals("Range[-4.0,3.0]", toString1.toString()); 
	} 
	
	@Test 
	public void RangetoString2() { 
		assertEquals("Range[0.0,0.0]", toString2.toString()); 
	} 
	
	@Test 
	public void RangetoString3() { 
		assertEquals("Range[7.0,21.0]", toString3.toString()); 
	} 
	
	@Test 
	public void RangetoString4() { 
		assertEquals("Range[-23.0,-3.0]", toString4.toString()); 
	}
	
	
	/////////////UpperBound
	@Test
	public void upperBoundOne() {
		assertEquals(1, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void upperBoundNotAboveOne() {
		assertNotEquals(1.000001, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void upperBoundNotBelowOne() {
		assertNotEquals(0.999999, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void upperBoundShouldTwo() {
		assertEquals(2000000, exampleRange4.getUpperBound(), .000000001d);
	}
	
	
	/////////////Intersects(double, double)
	@Test
	public void LowerBoundNotCrossing() {
		assertFalse("The two ranges cross", exampleRangeintersectsDouble.intersects(0.0, 1.0));
	}
	
	
	@Test
	public void UpperBoundNotCrossing() {
		assertFalse("The two ranges cross", exampleRangeintersectsDouble.intersects(11.11, 15.15));
	}
	
	
	@Test
	public void LowerBoundCrossing() {
		assertTrue("The two ranges do not cross", exampleRangeintersectsDouble.intersects(0.0, 2.2));
	}
	
	
	@Test
	public void UpperBoundCrossing() {
		assertTrue("The two ranges do not cross", exampleRangeintersectsDouble.intersects(3.3, 12.12));
	}
	
	@Test
	public void AllRangeCrossing() {
		assertTrue("The two ranges do not cross", exampleRangeintersectsDouble.intersects(1.1, 5.5));
	}
	
	@Test
	public void AllRangeCrossingM() {
		Range testRange = new Range(1.1, 2.0);
		assertTrue("The two ranges do not cross", testRange.intersects(1.0, 5.5));
	}
	
	@Test
	public void AllRangeCrossingM2() {
		Range testRange = new Range(0.5, 1.1);
		assertFalse("The two ranges do not cross", testRange.intersects(1.2, 5.5));
	}
	
	@Test
	public void AllRangeCrossingM3() {
		Range testRange = new Range(1.0, 1.1);
		assertTrue("The two ranges do not cross", testRange.intersects(0.5, 1.5));
	}
	
	@Test
	public void AllRangeCrossingM4() {
		Range testRange = new Range(1, 1.1);
		assertFalse("The two ranges do not cross", testRange.intersects(0.5, 1));
	}
	
	@Test
	public void AllRangeCrossingM5() {
		Range testRange = new Range(0, 0);
		assertTrue("The two ranges do not cross", testRange.intersects(0, 1));
	}
	
	
	@Test
	public void RangeCrossingInBetween() {
		assertTrue("The two ranges do not cross", exampleRangeintersectsDouble.intersects(3.3, 4.4));
	}
	
	///////////////Intersects(Range)
	@Test
	public void lowerBoundNotCrossingTest() {
		Range inputRange = new Range(0.0, 1.0);
		assertFalse("The two ranges cross", exampleRangeintersectsRange.intersects(inputRange));
	}
	
	
	@Test
	public void upperBoundNotCrossingTest() {
		Range inputRange = new Range(11.11, 15.15);
		assertFalse("The two ranges cross", exampleRangeintersectsRange.intersects(inputRange));
	}
	
	
	@Test
	public void lowerBoundCrossingTest() {
		Range inputRange = new Range(0.0, 2.2);
		assertTrue("The two ranges do not cross", exampleRangeintersectsRange.intersects(inputRange));
	}
	
	@Test
	public void upperBoundCrossingTest() {
		Range inputRange = new Range(3.3, 12.12);
		assertTrue("The two ranges do not cross", exampleRangeintersectsRange.intersects(inputRange));
	}
	
	
	@Test
	public void allRangeCrossingTest() {
		Range inputRange = new Range(1.1, 5.5);
		assertTrue("The two ranges do not cross", exampleRangeintersectsRange.intersects(inputRange));
	}
	
	
	@Test
	public void rangeCrossingInBetweenTest() {
		Range inputRange = new Range(3.3, 4.4);
		assertTrue("The two ranges do not cross", exampleRangeintersectsRange.intersects(inputRange));
	}
	
	
	///////////////////isNaNRange
	@Test
	public void IsNaN1() {
		assertFalse("The range of -1 and 1 should should not be NaN", exampleRange.isNaNRange());
	}
	
	@Test
	public void IsNaN2() {
		assertFalse("The range of Double.NaN and 1 should should not be NaN", exampleRange5.isNaNRange());
	}
	
	@Test
	public void IsNaN3() {
		assertFalse("The range of -1 and Double.NaN should should not be NaN", exampleRange6.isNaNRange());
	}
	
	@Test
	public void IsNan4() {
		assertTrue("The range of Double.NaN and Double.NaN should should be NaN", exampleRange7.isNaNRange());
	}
	
	
	////////////////Combine(Range, Range)
	@Test
	public void FirstRangeNull() {
		assertEquals(CombineRange2, Range.combine(null, CombineRange2));
	}
	
	@Test
	public void SecondRangeNull() {
		assertEquals(CombineRange2, Range.combine(CombineRange2, null));
	}
	
	@Test
	public void CombinedRangesIsNeg() {
		assertEquals(-1, Range.combine(exampleRange, CombineRange2).getLowerBound(), .000000001d);
	}
	
	@Test
	public void CombinedRangesIsTwo() {
		assertEquals(2, Range.combine(exampleRange, CombineRange2).getUpperBound(), .000000001d);
	}
	
	/////////////getCentralValue()
	@Test
	public void getCentralValuePos() {
		assertEquals(7.000,  new Range(2, 12).getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void getCentralValueNeg() {
		assertEquals(-7.000, new Range(-12, -2).getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void getCentralValueTwoDiff() {
		assertEquals(4.000, new Range(-2, 10).getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void getCentralValueEqual() {
		assertEquals(1.000, new Range(1, 1).getCentralValue(), .000000001d);
	}
	
	Range expected1 = new Range (-5 , 15);
	Range expected2 = new Range (0 , 25);
	Range expected3 = new Range (15 , 25);
	Range expected4 = new Range (-10 , 20);
	Range expected5 = new Range (-10 , 10);
	Range expected6 = new Range (-20 , 10);
	Range expected7 = new Range (0 , 0);
	
	Range actual1 = new Range(-10, 10);
	Range actual2 = new Range(-10, 10);
	Range actual3 = new Range(0,10);
	Range actual4 = new Range(-10, 10);
	Range actual5 = new Range(-10, 10);
	Range actual6 = new Range(-10, 10);
	Range actual7 = new Range(-10, 10);
	
	/////////////Shift(Range, Double)
	@Test
	public void ShiftSmallDeltaValue() {
		actual1 = Range.shift(actual1, 5); 
		assertEquals(expected1, actual1);
	}
	
	@Test
	public void ShiftLargeDeltaValue() {
		actual2 = Range.shift(actual2, 15);
		assertEquals(expected2, actual2);
	}
	
	
	@Test
	public void ShiftZeroNoZeroCrossing() {
		actual3 = Range.shift(actual3, 15);
		assertEquals(expected3, actual3);
	}
	
	@Test
	public void ShiftZeroNoZeroCrossingM1() {
		Range testRange = new Range(5,10);
		testRange = Range.shift(testRange, -10);
		assertEquals(new Range(0,0), testRange);
	}
	
	@Test
	public void ShiftZeroNoZeroCrossingM2() {
		Range testRange = new Range(0,10);
		testRange = Range.shift(testRange, -5);
		assertEquals(new Range(-5,5), testRange);
	}
	
	@Test
	public void ShiftZeroNoZeroCrossingM3() {
		Range testRange = new Range(0.5,10);
		testRange = Range.shift(testRange, -5);
		assertEquals(new Range(0,5), testRange);
	}
	
	@Test
	public void ShiftZeroNoZeroCrossingM4() {
		Range testRange = new Range(-0.5,10);
		testRange = Range.shift(testRange, 5);
		assertEquals(new Range(0,15), testRange);
	}
	
	
	///////////ExpandToInclude(Range,Double)
	
	@Test
	public void ExpandLargerValue() {
		actual4 = Range.expandToInclude(actual4, 20);
		assertEquals(expected4, actual4);
	}
	
	
	@Test
	public void ExpandMiddleValue() {
		actual5 = Range.expandToInclude(actual5, 0);
		assertEquals(expected5, actual5);
	}
	
	
	@Test
	public void ExpandSmallerValue() {
		actual6 = Range.expandToInclude(actual6, -20);
		assertEquals(expected6, actual6);
	}
	
	
	@Test
	public void ExpandToIncludeNull() { 
		actual7 = Range.expandToInclude(null, 0);
		assertEquals(expected7, actual7);
	}
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
