package com.javacreed.examples.gson.part4;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LargeDataSerialiser implements JsonSerializer<LargeData> {

  @Override
  public JsonElement serialize(final LargeData data, final Type typeOfSrc, final JsonSerializationContext context) {
    final JsonArray jsonNumbers = new JsonArray();
    for (final long number : data.getNumbers()) {
      jsonNumbers.add(new JsonPrimitive(number));
    }

    final JsonObject jsonObject = new JsonObject();
    jsonObject.add("numbers", jsonNumbers);
    return jsonObject;
  }
}
