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
package esa.restlight.jaxrs.spi;

import esa.commons.annotation.Internal;
import esa.commons.spi.Feature;
import esa.restlight.core.DeployContext;
import esa.restlight.core.config.RestlightOptions;
import esa.restlight.core.handler.HandlerAdvicesFactory;
import esa.restlight.core.handler.locate.AbstractRouteHandlerLocator;
import esa.restlight.core.handler.locate.RouteHandlerLocator;
import esa.restlight.core.method.InvocableMethod;
import esa.restlight.core.spi.RouteHandlerLocatorFactory;
import esa.restlight.core.util.Constants;
import io.netty.handler.codec.http.HttpResponseStatus;

@Internal
@Feature(tags = Constants.INTERNAL)
public class JaxrsRouteHandlerLocatorFactory implements RouteHandlerLocatorFactory {

    @Override
    public RouteHandlerLocator locator(DeployContext<? extends RestlightOptions> ctx) {
        return new HandlerLocator(
                ctx.options().getScheduling().getDefaultScheduler(),
                ctx.handlerAdvicesFactory().orElse(null));
    }

    static class HandlerLocator extends AbstractRouteHandlerLocator {

        HandlerLocator(
                String globalScheduling,
                HandlerAdvicesFactory handlerAdvicesFactory) {
            super(globalScheduling, handlerAdvicesFactory);
        }

        @Override
        protected HttpResponseStatus getCustomResponse(InvocableMethod handlerMethod) {
            return null;
        }
    }
}
