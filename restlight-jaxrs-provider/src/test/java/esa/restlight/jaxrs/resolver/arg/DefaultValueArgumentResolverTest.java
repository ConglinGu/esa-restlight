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

import esa.httpserver.core.AsyncRequest;
import esa.restlight.core.method.HandlerMethod;
import esa.restlight.core.method.MethodParam;
import esa.restlight.core.resolver.ArgumentResolver;
import esa.restlight.jaxrs.ResolverUtils;
import esa.restlight.jaxrs.resolver.arg.subject.ConstructorSubject;
import esa.restlight.jaxrs.resolver.arg.subject.FromStringSubject;
import esa.restlight.jaxrs.resolver.arg.subject.ValueOfSubject;
import esa.restlight.test.mock.MockAsyncRequest;
import esa.restlight.test.mock.MockAsyncResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DefaultValueArgumentResolverTest {

    private static DefaultValueArgumentResolver resolverFactory = new DefaultValueArgumentResolver();

    private static final Subject SUBJECT = new Subject();

    private static Map<String, HandlerMethod> handlerMethods;

    @BeforeAll
    static void setUp() {
        handlerMethods = ResolverUtils.extractHandlerMethods(SUBJECT);
    }

    @Test
    void testSupport() {
        final MethodParam parameter = handlerMethods.get("none").parameters()[0];
        assertFalse(resolverFactory.supports(parameter));

        final MethodParam parameter1 = handlerMethods.get("defaultValue").parameters()[0];
        assertTrue(resolverFactory.supports(parameter1));
    }

    @Test
    void testDefaultValue() throws Exception {
        final AsyncRequest request = MockAsyncRequest
                .aMockRequest()
                .build();
        final Object resolved = createResolverAndResolve(request, "defaultValue");
        assertEquals("default", resolved);
    }

    @Test
    void testConstructor() throws Exception {
        final AsyncRequest request = MockAsyncRequest
                .aMockRequest()
                .build();
        final Object resolved = createResolverAndResolve(request, "constructor");
        assertTrue(resolved instanceof ConstructorSubject);
        assertEquals("default", ((ConstructorSubject) resolved).getValue());
    }

    @Test
    void testValueOf() throws Exception {
        final AsyncRequest request = MockAsyncRequest
                .aMockRequest()
                .withParameter("foo", "bar")
                .build();
        final Object resolved = createResolverAndResolve(request, "valueOf");
        assertTrue(resolved instanceof ValueOfSubject);
        assertEquals("default", ((ValueOfSubject) resolved).getValue());
    }

    @Test
    void testFromString() throws Exception {
        final AsyncRequest request = MockAsyncRequest
                .aMockRequest()
                .withParameter("foo", "bar")
                .build();
        final Object resolved = createResolverAndResolve(request, "fromString");
        assertTrue(resolved instanceof FromStringSubject);
        assertEquals("default", ((FromStringSubject) resolved).getValue());
    }

    private static Object createResolverAndResolve(AsyncRequest request, String method) throws Exception {
        final MethodParam parameter = handlerMethods.get(method).parameters()[0];
        assertTrue(resolverFactory.supports(parameter));
        final ArgumentResolver resolver = resolverFactory.createResolver(parameter, null);
        return resolver.resolve(request, MockAsyncResponse.aMockResponse().build());
    }

    private static class Subject {

        public void defaultValue(@DefaultValue("default") String foo) {
        }

        public void none(@QueryParam("foo") String foo) {
        }


        public void constructor(@DefaultValue("default") ConstructorSubject foo) {
        }


        public void valueOf(@DefaultValue("default") ValueOfSubject foo) {
        }

        public void fromString(@DefaultValue("default") FromStringSubject foo) {
        }
    }
}
