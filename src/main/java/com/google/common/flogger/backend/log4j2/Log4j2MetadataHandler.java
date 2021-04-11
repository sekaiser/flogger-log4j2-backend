package com.google.common.flogger.backend.log4j2;

import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.backend.MetadataHandler;

import java.util.Iterator;

public final class Log4j2MetadataHandler {
    private static final MetadataHandler<Log4j2KeyValueHandler> DEFAULT_HANDLER = MetadataHandler
            .builder(Log4j2MetadataKeyValueHandlers.getDefaultValueHandler())
            .setDefaultRepeatedHandler(Log4j2MetadataKeyValueHandlers.getDefaultRepeatedValueHandler())
            .build();

    private Log4j2MetadataHandler() {
    }

    public static MetadataHandler<Log4j2KeyValueHandler> getDefaultHandler() {
        return DEFAULT_HANDLER;
    }
}
