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
import org.apache.sling.commons.json.io.JSONWriter;
import org.apache.sling.commons.json.util.DespacedRendering;
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

}