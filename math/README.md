## math classes

# Matrix

 * public RationalNumber[][] ratMat
		- 2D array if RationalNumber

 * public Matrix(RationalNumber[][] ratMat)
		- Constructs Matrix
		
 * public Matrix plus(Matrix mat)
 * public static RationalNumber[][] add(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)
		- Matrix addition of order m x n

 * public Matrix minus(Matrix mat)
 * public static RationalNumber[][] subtract(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)
		- Matrix difference of order m x n
		
 * public Matrix multiply(Matrix mat)
 * public static RationalNumber[][] multiply(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)
		-matrix multiplication of order m x n and n x p

 * public Matrix devide(Matrix mat)
 * public static RationalNumber[][] devide(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)
		- Matrix division of square matrix of order n

 * public Matrix inverse()
 * public static RationalNumber[][] inverse(RationalNumber[][] ratMat)
		- Matrix inverse of matrix of order n

 * public RationalNumber determinent()
 * public static RationalNumber determinent(RationalNumber[][] ratMat)
		- Determinent of matrix of order n

# RationalNumber

 * public int NUM 
		- numerator
 * public int DENOM
		- denominator
		
## Constructors
 * public RationalNumber(int a,int b)
		- RationalNumber that represents a/b
 * public RationalNumber(int a)
		- RationalNumber that represents a/1
 * public RationalNumber(string str)
		- constructs RationalNumber that represents a/b
		- eg new RationalNumber("5/6);

## public Methods
 * public RationalNumber plus(RationalNumber ri)
		- adds another rational number and returns the sum
 * public RationalNumber minus(RationalNumber ri)
		- subtracts another rational number and returns the difference
 * public RationalNumber multiply(RationalNumber ri)
		- multiply the two rational number and returns the result
 * public RationalNumber div(RationalNumber ri)
		- devide given RationalNumber by by ri and return result
		
 * public string toString()
 * public int intValue()
 * public long longValue()
 * public float floatValue()
 * public double doubleValue()



