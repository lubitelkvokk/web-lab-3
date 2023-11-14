package weblab3.util;

import com.google.gson.Gson;

public class GetGson {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
            return gson;
        } else {
            return gson;
        }
    }

}
