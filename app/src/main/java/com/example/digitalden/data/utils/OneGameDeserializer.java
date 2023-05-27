package com.example.digitalden.data.utils;

import com.example.digitalden.data.models.OneGame;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class OneGameDeserializer implements JsonDeserializer<List<OneGame>> {
    @Override
    public List<OneGame> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        return object.keySet().stream().map(s -> {
            JsonObject innerObject = object.getAsJsonObject(s);
            return new OneGame(Integer.parseInt(s), context.deserialize(innerObject.get("data"), OneGame.Data.class), innerObject.get("success").getAsBoolean());
        }).collect(Collectors.toList());
    }
}
