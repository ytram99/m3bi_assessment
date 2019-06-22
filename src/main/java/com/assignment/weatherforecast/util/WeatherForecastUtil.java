package com.assignment.weatherforecast.util;

public class WeatherForecastUtil {
	
	public static String getMethodName(StackTraceElement[] e) {
        String methodName = null;

        boolean doNext = false;

        for (StackTraceElement s : e) {
            if (doNext && methodName == null) {
                methodName = s.getMethodName();
            }

            doNext = s.getMethodName().equals("getStackTrace");
        }

        return methodName;
    }

}
