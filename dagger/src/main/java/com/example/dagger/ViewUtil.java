package com.example.dagger;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ${user} on 2018/1/23.
 * QinQin
 */

public class ViewUtil {
    public static void inject(final Activity activity){
        Class clazz = activity.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView != null){
                try {
                    field.setAccessible(true);
                    field.set(activity,activity.findViewById(bindView.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        Method[] methods = clazz.getMethods();
        for (final  Method method : methods){
            OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick != null){
                activity.findViewById(onClick.value()).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            method.setAccessible(true);
                            method.invoke(activity);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
