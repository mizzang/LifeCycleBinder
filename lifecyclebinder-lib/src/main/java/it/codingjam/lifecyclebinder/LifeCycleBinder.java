package it.codingjam.lifecyclebinder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class LifeCycleBinder {
    public static void bind(Fragment fragment) {
        bind(fragment, fragment.getChildFragmentManager(), fragment.getActivity().getSupportFragmentManager());
    }

    public static void bind(FragmentActivity activity) {
        bind(activity, activity.getSupportFragmentManager(), activity.getSupportFragmentManager());
    }

    private static <T> void bind(T obj, FragmentManager fragmentManager, FragmentManager activityFragmentManager) {
        List<ViewLifeCycleAware<T>> listeners = new ArrayList<>();

        Map<String, Callable<ViewLifeCycleAware<T>>> map = ReflectionUtils.loadRetainedListeners(obj);
        if (!map.isEmpty()) {
            LifeCycleRetainedFragment lifeCycleRetainedFragment = LifeCycleRetainedFragment.getOrCreateRetainedFragment(activityFragmentManager);
            for (Map.Entry<String, Callable<ViewLifeCycleAware<T>>> entry : map.entrySet()) {
                String name = entry.getKey();
                ViewLifeCycleAware<T> listener = (ViewLifeCycleAware<T>) lifeCycleRetainedFragment.map.get(name);
                if (listener == null) {
                    try {
                        listener = entry.getValue().call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    lifeCycleRetainedFragment.map.put(name, listener);
                }
                listeners.add(listener);
            }
        }

        LifeCycleBinderFragment<T> fragment = LifeCycleBinderFragment.getOrCreate(fragmentManager);
        fragment.init(obj);
        for (ViewLifeCycleAware<T> listener : listeners) {
            fragment.addListener(listener);
        }
        try {
            Class<?> c = Class.forName(obj.getClass().getName() + "$LifeCycleBinder");
            Method method = c.getMethod("bind", obj.getClass(), ViewLifeCycleAwareContainer.class, FragmentManager.class);
            method.invoke(null, obj, fragment, activityFragmentManager);
        } catch (ClassNotFoundException ignored) {
        } catch (Exception e) {
            throw new RuntimeException("Error invoking binding", e);
        }
    }
}
