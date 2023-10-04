package org.viciousxerra.mvn_factorial;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
	
    @Test
    @DisplayName("Factorial method test")
    void testFactorialMethod() {
    	System.out.println("Testing...");
    	//Arrange
    	int[] legalArgs = {1, 5, 9, 13};
    	int[] illegalArgs = {0, -1, -5};
    	//Act & Assert legal args
    	System.out.println("Passing legal arguments...");
    	assertAll("Legal arguments",
    			 () -> assertEquals(1L, App.factorial(legalArgs[0])),
    			 () -> assertEquals(120L, App.factorial(legalArgs[1])),
    			 () -> assertEquals(362880L, App.factorial(legalArgs[2])),
    			 () -> assertEquals(6227020800L, App.factorial(legalArgs[3]))
    			 );
    	//Act & Assert illegal args
    	System.out.println("Passing illegal arguments...");
    	assertAll("Illegal arguments",
    			() -> assertThrows(IllegalArgumentException.class, () -> App.factorial(illegalArgs[0])),
    			() -> assertThrows(IllegalArgumentException.class, () -> App.factorial(illegalArgs[1])),
    			() -> assertThrows(IllegalArgumentException.class, () -> App.factorial(illegalArgs[2]))
    			);
    	System.out.println("Testing ends.");
    }
}
