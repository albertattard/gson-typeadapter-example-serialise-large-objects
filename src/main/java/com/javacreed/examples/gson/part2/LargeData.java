package com.javacreed.examples.gson.part2;

public class LargeData {

  private long[] numbers;

  public void create(final int length) {
    numbers = new long[length];
    for (int i = 0; i < length; i++) {
      numbers[i] = i;
    }
  }

  public long[] getNumbers() {
    return numbers;
  }
}
