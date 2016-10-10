package net.ripe.db.whois.api.syncupdate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SyncUpdateUtils {

    private SyncUpdateUtils() {
        // do not instantiate
    }

    public static String encode(final String value) {
        return encode(value, "UTF-8");
    }

    // Translate a string into application/x-www-form-urlencoded format.
    // Result can be used as form parameter (or query parameter).
    public static String encode(final String value, final String charset) {
        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
