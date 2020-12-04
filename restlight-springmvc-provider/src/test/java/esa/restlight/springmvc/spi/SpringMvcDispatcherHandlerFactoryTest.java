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
package esa.restlight.springmvc.spi;

import esa.restlight.core.DeployContext;
import esa.restlight.core.config.RestlightOptions;
import esa.restlight.server.bootstrap.DispatcherHandler;
import esa.restlight.server.route.RouteRegistry;
import esa.restlight.springmvc.bootstrap.SpringMvcDispatcherHandler;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SpringMvcDispatcherHandlerFactoryTest {

    @Test
    void testDispatcherHandler() {
        final DeployContext<RestlightOptions> ctx = mock(DeployContext.class);
        when(ctx.routeRegistry()).thenReturn(Optional.of(mock(RouteRegistry.class)));
        final SpringMvcDispatcherHandlerFactory factory = new SpringMvcDispatcherHandlerFactory();
        final DispatcherHandler handler = factory.dispatcherHandler(ctx);
        assertNotNull(handler);
        assertTrue(handler instanceof SpringMvcDispatcherHandler);
    }

}
