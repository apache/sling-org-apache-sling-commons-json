/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.commons.json;

import java.io.StringWriter;
import java.util.Iterator;

import org.apache.sling.commons.json.io.JSONWriter;
import org.apache.sling.commons.json.util.DespacedRendering;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JSONWriterTestBackwardsCompatibility {
    private JSONWriter w;
    private StringWriter output;

    @Before
    public void setup() {
        output = new StringWriter();
        w = new JSONWriter(output);
    }

    @Test
    public void allowDuplicatedKeys() {
        w.object();
        w.key("key").value("value1");
        w.key("key").value("value2");
        w.endObject();
        final DespacedRendering r = new DespacedRendering(output.toString());
        r.expect(
                "_key_:_value1_",
                "_key_:_value2_");
    }

    @Test
    public void ensureObjectOrder1() throws Exception {
        JSONObject o = new JSONObject();
        o.put("Hallo", "World");
        o.put("foo", "bar");
        o.put("welcome", "home");
        o.put("fix", "my-order");

        StringBuilder b = new StringBuilder();
        Iterator<String> keys = o.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            b.append(key).append("=").append(o.get(key)).append(";");
        }

        Assert.assertEquals("Hallo=World;foo=bar;welcome=home;fix=my-order;", b.toString());
    }

    @Test
    public void ensureObjectOrder2() throws Exception {
        JSONObject o = new JSONObject();
        o.put("fix", "my-order");
        o.put("Hallo", "World");
        o.put("foo", "bar");
        o.put("welcome", "home");

        StringBuilder b = new StringBuilder();
        Iterator<String> keys = o.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            b.append(key).append("=").append(o.get(key)).append(";");
        }

        Assert.assertEquals("fix=my-order;Hallo=World;foo=bar;welcome=home;", b.toString());
    }
}