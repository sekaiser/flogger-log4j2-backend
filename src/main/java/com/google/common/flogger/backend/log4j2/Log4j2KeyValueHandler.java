package com.google.common.flogger.backend.log4j2;

import com.google.common.flogger.MetadataKey;
import org.apache.logging.log4j.util.StringMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Log4j2KeyValueHandler implements MetadataKey.KeyValueHandler {
    private final StringMap contextData;

    public Log4j2KeyValueHandler(StringMap contextData) {
        this.contextData = contextData;
    }

    private static final Set<Class<?>> FUNDAMENTAL_TYPES =
            new HashSet<Class<?>>(
                    Arrays.asList(
                            Boolean.class,
                            Byte.class,
                            Short.class,
                            Integer.class,
                            Long.class,
                            Float.class,
                            Double.class));

    @Override
    public void handle(String key, Object value) {
        // candidate for threadstack?
        if (value == null) return;

        if (FUNDAMENTAL_TYPES.contains(value.getClass())) {
            contextData.putValue(key, value);
        } else {
            contextData.putValue(key, value.toString());
        }
    }
}
