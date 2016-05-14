package com.test;

import android.os.Bundle;

import it.codingjam.lifecyclebinder.ObjectBinder;

public class ActivityMyObjectWithParcelableAndInnerObject$LifeCycleBinder extends ObjectBinder<ActivityMyObjectWithParcelableAndInnerObject, ActivityMyObjectWithParcelableAndInnerObject> {
    private MyObjectWithParcelableAndInnerObject$LifeCycleBinder myObject = new MyObjectWithParcelableAndInnerObject$LifeCycleBinder("com.test.ActivityMyObjectWithParcelableAndInnerObject myObject");

    public ActivityMyObjectWithParcelableAndInnerObject$LifeCycleBinder(String bundlePrefix) {
        super(bundlePrefix);
    }

    public void bind(final ActivityMyObjectWithParcelableAndInnerObject view) {
        listeners.add(view.myObject);
        myObject.bind(view.myObject);
        listeners.addAll(myObject.getListeners());
    }

    public void saveInstanceState(ActivityMyObjectWithParcelableAndInnerObject view, Bundle bundle) {
        myObject.saveInstanceState(view.myObject, bundle);
    }

    public void restoreInstanceState(ActivityMyObjectWithParcelableAndInnerObject view, Bundle bundle) {
        myObject.restoreInstanceState(view.myObject, bundle);
    }
}
