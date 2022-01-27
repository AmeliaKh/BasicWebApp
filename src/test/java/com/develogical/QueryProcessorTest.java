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
    public void minuser() throws Exception {
        assertThat(queryProcessor.process("what is 0 minus 1"),
            containsString("-1"));
    }
    @Test
    public void squareandcube() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 772, 262144"),
            containsString("262144"));
    }
    @Test
    public void manysquareandcube() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a "
                + "cube: 1296, 504, 628, 1681, 262144, 1"),
            containsString("262144,1"));
    }@Test
    public void manysquareandcub2e() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 625, 989"),
            containsString(""));
    }
    @Test
    public void nosquareandcube() throws Exception {
        assertThat(queryProcessor.process(" 1764, 2025, 384, 323\n"),
            containsString(""));
    }
    @Test
    public void areprimes() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 59, 542"),
            containsString("59"));
    }
    @Test
    public void areprimes2() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 2, 478, 824, 109"),
            containsString("2,109"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
