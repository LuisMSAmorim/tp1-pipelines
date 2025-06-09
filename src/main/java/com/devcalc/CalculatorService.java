package com.devcalc;

/**
 * Serviço que fornece operações matemáticas básicas.
 * Esta classe é final para garantir que não seja estendida, já que não foi
 * projetada para extensão.
 */
public final class CalculatorService {

    /**
     * Soma dois números.
     *
     * @param a o primeiro número
     * @param b o segundo número
     * @return a soma de a e b
     */
    public double add(final double a, final double b) {
        return a + b;
    }

    /**
     * Subtrai dois números.
     *
     * @param a o número do qual será subtraído
     * @param b o número a ser subtraído
     * @return a diferença entre a e b
     */
    public double subtract(final double a, final double b) {
        return a - b;
    }

    /**
     * Multiplica dois números.
     *
     * @param a o primeiro número
     * @param b o segundo número
     * @return o produto de a e b
     */
    public double multiply(final double a, final double b) {
        return a * b;
    }

    /**
     * Divide dois números.
     *
     * @param a o dividendo
     * @param b o divisor
     * @return o quociente de a por b
     * @throws IllegalArgumentException se b for zero
     */
    public double divide(final double a, final double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
} 