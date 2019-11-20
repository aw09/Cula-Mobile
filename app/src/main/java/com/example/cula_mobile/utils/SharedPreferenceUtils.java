package com.example.cula_mobile.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SharedPreferenceUtils {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void initSharedPrefrences(String preferencesName, Context context) {
        sharedPreferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void setStringSharedPreferences(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public static void setIntSharedPreferences(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public static void setFloatSharedPreferences(String key, Float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    public static void setBooleanSharedPreferences(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void setLongSharedPreferences(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public static void setMapStringSharedPreferences(String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.apply();
    }

    public static String getStringSharedPreferences(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public static int getIntSharedPreferences(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public static float getFloatSharedPreferences(String key, Float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public static boolean getBooleanSharedPreferences(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static long getLongSharedPreferences(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public static Set<String> getSetStringSharedPreferences(String key, Set<String> defaultValue) {
        return sharedPreferences.getStringSet(key, defaultValue);
    }

    public static void removeSavedPref(String key) {
        editor.remove(key);
        editor.apply();
    }

    public static void clearAll() {
        editor.clear();
        editor.commit();
    }
}
