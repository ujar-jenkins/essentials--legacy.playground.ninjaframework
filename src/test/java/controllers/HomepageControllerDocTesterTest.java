/*
 * Copyright (C) 2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class HomepageControllerDocTesterTest extends NinjaDocTester {

  String URL_INDEX = "/";
  String URL_HELLO_WORLD_JSON = "/hello_world.json";

  @Test
  public void testGetIndex() {

    Response response = makeRequest(
        Request.GET().url(
            testServerUrl().path(URL_INDEX)));

    assertThat(response.payload, containsString("Hello World!"));
    assertThat(response.payload, containsString("Home"));


  }

  @Test
  public void testGetHelloWorldJson() {

    Response response = makeRequest(
        Request.GET().url(
            testServerUrl().path(URL_HELLO_WORLD_JSON)));

    HomepageController.SimplePojo simplePojo
        = response.payloadJsonAs(HomepageController.SimplePojo.class);

    assertThat(simplePojo.content, CoreMatchers.equalTo("Hello World! Hello Json!"));


  }


}
