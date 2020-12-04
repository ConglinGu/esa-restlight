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
package esa.restlight.jaxrs.resolver.result;

import esa.restlight.core.annotation.ResponseSerializer;
import esa.restlight.core.annotation.Serializer;
import esa.restlight.core.method.InvocableMethod;
import esa.restlight.core.resolver.ArgumentResolverFactory;
import esa.restlight.core.resolver.result.AbstractSpecifiedFixedResponseBodyReturnValueResolver;

/**
 * Implementation of {@link ArgumentResolverFactory} for resolving argument that annotated by the ResponseBody, {@link
 * ResponseSerializer}, {@link Serializer}.
 */
public class SpecifiedFixedResponseBodyReturnValueResolver
        extends AbstractSpecifiedFixedResponseBodyReturnValueResolver {

    @Override
    protected boolean supports0(InvocableMethod invocableMethod) {
        return true;
    }

    @Override
    public int getOrder() {
        return 210;
    }

}
