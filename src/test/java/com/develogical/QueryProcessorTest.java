package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsYourName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("PRS"));
    }

    @Test
    public void givesLargestNumber() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 20, 21"), containsString("21"));
    }

    @Test
    public void returnsSumNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 2 plus 20"), containsString("22"));
    }

    @Test
    public void returnsProductNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 3 multiplied by 20"), containsString("60"));
    }

    @Test
    public void returnsIfCubeAndSquare() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 1225, 64"), containsString("64"));
    }

    @Test
    public void returnsIfNoneAreCubeAndSquare() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 1225, 31"), containsString(""));
    }

    @Test
    public void knowsDrNoJamesBond() throws Exception {
        assertThat(queryProcessor.process("Who played James Bond in the film Dr No"), containsString("Sean Connery"));
    }

    @Test
    public void knowsColourOfBanana() throws Exception {
        assertThat(queryProcessor.process("which year was Theresa May first elected as the Prime Minister of Great Britain"), containsString("2016"));
    }

    @Test
    public void knowsCityOfEiffelTower() throws Exception {
        assertThat(queryProcessor.process("what colour is a banana"), containsString("yellow"));
    }

    @Test
    public void knowsWhenTheresaMay() throws Exception {
        assertThat(queryProcessor.process("what city is the Eiffel Tower in"), containsString("Paris"));
    }

    @Test
    public void knowsWhenNoneArePrimes() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 4, 393"), containsString(""));
    }

    @Test
    public void knowsWhichArePrimes() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 4, 7"), containsString("7"));
    }

    @Test
    public void returnsMinusNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 20 minus 5"), containsString("15"));
    }

    @Test
    public void returnsPowerOfNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 3 to the power of 2"), containsString("9"));
    }
}
