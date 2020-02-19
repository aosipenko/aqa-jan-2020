package aqa.util;

import java.util.HashMap;

public class DataHolder {
    private final static HashMap<String, Object> data = new HashMap<>();

    public static Object get(String key) {
        if (!data.containsKey(key)) {
            throw new RuntimeException("This key cannot be retrieved: key does not exist.");
        }
        return data.get(key);
    }

    public static void put(String key, Object value) {
        if (data.containsKey(key)) {
            throw new RuntimeException("This key is already in use!");
        }
        data.put(key, value);
    }

    public static boolean smth() {
        return false;
    }

}
