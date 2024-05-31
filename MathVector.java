/**
 * This class represents a simple row or column vector of numbers.
 * In a row vector, the numbers are written horizontally (i.e., along the columns).
 * In a column vector, the numbers are written vertically (i.e., along the rows).
 * 
 * @author Sarthak Goyal 
 * @version January 9, 2019
 */
public class MathVector {

	// 2D array to hold the numbers of the vector, either along the columns or rows
	private double[][] data;      
	// set to true for a row vector and false for a column vector
	private boolean isRowVector;
	// count of elements in the vector
	private int vectorSize;
	
	/**
	 * Creates a new row or column vector.
	 * For a row vector, the input array is expected to have 1 row and a positive number of columns,     
	 * and this number of columns represents the vector's length.
	 * For a column vector, the input array is expected to have 1 column and a positive number of rows,
	 * and this number of rows represents the vector's length.
	 * 
	 * @param data - a 2D array to hold the numbers of the vector
	 * @throws IllegalArgumentException if the numbers of rows and columns in the input 2D array is not 
	 *         compatible with a row or column vector
	 */
	public MathVector(double[][] data) {
		if(data.length == 0)
			throw new IllegalArgumentException("Number of rows must be positive.");              //checks to see if the number of rows are not 0
		if(data[0].length == 0)                                                                  
			throw new IllegalArgumentException("Number of columns must be positive.");           //checks to see if the number of columns are not 0
		
		if(data.length == 1) {
			// This is a row vector with length = number of columns.
			this.isRowVector = true;
			this.vectorSize = data[0].length;
		}
		else if(data[0].length == 1) {
			// This is a column vector with length = number of rows.
			this.isRowVector = false;
			this.vectorSize = data.length;
		}
		else
			throw new IllegalArgumentException("Either the number of rows or the number of columns must be 1.");
		
		// Create the array and copy data over.
		if(this.isRowVector)
			this.data = new double[1][vectorSize];
		else
			this.data = new double[vectorSize][1];
		for(int i=0; i < this.data.length; i++) { 
			for(int j=0; j < this.data[0].length; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}
	
	/**
	 * Determines whether this vector is "equal to" another vector, where equality is
	 * defined as both vectors being row (or both being column), having the same 
	 * vector length, and containing the same numbers in the same positions.
	 * 
	 * @param other - another vector to compare
	 */
	public boolean equals(Object other) {
		if(!(other instanceof MathVector))
			return false;
		Boolean isEqual = false;
		
		MathVector otherVec = (MathVector)other;
		
			if(this.isRowVector && otherVec.isRowVector)                                 //checking to see if both are row vectors.
			{
				for(int i = 0; i < this.vectorSize; i++)
				{
					if(data[0][i] == otherVec.data[0][i])                                //If both items are equal to one another for the both the arrays it only then proceeds.
					{
						isEqual = true;
					}
					else
					{
						return false;
					}
				}
			}
			else if(!this.isRowVector && !otherVec.isRowVector)
			{
				for(int i = 0; i < this.vectorSize; i++)
				{
					if(data[i][0] == otherVec.data[i][0])
					{
						isEqual = true;
					}
					else
					{
						return false;
					}
				}
			}
			return isEqual;
	}
	
	/**
	 * Generates and returns a new vector that is the transposed version of this vector.
	 */
	public MathVector transpose() {
		MathVector arr2 = null;
		
		if (this.isRowVector)												//checking to see if is row vectors.
		{
			arr2 = new MathVector(new double[this.vectorSize][1]);
			
			for(int i = 0; i < this.vectorSize ;i++)
			{
				arr2.data[i][0] = this.data[0][i];						    //Switches the element locations from row to column
			}
		}
		
		if (!this.isRowVector)
		{
			arr2 = new MathVector(new double[1][this.vectorSize]);
			
			for(int i = 0; i < this.vectorSize ;i++)
			{
				arr2.data[0][i] = this.data[i][0];							//Switches the element locations from column to row
			}
		}
		MathVector object = new MathVector(arr2.data);                     //creates a new object of type class
		return object;                 
	}
	
	/**
	 * Generates and returns a new vector representing the sum of this vector and another vector.
	 * 
	 * @param other - another vector to be added to this vector
	 * @throws IllegalArgumentException if the other vector and this vector are not both row vectors of
	 *         the same length or column vectors of the same length
	 */
	public MathVector add(MathVector other) {
		MathVector sumVector = null;
		
		if((this.isRowVector && !other.isRowVector) || (!this.isRowVector && other.isRowVector))
		{
			throw new IllegalArgumentException("must be row-row or column-column");              
		}
		
		if(this.data.length != other.data.length)
		{
			throw new IllegalArgumentException("must be equal");              
		}
		
		if(this.isRowVector && other.isRowVector)																//checking to see if both are row vectors.
		{
			sumVector = new MathVector(new double[1][this.vectorSize]);
			
			for(int i = 0; i < this.vectorSize; i++)
			{
				sumVector.data[0][i] = this.data[0][i] + other.data[0][i];										//The new Vector sumVector stores the sum of the other 2 vectors.
			}
		}
		
		if (!this.isRowVector && !other.isRowVector)
		{
			sumVector = new MathVector(new double[this.vectorSize][1]);
			
			for(int i = 0; i < this.vectorSize ;i++)
			{
				sumVector.data[i][0] = this.data[i][0] + other.data[i][0];
			}
		}
		MathVector object2 = new MathVector(sumVector.data);                     //creates a new object of type class
		return object2;
	}
	
	/**
	 * Computes and returns the dot product of this vector and another vector.
	 * 
	 * @param other - another vector to be combined with this vector to produce the dot product
	 * @throws IllegalArgumentException if the other vector and this vector are not both row vectors of
	 *         the same length or column vectors of the same length
	 */	
	public double dotProduct(MathVector other) {
		double product = 0; 
		
		if((this.isRowVector && !other.isRowVector) || (!this.isRowVector && other.isRowVector))
		{
			throw new IllegalArgumentException("must be row-row or column-column");              
		}
		
		if(this.data.length != other.data.length)
		{
			throw new IllegalArgumentException("must be equal");              
		}
		
		if(this.isRowVector && other.isRowVector)															//checking to see if both are row vectors.
		{     
	        for (int i = 0; i < this.vectorSize; i++) 
	        {
	            product = product + this.data[0][i] * other.data[0][i]; 									//Multiplies to get the dot product
	        }
		}
		
		if (!this.isRowVector)
		{
			 for (int i = 0; i < this.vectorSize; i++) 
		        {
		            product = product + this.data[i][0] * other.data[i][0]; 
		        }
		}
        
		return product;
	}
	
	/**
	 * Computes and returns this vector's magnitude (also known as a vector's length) .
	 */
	public double magnitude() {
		double magnitudeSquare = 0;
		double magnitudeRoot = 0;
		
		if(isRowVector) 																		//checking to see if it is row vectors.
		{
			for(int i = 0; i < this.vectorSize; i++)
			{
				magnitudeSquare = magnitudeSquare + (this.data[0][i] * this.data[0][i]);       //Finds the magnitude by squaring all numbers then taking their root
			}
			magnitudeRoot = Math.sqrt(magnitudeSquare);
		}
		
		else
		{
			for(int i = 0; i < this.vectorSize; i++)
			{
				magnitudeSquare = magnitudeSquare + (this.data[i][0] * this.data[i][0]);
			}
			magnitudeRoot = Math.sqrt(magnitudeSquare);
		}
		
		return magnitudeRoot;
	}
	
	/** 
	 * Generates and returns a normalized version of this vector.
	 */
	public MathVector normalize() {
		MathVector normalizeVector = null;
		double mag = magnitude();
		
		if(this.isRowVector)															//checking to see if it is row vector.
		{
			normalizeVector = new MathVector(new double[1][this.vectorSize]);
			
			for(int i = 0; i < this.vectorSize; i++)
			{
				normalizeVector.data[0][i] = this.data[0][i] / mag;						//Divides each element of the vector with magnitude to get normalized vector new
			}
		}
		
		else
		{
			normalizeVector = new MathVector(new double[this.vectorSize][1]);
			
			for(int i = 0; i < this.vectorSize ;i++)
			{
				normalizeVector.data[i][0] = this.data[i][0] / mag;
			}
		}
		
			MathVector objectnormalize = new MathVector(normalizeVector.data);                     //creates a new object of type class
			return objectnormalize; 
	}
	
	/**
	 * Generates and returns a textual representation of this vector.
	 * For example, "1.0 2.0 3.0 4.0 5.0" for a sample row vector of length 5 and 
	 * "1.0
	 *  2.0
	 *  3.0
	 *  4.0
	 *  5.0" for a sample column vector of length 5. 
	 *  In both cases, notice the lack of a newline or space after the last number.
	 */
	public String toString() {
		String matrix = "";
		
	if(this.isRowVector)														//checks to see if it is a row vector.
	{
		for(int i=0; i < this.data.length; i++) { 
			for(int j=0; j < this.data[0].length; j++) {
				matrix+= this.data[i][j];
			
				if(j == this.data[0].length - 1)							    //As soon as it encounters the last element it returns the string and does not go to the code to add another space
				{
					return matrix;
				}
				else
				{
					matrix+= " ";
				}
			}
		}
	}
	else
	{
		for(int i=0; i < this.data.length; i++) { 
			for(int j=0; j < this.data[0].length; j++) {
				matrix+= this.data[i][j];
			
				if(i == this.data.length - 1)													//As soon as it encounters the last element it returns the string and does not go to the code to add another line
				{
					return matrix;
				}
				else
				{
					matrix+= '\n';
				}
			}
		}
	}
	return matrix;
}
	
}