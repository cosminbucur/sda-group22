package com.sda.testing.junit4;

import com.sda.testing.mockito.Calculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

public class ExceptionRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenDividingBy0() {
        // given
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("/ by zero");
        Calculator calculator = new Calculator();
        int number = new Random().nextInt();

        // when
        calculator.divide(number, 0);

        // then
        // should throw expected exception
    }
}
