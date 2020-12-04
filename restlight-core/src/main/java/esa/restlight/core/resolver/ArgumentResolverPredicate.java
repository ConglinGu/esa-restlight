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
package esa.restlight.core.resolver;

import esa.restlight.core.method.Param;

/**
 * Interface for resolving method parameters to the real values of the handler method base on the current context.
 */
public interface ArgumentResolverPredicate {

    /**
     * Whether current ArgumentResolver implementation is support given parameter.
     *
     * @param param param
     *
     * @return {@code true} if it supports
     */
    boolean supports(Param param);

}

