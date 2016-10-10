package net.ripe.db.whois.api.rest;

import net.ripe.db.whois.api.rest.client.RestClientUtils;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RestClientUtilsTest {

    // https://texnoblog.wordpress.com/2014/06/11/urlencode-just-one-is-not-enough/

    // encoding spaces: You should have %20 before the ? and + after.

    @Test
    public void encode() {
        assertThat(RestClientUtils.encode(""), is(""));
        assertThat(RestClientUtils.encode("123"), is("123"));
        assertThat(RestClientUtils.encode("{}"), is("%7B%7D"));
        assertThat(RestClientUtils.encode("{"), is("%7B"));
        assertThat(RestClientUtils.encode("{%7D"), is("%7B%257D"));
        assertThat(RestClientUtils.encode("a b c"), is("a%20b%20c"));   // IS encoded as path parameter
        assertThat(RestClientUtils.encode("a+b+c"), is("a+b+c"));       // NOT encoded (path parameter) (plus IS valid in path, but is NOT valid character in query part of URL).
    }
}

