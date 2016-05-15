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

package com.test.parcelable;

import android.os.Bundle;

import it.codingjam.lifecyclebinder.ObjectBinder;

public class MyActivity2$LifeCycleBinder extends ObjectBinder<MyActivity2, MyActivity2> {
  private MyObjectWithParcelable$LifeCycleBinder myObject;

  public MyActivity2$LifeCycleBinder(String bundlePrefix) {
    super(bundlePrefix);
    myObject = new MyObjectWithParcelable$LifeCycleBinder(bundlePrefix + SEPARATOR + "myObject");
  }

  public void bind(final MyActivity2 view) {
    initRetainedObject(bundlePrefix + "myName", view.myObject);
    myObject.bind((MyObjectWithParcelable) retainedObjects.get(bundlePrefix + "myName"));
    listeners.addAll(myObject.getListeners());
  }
  public void saveInstanceState(MyActivity2 view, Bundle bundle) {
    myObject.saveInstanceState((MyObjectWithParcelable) retainedObjects.get(bundlePrefix + "myName"), bundle);
  }

  public void restoreInstanceState(MyActivity2 view, Bundle bundle) {
    myObject.restoreInstanceState((MyObjectWithParcelable) retainedObjects.get(bundlePrefix + "myName"), bundle);
  }
}