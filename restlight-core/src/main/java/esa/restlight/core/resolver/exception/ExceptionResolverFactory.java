/*
 * Copyright 2020 OPPO ESA Stack Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package esa.restlight.core.resolver.exception;

import esa.restlight.core.handler.Handler;
import esa.restlight.core.resolver.ExceptionResolver;

public interface ExceptionResolverFactory {

    /**
     * Creates an instance of {@link ExceptionResolver} for given {@link Handler}.
     *
     * @param handler handler
     *
     * @return resolver
     */
    ExceptionResolver<Throwable> createResolver(Handler handler);

}
