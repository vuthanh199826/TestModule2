package Bai1.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface WorkWithFile<T> {
void writeToFileCSV(String path, List<T> list) throws IOException;
List<T> readFileCSV(String path) throws IOException;
}
