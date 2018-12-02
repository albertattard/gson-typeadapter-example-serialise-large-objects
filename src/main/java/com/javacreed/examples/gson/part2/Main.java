package com.javacreed.examples.gson.part2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
  public static void main(final String[] args) throws IOException {
    /* Configure GSON */
    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(LargeData.class, new LargeDataTypeAdapter());
    gsonBuilder.setPrettyPrinting();

    final Gson gson = gsonBuilder.create();

    final LargeData data = new LargeData();
    data.create(10485760);

    final String json = gson.toJson(data);

    final File dir = new File("target/part2");
    dir.mkdirs();

    try (PrintStream out = new PrintStream(new File(dir, "output.json"), "UTF-8")) {
      out.println(json);
    }

    System.out.println("Done");
  }
}
