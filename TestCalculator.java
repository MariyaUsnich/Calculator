import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TestCalculator {
    private Calculator calculator = new Calculator();

    File file = new File("TestData.txt");
    Scanner scanner = new Scanner(file);
    int i = scanner.nextInt();
   int j = scanner.nextInt();

    @Before
    public void initTest() {
        new Calculator();
    }

    @After
    public void afterTest() {
        calculator = null;
    }

    TestCalculator() throws FileNotFoundException {
    }

    @Test
    @DisplayName("Add two numbers")
    void addTest() {
        assertAll(() -> assertEquals(4, calculator.add(2, 2)),
            () -> assertEquals(0, calculator.add(2, -2)),
            () -> assertEquals(-4, calculator.add(-2, -2)),
            () -> assertEquals(1, calculator.add(1, 0)));
}
    @Test
    @DisplayName("Add two numbers from a file")
    void addTestFromFile() {
       assertEquals(5, calculator.add(i, j));
    }
    @Test
    void addWithBufferOverflowTest() {
        Assertions.assertTrue(calculator.add(9223372036854775807L,9223372036854775807L) < 0);
    }

    @Test
    @DisplayName("Subtract a number")
    void subTest(){
        assertEquals(0, calculator.sub(1, 1));
    }
    @Test
    @DisplayName("Subtract from a file")
    void subTestFromFile() {
        assertEquals(1, calculator.sub(j, i));
    }

    @Test
    @DisplayName("Multiply two numbers")
    void mulTest(){
        assertEquals(1, calculator.mul(1, 1));
    }

    @Test
    @DisplayName("Divide by a number")
    void divTest(){
        assertEquals(1, calculator.div(1, 1));
    }

    @Test
    void divZeroTest() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.div(1, 0));
        assertNotNull(exception);
    }
    @Test
    void addWithResult()
    {
        calculator.add(5,10);
        calculator.add(255);
        assertEquals(270, calculator.getResult());
    }
    @Test
    void subWithResult()
    {
        calculator.sub(4,2);
        calculator.sub(15);
        assertEquals(-13, calculator.getResult());
    }

    @Test
    void mulWithResult()
    {
        calculator.mul(2,2);
        calculator.mul(5);
        assertEquals(20, calculator.getResult());
    }

    @Test
    void divWithResult()
    {
        calculator.div(10,2);
        calculator.div(5);
        assertEquals(1, calculator.getResult());
    }
    @Test
    void divZeroResultTest() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.div(0));
        assertEquals(exception.getMessage(), exception.getMessage());
    }
}
