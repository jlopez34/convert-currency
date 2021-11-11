package com.jayatech.challenge.exchange.wrapper;

import com.jayatech.challenge.exchange.gateway.exchangerates.dto.Rates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public abstract class ExchangeWrapper {

    public static HashMap<String, Double> wrapServiceToMap(Rates rates) {
        HashMap<String, Double> ratesMap = new HashMap<>();
        try {
            Method[] methods = Rates.class.getMethods();
            for (Method method : methods) {
                if (Modifier.isPublic(method.getModifiers())&&method.getName().startsWith("get")) {
                    String key = method.getName().substring(3,method.getName().length());
                    Double value = Double.parseDouble(method.invoke(rates, null).toString());
                    ratesMap.put(key, value);
                }

            }
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ratesMap;
    }
}
