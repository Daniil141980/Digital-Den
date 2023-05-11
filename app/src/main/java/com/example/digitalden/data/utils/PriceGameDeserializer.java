package com.example.digitalden.data.utils;

import com.example.digitalden.data.models.PriceGame;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class PriceGameDeserializer implements JsonDeserializer<List<PriceGame>> {
    @Override
    public List<PriceGame> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        return object.keySet().stream().map(s -> {
            JsonObject innerObject = object.getAsJsonObject(s);
            return new PriceGame(Integer.parseInt(s), context.deserialize(innerObject.get("data"), PriceGame.Data.class), innerObject.get("success").getAsBoolean());
        }).collect(Collectors.toList());
    }
}
