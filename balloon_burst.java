// Java program to illustrate 
// Burst balloon problem 
import java.util.Arrays; 

class GFG{ 

public static int getMax(int[] A, int N) 
{ 
	
	// Add Bordering Balloons 
	int[] B = new int[N + 2]; 
	B[0] = B[N + 1] = 1; 
		
	for(int i = 1; i <= N; i++) 
		B[i] = A[i - 1]; 
	
	// Declaring DP array 
	int[][] dp = new int[N + 2][N + 2]; 
	
	for(int length = 1; 
			length < N + 1; length++) 
	{ 
		for(int left = 1; 
				left < N - length + 2; left++) 
		{ 
			int right = left + length -1; 
			
			// For a sub-array from indices 
			// left, right. This innermost 
			// loop finds the last balloon burst 
			for(int last = left; 
					last < right + 1; last++) 
			{ 
				dp[left][right] = Math.max( 
								dp[left][right], 
								dp[left][last - 1] + 
								B[left - 1] * B[last] * 
								B[right + 1] + 
								dp[last + 1][right]); 
			} 
		} 
	} 
	return dp[1][N]; 
} 

// Driver code 
public static void main(String args[]) 
{ 
	int[] A = { 1, 2, 3, 4, 5 }; 
	
	// Size of the array 
	int N = A.length; 
	
	// Calling funtion 
	System.out.println(getMax(A, N)); 
} 
} 

// This code is contributed by dadi madhav 
