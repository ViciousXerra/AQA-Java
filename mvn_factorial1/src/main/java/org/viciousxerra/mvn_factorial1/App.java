package org.viciousxerra.mvn_factorial1;

public class App {
    private App() {
    	
    }
    
    public static long factorial(int n) throws IllegalArgumentException {
    	if(n <= 0)
    		throw new IllegalArgumentException();
    	
    	long[] memo = new long[n];
    	memo[0] = 1;
    	
    	for(int i = 2; i <= n; i++) {
    		memo[i - 1] = i * memo[i - 2];
    	}
    	
    	return memo[n - 1];
    }
	
}
