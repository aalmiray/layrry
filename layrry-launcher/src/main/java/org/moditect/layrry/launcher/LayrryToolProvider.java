/**
 *  Copyright 2020 The ModiTect authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.moditect.layrry.launcher;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;

public class LayrryToolProvider implements ToolProvider {
    @Override
    public String name() {
        return "layrry";
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
        // TODO: propagate out & err
        return LayrryLauncher.launch(args);
    }
}
