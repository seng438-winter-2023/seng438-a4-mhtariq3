/**
 * 
 */
package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest {

	// CalculateRowTotal
	
	// This is a test case for what happens when the input Value2D array is null.
	@Test
	public void calculateRowTotalForTwoValues0() {
	    // setup
		boolean thrown = false;
	    final Values2D values = null;
	    
	    try {
	    	double result = DataUtilities.calculateRowTotal(values, 0);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    // verify
	    assertTrue(thrown);
	}
	
	// This is a test case where the row index is positive and the resulting value is positive.
	// It is also a boundary test (of index 0). The inputs are both positive.
	@Test
	public void calculateRowTotalForTwoValues1() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(result, 10.0, .000000001d);
	}
	
	// This is a test case where the row index is negative and the resulting value is negative.
	// It is also a boundary test (of index -1). The input is mixed.
	@Test
	public void calculateRowTotalForTwoValues2() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(-1, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(-1, 1);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, -1);
	    // verify
	    assertEquals(result, -5.0, .000000001d);
	}
	 
	// This is a test case where the row index is negative and the resulting value is positive.
	// This is at the negative index boundary equivalence range. The input is mixed.
	@Test
	public void calculateRowTotalForTwoValues3() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(-2, 0);
	            will(returnValue(7.5));
	            one(values).getValue(-2, 1);
	            will(returnValue(-2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, -2);
	    // verify
	    assertEquals(result, 5.0, .000000001d);
	}
	
	// This is a test case where the row index is positive and the resulting value is negative.
	// This is also a boundary test (of index 1). The inputs are negative.
	@Test
	public void calculateRowTotalForTwoValues4() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(1, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(1, 1);
	            will(returnValue(-2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 1);
	    // verify
	    assertEquals(result, -10.0, .000000001d);
	}
	
	//Calculate Column Total
	
	// This is a test case for what happens when the input Value2D array is null.
	@Test
	public void calculateColumnTotalForTwoValues0() {
	    // setup
		boolean thrown = false;
	    final Values2D values = null;
	    
	    try {
	    	double result = DataUtilities.calculateColumnTotal(values, 0);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    // verify
	    assertTrue(thrown);
	}
	
	@Test
	public void calculateColumnTotalForTwoValues0M() {
	    // setup
		String testMsg = "";
		boolean thrown = false;
	    final Values2D values = null;
	    
	    try {
	    	double result = DataUtilities.calculateColumnTotal(values, 0);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    	testMsg = e.getMessage();
	    }
	    // verify
	    assertEquals("Null 'data' argument.", testMsg);
	}
	
	@Test
	public void calculateRowTotalForTwoValues0M() {
	    // setup
		String testMsg = "";
		boolean thrown = false;
	    final Values2D values = null;
	    
	    try {
	    	double result = DataUtilities.calculateRowTotal(values, 0);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    	testMsg = e.getMessage();
	    }
	    // verify
	    assertEquals("Null 'data' argument.", testMsg);
	}
	
	@Test
	public void calculateColumnTotalForTwoValues0M1() {
	    // setup
		String testMsg = "";
		boolean thrown = false;
	    final Values2D values = null;
	    
	    try {
	    	double result = DataUtilities.calculateColumnTotal(values, 0, new int[]{0});
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    	testMsg = e.getMessage();
	    }
	    // verify
	    assertEquals("Null 'data' argument.", testMsg);
	}
	
	@Test
	public void calculateRowTotalForTwoValues0M2() {
	    // setup
		String testMsg = "";
		boolean thrown = false;
	    final Values2D values = null;
	    
	    try {
	    	double result = DataUtilities.calculateRowTotal(values, 0, new int[]{0});
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    	testMsg = e.getMessage();
	    }
	    // verify
	    assertEquals("Null 'data' argument.", testMsg);
	}
	
	// This is a test case where the column index is positive and the resulting value is positive.
	// It is also a boundary test (of index 0). The inputs are both positive.
	@Test
	public void calculateColumnTotalForTwoValues1() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 10.0, .000000001d);
	}
	
	// This is a test case where the column index is negative and the resulting value is negative.
	// It is also a boundary test (of index -1). The input is mixed.
	@Test
	public void calculateColumnTotalForTwoValues2() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, -1);
	            will(returnValue(-7.5));
	            one(values).getValue(1, -1);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, -1);
	    // verify
	    assertEquals(result, -5.0, .000000001d);
	}
	
	// This is a test case where the column index is negative and the resulting value is positive.
	// This is at the negative index boundary equivalence range. The input is mixed.
	@Test
	public void calculateColumnTotalForTwoValues3() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, -2);
	            will(returnValue(7.5));
	            one(values).getValue(1, -2);
	            will(returnValue(-2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, -2);
	    // verify
	    assertEquals(result, 5.0, .000000001d);
	}
	
	// This is a test case where the column index is positive and the resulting value is negative.
	// This is also a boundary test (of index 1). The inputs are negative.
	@Test
	public void calculateColumnTotalForTwoValues4() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 1);
	            will(returnValue(-7.5));
	            one(values).getValue(1, 1);
	            will(returnValue(-2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    // verify
	    assertEquals(result, -10.0, .000000001d);
	}
	
	//GetCumulativePercentages
	
	// This is a test case for what happens when the input KeyedValues array is null.
	@Test
	public void getCumulativePercentages0() {
	    // setup
		boolean thrown = false;
	    final KeyedValues values = null;
	    
	    try {
	    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    // verify
	    assertTrue(thrown);
	}
	
	// This is a test case for calculating the cumulative percentage for 3 positive values and the result of the accumulated key-value array is sought.
	// accumulated percentage is sought.
	@Test
	public void getCumulativePercentages1() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getItemCount();
	            will(returnValue(3));
	            allowing(values).getValue(0);
	            will(returnValue(5));
	            allowing(values).getValue(1);
	            will(returnValue(9));
	            allowing(values).getValue(2);
	            will(returnValue(2));
	            allowing(values).getKey(0);
	            will(returnValue(0));
	            allowing(values).getKey(1);
	            will(returnValue(1));
	            allowing(values).getKey(2);
	            will(returnValue(2));
	        }
	    });
	    
	    //System.out.println(values.getKeys());
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    
	    DefaultKeyedValues expectedVals = new DefaultKeyedValues();
	    
	    expectedVals.addValue(new Integer(0),(double)5/16);
	    expectedVals.addValue(new Integer(1),(double)(9+5)/16);
	    expectedVals.addValue(new Integer(2),(double)(9+5+2)/16);
	    
	    // verify
	    assertEquals(result, expectedVals);
	}
	
	// This is a test case for calculating the cumulative percentage for 3 negative values and the result of the accumulated key-value array is sought.
	@Test
	public void getCumulativePercentages2() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getItemCount();
	            will(returnValue(3));
	            allowing(values).getValue(0);
	            will(returnValue(-5));
	            allowing(values).getValue(1);
	            will(returnValue(-9));
	            allowing(values).getValue(2);
	            will(returnValue(-2));
	            allowing(values).getKey(0);
	            will(returnValue(0));
	            allowing(values).getKey(1);
	            will(returnValue(1));
	            allowing(values).getKey(2);
	            will(returnValue(2));
	        }
	    });
	    
	    //System.out.println(values.getKeys());
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    
	    DefaultKeyedValues expectedVals = new DefaultKeyedValues();
	    
	    expectedVals.addValue(new Integer(0),(double)-5/-16);
	    expectedVals.addValue(new Integer(1),(double)(-9-5)/-16);
	    expectedVals.addValue(new Integer(2),(double)(-9-5-2)/-16);
	    
	    // verify
	    assertEquals(result, expectedVals);
	}
	
	// This is a test case for calculating the cumulative percentage for 2 positive values and 1 negative value, the result of the accumulated key-value array is sought.
	@Test
	public void getCumulativePercentages3() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getItemCount();
	            will(returnValue(3));
	            allowing(values).getValue(0);
	            will(returnValue(5));
	            allowing(values).getValue(1);
	            will(returnValue(9));
	            allowing(values).getValue(2);
	            will(returnValue(-2));
	            allowing(values).getKey(0);
	            will(returnValue(0));
	            allowing(values).getKey(1);
	            will(returnValue(1));
	            allowing(values).getKey(2);
	            will(returnValue(2));
	        }
	    });
	    
	    //System.out.println(values.getKeys());
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    
	    DefaultKeyedValues expectedVals = new DefaultKeyedValues();
	    
	    expectedVals.addValue(new Integer(0),(double)5/12);
	    expectedVals.addValue(new Integer(1),(double)(9+5)/12);
	    expectedVals.addValue(new Integer(2),(double)(9+5-2)/12);
	    
	    // verify
	    assertEquals(result, expectedVals);
	}
