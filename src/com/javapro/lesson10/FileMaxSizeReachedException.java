package com.javapro.lesson10;

import java.io.IOException;

public class FileMaxSizeReachedException extends RuntimeException {

  public FileMaxSizeReachedException(long size, int maxSize) {
    super(String.format(
        "Файл переполненный размер  файла %d , максимально допустимый размер файла %d", size,
        maxSize));
  }

}
