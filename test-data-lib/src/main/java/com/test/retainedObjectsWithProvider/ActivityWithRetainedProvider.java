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

package com.test.retainedObjectsWithProvider;

import android.support.v4.app.FragmentActivity;

import com.test.MyObject;
import com.test.MyView;

import it.codingjam.lifecyclebinder.RetainedObjectProvider;

interface Provider<T> {
    T get();
}

public class ActivityWithRetainedProvider extends FragmentActivity implements MyView {
    @RetainedObjectProvider
    Provider<MyObject> myObject = new Provider<MyObject>() {
        @Override
        public MyObject get() {
            return new MyObject();
        }
    };
}
