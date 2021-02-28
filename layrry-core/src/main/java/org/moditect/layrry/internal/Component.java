/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 - 2021 The ModiTect authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.moditect.layrry.internal;

import java.util.Collections;
import java.util.List;

public abstract class Component {

    private final String name;
    private final List<String> parents;

    protected Component(String name, List<String> parents) {
        this.name = name;
        this.parents = Collections.unmodifiableList(parents);
    }

    public static Component fromLayer(LayerBuilderImpl layer) {
        if (layer.getLayerDir() != null) {
            return new Plugin(layer.getName(), layer.getLayerDir(), layer.getParents());
        }
        else {
            return new Layer(layer.getName(), layer.getModuleGavs(), layer.getParents());
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getParents() {
        return parents;
    }

    public abstract boolean isPlugin();
}
