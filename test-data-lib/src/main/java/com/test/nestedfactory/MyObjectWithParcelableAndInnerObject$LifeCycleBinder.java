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

package com.test.nestedfactory;

import com.test.MyObject$LifeCycleBinder;
import it.codingjam.lifecyclebinder.LifeCycleAwareCollector;
import java.util.concurrent.Callable;

public class MyObjectWithParcelableAndInnerObject$LifeCycleBinder {
    public static MyObjectWithParcelableAndInnerObject bind(LifeCycleAwareCollector collector, MyObjectWithParcelableAndInnerObject lifeCycleAware,
            String key, Callable<MyObjectWithParcelableAndInnerObject> factory, boolean addInList) {
        MyObjectWithParcelableAndInnerObject ret = collector.getOrCreate(lifeCycleAware, key, factory);
        ret.myObject2 = MyObject$LifeCycleBinder.bind(collector, null, "myObject2Provider", ret.myObject2Provider, true);
        MyObject$LifeCycleBinder.bind(collector, ret.myObject, null, null, true);
        if (addInList) {
            collector.addLifeCycleAware(ret);
        }
        return ret;
    }
}
