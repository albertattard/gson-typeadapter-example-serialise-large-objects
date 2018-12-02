package com.javacreed.examples.gson.part4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
  public static void main(final String[] args) throws IOException {
    /* Configure GSON */
    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(LargeData.class, new LargeDataSerialiser());
    gsonBuilder.setPrettyPrinting();

    final Gson gson = gsonBuilder.create();

    final LargeData data = new LargeData();
    data.create(10485760);

    final File dir = new File("target/part4");
    dir.mkdirs();

    try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir,
                                                                                                      "output.json")),
                                                                        "UTF-8"))) {
      gson.toJson(data, out);
    }

    System.out.println("Done");
  }
}
