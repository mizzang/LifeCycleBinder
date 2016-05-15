/*
 *   Copyright 2016 Fabio Collini.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package it.codingjam.lifecyclebinder;

import com.squareup.javapoet.ClassName;

import javax.lang.model.element.Element;

public class NestedLifeCycleAwareInfo {

    public final Element field;

    public final LifeCycleAwareInfo info;

    public final RetainedObjectInfo retained;

    public NestedLifeCycleAwareInfo(Element field, LifeCycleAwareInfo info, RetainedObjectInfo retained) {
        this.field = field;
        this.info = info;
        this.retained = retained;
    }

    public ClassName getBinderClassName() {
        String typeName;
        if (retained != null) {
            typeName = retained.typeName.toString();
        } else {
            typeName = field.asType().toString();
        }
        return ClassName.bestGuess(typeName + LifeCycleBinderProcessor.LIFE_CYCLE_BINDER_SUFFIX);
    }
}
