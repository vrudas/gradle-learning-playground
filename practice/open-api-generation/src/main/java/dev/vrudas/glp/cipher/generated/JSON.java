package dev.vrudas.glp.cipher.generated;

import com.google.gson.Gson;

public class JSON {

    private JSON() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static final Gson GSON_INSTANCE = new Gson();

    public static Gson getGson() {
        return GSON_INSTANCE;
    }
}
