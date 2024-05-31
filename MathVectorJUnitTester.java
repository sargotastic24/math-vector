import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This tester class assesses the correctness of the MathVector class.
 * 
 * IMPORTANT NOTE: The tests provided to get you started rely heavily on a 
 *                 correctly implemented equals method.  Be careful of false
 *                 positives (i.e., tests that pass because your equals method
 *                 incorrectly returns true). 
 * 
 * @author Sarthak Goyal 
 * @version January 9, 2019
 */
class MathVectorJUnitTester {
	
	private MathVector rowVec, rowVecTranspose, unitVec, sumVec, colVec, rowVec3, sumVec2, sumColVec;

	@BeforeEach
	void setUp() throws Exception {
		// Creates a row vector with three elements: 3.0, 1.0, 2.0
		rowVec = new MathVector(new double[][]{{3, 1, 2}});
		
		// Creates a column vector with three elements: 3.0, 1.0, 2.0
		rowVecTranspose = new MathVector(new double[][]{{3}, {1}, {2}});
		
		// Creates a row vector with three elements: 1.0, 1.0, 1.0
		unitVec = new MathVector(new double[][]{{1, 1, 1}});
		
		// Creates a row vector with three elements: 4.0, 2.0, 3.0
		sumVec = new MathVector(new double[][]{{4, 2, 3}});
		
		// Creates a column vector with five elements: -11.0, 2.5, 36.0, -3.14, 7.1
		colVec = new MathVector(new double[][]{{-11}, {2.5}, {36}, {-3.14}, {7.1}});	
						
		rowVec3 = new MathVector(new double[][]{{3, 1, 2}});
		
		sumVec2 = new MathVector(new double[][]{{6, 2, 4}});
		
		sumColVec = new MathVector(new double[][]{{6}, {2}, {4}});
	}

	@AfterEach
	void tearDown() throws Exception {
	}
		
	@Test
	public void smallRowVectorEquality() {
		assertTrue(rowVec.equals(new MathVector(new double[][]{{3, 1, 2}})));
	}
	
	@Test
	public void smallRowVectorInequality() {
		assertFalse(rowVec.equals(unitVec));
	}

	@Test
	public void createVectorFromBadArray() {
	  double arr[][] = {{1, 2}, {3, 4}};
	  assertThrows(IllegalArgumentException.class, () -> { new MathVector(arr); });
	  // NOTE: The code above is an example of a lambda expression. See Lab 1 for more info.
	}
	
	@Test
	public void transposeSmallRowVector() {
		MathVector transposeResult = rowVec.transpose();
		assertTrue(transposeResult.equals(rowVecTranspose));
	}
	
	@Test
	public void addRowAndColVectors() {
	  assertThrows(IllegalArgumentException.class, () -> { rowVec.add(colVec); });
	  // NOTE: The code above is an example of a lambda expression. See Lab 1 for more info.
	}
	
	@Test
	public void addSmallRowVectors() {
		MathVector addResult = rowVec.add(unitVec);
		assertTrue(addResult.equals(sumVec));		
	}

	@Test
	public void dotProductSmallRowVectors() {
		double dotProdResult = rowVec.dotProduct(unitVec);
		assertEquals(dotProdResult, 3.0 * 1.0 + 1.0 * 1.0 + 2.0 * 1.0);		
	}
	
	@Test
	public void smallRowVectorMagnitude() {
		double vecMagnitude = rowVec.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0));		
	}
	
	@Test
	public void smallRowVectorNormalize() {
		MathVector normalVec = rowVec.normalize();
		double magnitude = Math.sqrt(3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0);
		assertTrue(normalVec.equals(new MathVector(new double[][]{{3.0 / magnitude, 1.0 / magnitude, 2.0 / magnitude}})));		
	}
	
	@Test
	public void smallColVectorToString() {
		String resultStr = "-11.0\n2.5\n36.0\n-3.14\n7.1";
		assertEquals(colVec.toString(), resultStr);		
	}	
	
	
	
	
//MY TESTS TO CHECK FOR THE PROGRAMME

	
	
	
	@Test
	public void smallRowVectorEquality2() {
		assertTrue(unitVec.equals(new MathVector(new double[][]{{1, 1, 1}})));
	}
	
	@Test
	public void smallRowVectorEquality3() {
		assertTrue(sumVec.equals(new MathVector(new double[][]{{4, 2, 3}})));
	}
	
	@Test
	public void smallColVectorEquality() {
		assertTrue(colVec.equals(new MathVector(new double[][]{{-11}, {2.5}, {36}, {-3.14}, {7.1}})));
	}
	
	@Test
	public void smallColVectorInequality() {
		assertFalse(colVec.equals(new MathVector(new double[][]{{-1}, {2.5}, {36}, {-3.14}, {7.1}})));
	}
	
	@Test
	public void transposeSmallColumnVector() {
		MathVector transposeResult = rowVecTranspose.transpose();
		assertTrue(transposeResult.equals(rowVec));
	}
	
	@Test
	public void transposeSmallColumnVector2() {
		MathVector transposeResult = rowVecTranspose.transpose();
		assertTrue(transposeResult.equals(rowVec));
	}
	
	@Test
	public void transposeSmallRowVector2() {
		MathVector transposeResult = rowVec.transpose();
		assertTrue(transposeResult.equals(rowVecTranspose));
	}
	
	@Test
	public void addSmallRowVectors2() {
		MathVector addResult = rowVec.add(rowVec3);
		assertTrue(addResult.equals(sumVec2));		
	}
	
	@Test
	public void addColumnRowVectors2() {
		MathVector addResult = rowVecTranspose.add(rowVecTranspose);
		assertTrue(addResult.equals(sumColVec));		
	}
	
	@Test
	public void dotProductSmallColVectors() {
		double dotProdResult = rowVecTranspose.dotProduct(rowVecTranspose);
		assertEquals(dotProdResult, 3.0 * 3.0 + 1.0 * 1.0 + 2.0 * 2.0);		
	}
	
	@Test
	public void smallColVectorMagnitude() {
		double vecMagnitude = sumColVec.magnitude();
		assertEquals(vecMagnitude, Math.sqrt(6.0 * 6.0 + 2.0 * 2.0 + 4.0 * 4.0));		
	}

	@Test
	public void smallColVectorNormalize() {
		MathVector normalVec = sumColVec.normalize();
		double magnitude = Math.sqrt(6.0 * 6.0 + 2.0 * 2.0 + 4.0 * 4.0);
		assertEquals(new MathVector(new double[][]{{6.0 / magnitude}, {2.0 / magnitude}, {4.0 / magnitude}}), normalVec);
	}
	
	@Test
	public void smallRowVectorToString() {
		System.out.println();
		String resultStr = "3.0 1.0 2.0";
		assertEquals(rowVec.toString(), resultStr);		
	}	
}