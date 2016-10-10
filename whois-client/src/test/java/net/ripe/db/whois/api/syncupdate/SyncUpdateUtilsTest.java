package net.ripe.db.whois.api.syncupdate;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SyncUpdateUtilsTest {

    @Test
    public void encode() {
        assertThat(SyncUpdateUtils.encode(""), is(""));
        assertThat(SyncUpdateUtils.encode("123"), is("123"));
        assertThat(SyncUpdateUtils.encode("{}"), is("%7B%7D"));
        assertThat(SyncUpdateUtils.encode("{"), is("%7B"));
        assertThat(SyncUpdateUtils.encode("{%7D"), is("%7B%257D"));
        assertThat(SyncUpdateUtils.encode("a b c"), is("a+b+c"));           // IS encoded (as query param)
        assertThat(SyncUpdateUtils.encode("a+b+c"), is("a%2Bb%2Bc"));       // IS encoded (as query parameter) - plus is not a valid character in the query part of the URL
        assertThat(SyncUpdateUtils.encode("straße"), is("stra%C3%9Fe"));            // UTF-8 encoded
    }

}