package com.test.retainedEvents;

import android.content.Intent;
import android.os.Bundle;
import com.test.MyView;
import it.codingjam.lifecyclebinder.DefaultLifeCycleAware;
import it.codingjam.lifecyclebinder.LifeCycleAwareCollector;

public class MyObjectWithEvents2$LifeCycleBinder {

    public static MyObjectWithEvents2 bind(LifeCycleAwareCollector collector, final MyObjectWithEvents2 lifeCycleAware, boolean addInList) {
        if (addInList) {
            collector.addLifeCycleAware(new DefaultLifeCycleAware<MyView>() {
                public void onCreate(MyView argView, Bundle arg0, Intent arg1, Bundle arg2) {
                    lifeCycleAware.myOnCreate(argView, arg0, arg1, arg2);
                }
            });
        }
        return lifeCycleAware;
    }
}
