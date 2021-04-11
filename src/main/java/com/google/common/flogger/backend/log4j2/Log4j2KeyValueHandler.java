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

import com.google.common.flogger.MetadataKey;
import org.apache.logging.log4j.util.StringMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Log4j2KeyValueHandler implements MetadataKey.KeyValueHandler {
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
    private final StringMap contextData;

    public Log4j2KeyValueHandler(StringMap contextData) {
        this.contextData = contextData;
    }

    @Override
    public void handle(String key, Object value) {
        // candidate for threadstack?
        if (value == null) {
            return;
        }

        if (FUNDAMENTAL_TYPES.contains(value.getClass())) {
            contextData.putValue(key, value);
        } else {
            contextData.putValue(key, value.toString());
        }
    }
}
