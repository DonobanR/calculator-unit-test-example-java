package ec.edu.epn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    //Arrange
    //Act
    //Assert
    @Test
    @DisplayName("Prueba unitaria encargada de verificar el metodo de la suma")
    public void testSum( ){
    	//Arrange + Act
        int result = calculator.sum(2, 2);
        //Assert
        assertEquals(4, result, "Fallo en Suma");
    }
    
    @Test
    @DisplayName("Prueba unitaria encargada de verificar el metodo de la suma")
    public void testSumTest2( ){
    	//Arrange + Act
    	//int result = calculator.sum(2, 2)
    	//Assert
        //assertEquals(4, result, "Fallo en Suma");
    	
    	assertAll("Suma de valores en varios casos", 
    		() -> {
    			int resultado = calculator.sum(2, 2);
    			assertEquals(4, resultado);
    		},
    		() -> assertEquals(0, calculator.sum(-1, 1))
    	);
    }

    @Test
    public void testSum2( ){
    	//Arrange + Act
        int result = calculator.sum(4, 6);
        //Assert
        assertEquals(10, result, "Fallo en Suma");
    }
    
    @ParameterizedTest
    @CsvSource({
    	"2, 1, 3",
    	"0, 5, 5",
    	"-1, 2, 1",
    })
    
    public void testSumMUltipleData(int a, int b, int expected) {
    	//Arrange + Act
    	int result = calculator.sum(a, b);
    	//Assert
    	assertEquals(expected, result);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 100, -1})
    public void testSumWithFixedValues(int value) {
    	//Arrange + Act
    	int result = calculator.sum(value, 0);
    	//Assert
    	assertTrue(result == value);
    }
    
    @Test
    public void testRest( ){
    	//Arrange + Act
        int result = calculator.minus(2, 1);
        //Assert
        assertEquals(1, result, "Fallo en la resta");
    }

    @Test
    public void testMulti( ){
    	//Arrange + Act
        int result = calculator.multiply(2, 3);
        //Assert
        assertEquals(6, result, "Fallo en la multiplicacion");
    }

    @Test
    public void testDiv( ){
    	//Arrange + Act
        int result = calculator.divide(6, 2);
        //Assert
        assertEquals(3, result, "Fallo en la division");
    }

    @Test
    public void testDivisionPorCeroLanzaExcepcion() {

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6, 0);
        });
    }
    
	public void testSumMultipleData(int a, int b, int expected) {
		//Arrange + Act
		int result = calculator.sum(a, b);
		//Assert
		assertEquals(expected, result);
	}
}