//	}
	
	//Equal
	
	@Test
	public void equalIfAIsNull() {
		//setup
		double[][] x = null;
		double[][] y = new double[5][5];
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = false;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}
	
	@Test
	public void equalIfBIsNull() {
		//setup
		double[][] x = new double[5][5];
		double[][] y = null;
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = false;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}
	
	@Test
	public void equalIfBothNull() {
		//setup
		double[][] x = null;
		double[][] y = null;
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = true;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}

	@Test
	public void equalIfDimensionsDiffer() {
		//setup
		double[][] x = new double[4][5];
		double[][] y = new double[5][5];
		
		System.out.println(x.length);
		System.out.println(y.length);
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = false;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}
	
	@Test
	public void equalIfDimensionsDiffer1() {
		//setup
		double[][] x = new double[5][5];
		double[][] y = new double[5][5];
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = true;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}
	
	@Test
	public void equalIfValuesDiffer() {
		//setup
		double[][] x = { {1, 2, 3}, {4, 5, 6} };
		double[][] y = { {1, 2, 2}, {4, 5, 6} };
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = false;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}
	
	@Test
	public void equalIfValuesMatch() {
		//setup
		double[][] x = { {1, 2, 3}, {4, 5, 6} };
		double[][] y = { {1, 2, 3}, {4, 5, 6} };
		
		boolean methodAnswer = DataUtilities.equal(x, y);
		boolean expectedAnswer = true;
		
		//verify
		assertEquals(expectedAnswer, methodAnswer);
	}
	
	// clone
	
	@Test
	public void cloneIfSourceNull() {
		//setup
		double[][] source = null;
		boolean thrown = false;
		
	    try {
	    	double[][] methodAnswer = DataUtilities.clone(source);
	    } catch (IllegalArgumentException e) {
	    	thrown = true;
	    }
	    // verify
	    assertTrue(thrown);
	}
	
	@Test
	public void cloneNormalArray() {
		//setup
		double[][] source = { {1, 2, 3}, {4, 5, 6} };
		
	    double[][] methodAnswer = DataUtilities.clone(source);
	    double[][] expectedAnswer = { {1, 2, 3}, {4, 5, 6} };
	    
	    // verify
	    assertEquals(expectedAnswer, methodAnswer);
	}
	
	// calculateColumnTotal
	
	@Test
	public void calculateColumnTotalWithValidRow() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    int[] validRows = new int[]{0};
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
	    
	    // verify
	    assertEquals(result, 7.5, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalWithInValidRow() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    int[] validRows = new int[]{3};
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
	    
	    // verify
	    assertEquals(result, 0, .000000001d);
	}
	
	//calculateRowTotal
	
	@Test
	public void calculateRowTotalWithValidCol() {
		// setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    int[] validCols = new int[]{0};
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 0, validCols);
	    // verify
	    assertEquals(result, 7.5, .000000001d);
	}
	
	@Test
	public void calculateRowTotalWithInValidCol() {
		// setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    int[] validCols = new int[]{3};
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 0, validCols);
	    // verify
	    assertEquals(result, 0, .000000001d);
	}
	
	@Test
	public void calculateRowTotalWithNegativeColCount() {
		// setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    int[] validCols = new int[]{3};
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(-1));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 0, validCols);
	    // verify
	    assertEquals(result, 0, .000000001d);
	}
	
	// createNumberArray
	
	@Test
	public void emptyArrayForCreateNumberArray() {
		// test first equivalence class from test strategy
		double[] inputArray = {};
		Number[] actualArrayOne = DataUtilities.createNumberArray(inputArray);
		assertEquals("This array should be empty.", 0, actualArrayOne.length);
	}
	
	@Test
	public void nullArrayForCreateNumberArray() {
		// test second equivalence class from test strategy
		try {
			DataUtilities.createNumberArray(null);
		}
		catch(Exception e) {
			assertEquals("Null should throw an InvalidParameterException", IllegalArgumentException.class, e.getClass());
		}
	}
	
	@Test
	public void arrayInputsCreateNumberArray() {
		// test third equivalence class from test strategy
		double [] data = {3.0,2.0};
		Number [] result = DataUtilities.createNumberArray(data);
		assertEquals("Element 0 should be ", 3.0, result[0]);
		assertEquals("Element 1 should be ", 2.0, result[1]);
	}
	
	// createNumberArray2D
	
	@Test
	public void emptyArrayForCreateNumberArray2D() {
		// test first equivalence class from test strategy
		double [][] inputArray = {{}};
		Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		assertEquals("Outer array should be empty.", 1, actualArray.length);
		assertEquals("Inner array should be empty.", 0, actualArray[0].length);

	}
	
	@Test
	public void nullArrayForCreateNumberArray2D() {
		// test second equivalence class from test strategy
		try {
			DataUtilities.createNumberArray2D(null);
		}
		catch(Exception e) {
			assertEquals("Null should throw an IllegalArgumentException", IllegalArgumentException.class, e.getClass());
		}
	}
	
	@Test
	public void arrayInputsForCreateNumberArray2D() {
		// test third equivalence class from test strategy
		double [][] data = {{1,2}};
		Number [][] result = DataUtilities.createNumberArray2D(data);
		assertEquals("Element 0 in first array should be 1", 1.0, result[0][0]);
		assertEquals("Element 1 in frist array should be 2 ", 2.0, result[0][1]);
	}
	
	
}
