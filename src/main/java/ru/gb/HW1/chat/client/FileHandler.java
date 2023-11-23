package ru.gb.HW1.chat.client;

import java.io.*;

public class FileHandler {

    public void saveToFile(String fileName, String userInfo) throws IOException {
        try (FileWriter writer = new FileWriter(fileName + ".txt", true)) {
            writer.write(userInfo);
            writer.flush();
        } catch (IOException e) {
            throw new IOException("Ошибка при попытке записи в файл");
        }
    }

    public String loadFromFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName + ".txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            throw new IOException("Не удалось загрузить историю логов из файла");
        }
        return stringBuilder.toString();
    }
}




