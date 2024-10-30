package com.junittesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    private static Example example;

    @BeforeAll
    public static void setUp() {
        example = new Example();
    }

    @Test
    public void testSumar() {

        // Arrange
        int numberA = 3;
        int numberB = 3;

        // Act
        int result = example.sumar( numberA, numberB );

        // Assert
        assertEquals( 6, result );
        assertInstanceOf( Integer.class, result );

    }

    @Test
    public void testPositiveCheck() {

        // Arrange
        int numberA = 5;

        // Act
        boolean resultA = example.checkPositivo( numberA );

        // Assert
        assertTrue( resultA );

    }

    @Test
    public void testPositiveCheckError() {
        // Arrange
        int number = -5;

        // Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> example.checkPositivo(number)
        );
    }

    @Test
    public void testContarLetasA() {

        // Arrange
        String cadena = "abaabb";

        // Act
        int result = example.contarLetrasA( cadena );

        // Assert
        assertEquals( 3, result );
        assertInstanceOf( Integer.class, result );

    }

    @Test
    public void testContieneElemento() {

        // Arrange
        List<String> list = List.of( "valencia", "madrid", "ciudad real", "toledo", "sevilla" );
        String elemento = "valencia";

        // Act
        boolean result = example.contieneElemento( list, elemento );

        // Assert
        assertTrue( result );
        assertNotNull( result );
        assertInstanceOf( Boolean.class, result );

    }

    @Test
    public void testRevertirCadena() {

        // Arrange
        String cadena = "ivan";

        // Act
        String result = example.revertirCadena( cadena );

        // Assert
        assertEquals( "navi", result );

    }

    @Test
    public void testFactorialOk() {

        // Arrange
        int number = 5;

        // Act
        long result = example.factorial( number );

        // Assert
        assertEquals( 120, result );
        assertInstanceOf( Long.class, result );

    }

    @Test
    public void testFactorialError() {

        // Arrange
        int number = -5;

        // Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> example.factorial( number )
        );

    }

    @Test
    public void testEsPrimoTrue() {

        // Arrange
        int number = 5;

        // Act
        boolean result = example.esPrimo( number );

        // Assert
        assertTrue( result );
        assertInstanceOf( Boolean.class, result );

    }

    @Test
    public void testEsPrimoFalse() {

        // Arrange
        int number = 10;

        // Act
        boolean result = example.esPrimo( number );

        // Assert
        assertFalse( result );
        assertInstanceOf( Boolean.class, result );

    }

    @Test
    public void testEsPrimoUnderOneFalse() {

        // Arrange
        int number = 0;

        // Act
        boolean result = example.esPrimo( number );

        // Assert
        assertFalse( result );
        assertInstanceOf( Boolean.class, result );

    }

    @Test
    public void testMensajeConRetraso() throws InterruptedException {

        // Arrange
        String expected = "Listo después de retraso";

        // Act
        String result = example.mensajeConRetraso();

        // Assert
        assertEquals( expected, result );
        assertInstanceOf( String.class, result );

    }

    @Test
    public void testConvertAString() {

        // Arrange
        List<Integer> listInt = List.of( 1, 2, 3, 4, 5, 6 );
        List<String> expected = List.of( "1", "2", "3", "4", "5", "6" );

        // Act
        List<String> result = example.convertirAString( listInt );

        // Assert
        assertEquals( expected, result );

    }

    @Test
    public void testCalcularMedia() {

        // Arrange
        List<Integer> listInt = List.of( 1, 2, 3 );
        double expected = (1+2+3)/3;

        // Act
        double result = example.calcularMedia( listInt );

        // Assert
        assertEquals( expected, result );

    }

    @Test
    public void testCalcularMediaError(){

        // Arrange
        List<Integer> listEmpty = List.of();
        List<Integer> listNull = null;

        // Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> example.calcularMedia( listEmpty )
        );

        assertThrows(
          IllegalArgumentException.class,
                () -> example.calcularMedia( listNull )
        );

    }

    @Test
    public void testConvertirListaAString() {

        // Arrange
        List<String> listStringsLowrCase = List.of( "ivan", "carlos", "david" );
        String expected = listStringsLowrCase.stream()
                .map( String::toUpperCase )
                .collect( Collectors.joining(",") );

        // Act
        String result = example.convertirListaAString( listStringsLowrCase );

        // Assert
        assertEquals( expected, result );

    }

}
