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
package esa.restlight.jaxrs.resolver.arg;

import esa.restlight.core.DeployContext;
import esa.restlight.core.config.RestlightOptions;
import esa.restlight.core.method.Param;
import esa.restlight.core.resolver.arg.RequestBeanArgumentResolver;

import javax.ws.rs.BeanParam;

public class BeanParamArgumentResolver extends RequestBeanArgumentResolver {

    public BeanParamArgumentResolver(DeployContext<? extends RestlightOptions> ctx) {
        super(ctx);
    }

    @Override
    public boolean supports(Param param) {
        return param.hasAnnotation(BeanParam.class);
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
