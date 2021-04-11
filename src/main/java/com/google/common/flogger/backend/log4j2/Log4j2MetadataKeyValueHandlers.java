package com.google.common.flogger.backend.log4j2;

import com.google.common.flogger.backend.MetadataHandler;

public final class Log4j2MetadataKeyValueHandlers {

    private static final MetadataHandler.ValueHandler<Object, Log4j2KeyValueHandler> EMIT_METADATA =
            (key, value, handler) -> key.emit(value, handler);

    private Log4j2MetadataKeyValueHandlers() {
    }

    public static MetadataHandler.ValueHandler<Object, Log4j2KeyValueHandler> getDefaultValueHandler() {
        return EMIT_METADATA;
    }
}
