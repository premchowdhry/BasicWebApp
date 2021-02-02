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
}
