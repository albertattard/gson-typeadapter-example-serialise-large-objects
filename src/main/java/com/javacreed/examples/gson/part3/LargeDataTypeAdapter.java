package com.javacreed.examples.gson.part3;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LargeDataTypeAdapter extends TypeAdapter<LargeData> {

  @Override
  public LargeData read(final JsonReader in) throws IOException {
    throw new UnsupportedOperationException("Coming soon");
  }

  @Override
  public void write(final JsonWriter out, final LargeData data) throws IOException {
    out.beginObject();
    out.name("numbers");
    out.beginArray();
    for (final long number : data.getNumbers()) {
      out.value(number);
    }
    out.endArray();
    out.endObject();
  }
}
