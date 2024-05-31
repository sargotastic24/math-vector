# math-vector

MathVector Implementation

Overview

I implemented a class that represents a row or column vector, as in mathematics. For example:

- [3.0, 1.0, 2.0] is a simple row vector of three numbers.
- [3.0, 1.0, 2.0]^T is a simple column vector of three numbers.
  
Implementation Details

I created MathVector.java and placed it in a new assign01 package in Eclipse. I wrote the MathVector class from scratch, ensuring that it met all the specifications and requirements. I followed the guidelines to maintain professional and clean code.

Important Notes:

- I did not make any of the variables or methods in the MathVector class static. This class represents a MathVector object, and to execute any methods, I called them on an instance of the MathVector class.


// Creates a row vector with three elements: 3.0, 1.0, 2.0
MathVector rowVec = new MathVector(new double[][]{{3.0, 1.0, 2.0}});


- I did not use Java's Vector class or confuse this with the vector type in C++, as neither are useful for this assignment.
To ensure accuracy in my implementation, I referred to various online tutorials and examples about mathematical vectors. I also reviewed the provided tests for examples of how the operations should work and sought verification from TAs and classmates on Piazza.

Testing

I wrote MathVectorJUnitTester.java to test my implementation. After my MathVector class passed all the provided tests, I added many more JUnit tests to ensure comprehensive coverage. I considered all possible cases and code paths to ensure robustness. A portion of my Assignment 1 score depended on the completeness and reliability of the extended MathVectorJUnitTester I submitted.

