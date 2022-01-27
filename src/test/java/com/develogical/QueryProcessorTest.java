package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void knowsAboutImperial() throws Exception {
        assertThat(queryProcessor.process("Imperial"),
            containsString("university"));
    }

    @Test
    public void knowsAboutAmelia() throws Exception {
        assertThat(queryProcessor.process("what is your name"),
            containsString("KK"));
    }

    @Test
    public void largest() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest 33, 44, "
                + "-1"),
            containsString("44"));
    }
    @Test
    public void summer() throws Exception {
        assertThat(queryProcessor.process("what is 12 plus 15"),
            containsString("27"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
