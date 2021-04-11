/*
 * Copyright (C) 2019 The Flogger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.flogger.backend.log4j2;

import com.google.common.collect.ImmutableList;
import com.google.common.flogger.backend.MetadataHandler;

public final class Log4j2MetadataKeyValueHandlers {

    private static final MetadataHandler.ValueHandler<Object, Log4j2KeyValueHandler> EMIT_METADATA =
            (key, value, handler) -> key.emit(value, handler);

    private static final MetadataHandler.RepeatedValueHandler<Object, Log4j2KeyValueHandler> EMIT_REPEATED_METADATA =
            // Passing a list is important to not break log4j2s layout system.
            // At this point we do not know the target format, e.g. PatternLayout vs JsonLayout
            (key, values, handler) -> handler.handle(key.getLabel(), ImmutableList.copyOf(values));

    private Log4j2MetadataKeyValueHandlers() {
    }

    public static MetadataHandler.ValueHandler<Object, Log4j2KeyValueHandler> getDefaultValueHandler() {
        return EMIT_METADATA;
    }

    public static MetadataHandler.RepeatedValueHandler<Object, Log4j2KeyValueHandler> getDefaultRepeatedValueHandler() {
        return EMIT_REPEATED_METADATA;
    }
}
