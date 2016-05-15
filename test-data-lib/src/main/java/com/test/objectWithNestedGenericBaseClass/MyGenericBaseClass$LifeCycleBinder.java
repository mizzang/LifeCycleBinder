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

package com.test.objectWithNestedGenericBaseClass;

import android.os.Bundle;

import com.test.MyView;

import it.codingjam.lifecyclebinder.ObjectBinder;

public class MyGenericBaseClass$LifeCycleBinder<T extends MyView> extends ObjectBinder<MyGenericBaseClass<T>, T> {
  public MyGenericBaseClass$LifeCycleBinder(String bundlePrefix) {
    super(bundlePrefix);
  }

  public void bind(final MyGenericBaseClass<T> view) {
    listeners.add(view.myBaseObject);
  }

  public void saveInstanceState(MyGenericBaseClass<T> view, Bundle bundle) {
    bundle.putParcelable(bundlePrefix + "myBaseParcelable", view.myBaseParcelable);
  }

  public void restoreInstanceState(MyGenericBaseClass<T> view, Bundle bundle) {
    view.myBaseParcelable = bundle.getParcelable(bundlePrefix + "myBaseParcelable");
  }
}