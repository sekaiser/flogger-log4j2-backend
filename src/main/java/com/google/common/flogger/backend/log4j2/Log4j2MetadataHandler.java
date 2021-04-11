package com.google.common.flogger.backend.log4j2;

import com.google.common.flogger.backend.MetadataHandler;

public final class Log4j2MetadataHandler {
    private static final MetadataHandler<Log4j2KeyValueHandler> DEFAULT_HANDLER = MetadataHandler
            .builder(Log4j2MetadataKeyValueHandlers.getDefaultValueHandler())
            .build();

    private Log4j2MetadataHandler() {
    }

    public static MetadataHandler<Log4j2KeyValueHandler> getDefaultHandler() {
        return DEFAULT_HANDLER;
    }
}
