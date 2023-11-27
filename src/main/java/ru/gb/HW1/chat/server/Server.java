package ru.gb.HW1.chat.server;

public class Server implements ServerListener {
    boolean isServerWorking;
    private final ChatListener listener;

    public Server(ChatListener listener) {

        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start() {
        if (isServerWorking) {
            listener.messageReceive("Сервер уже работает\n");
        } else {
            isServerWorking = true;
            listener.messageReceive("Сервер успешно запущен\n");
        }
    }

    public void stop() {
        if (!isServerWorking) {
            listener.messageReceive("Сервер уже остановлен\n");
        } else {
            isServerWorking = false;
            listener.messageReceive("Сервер успешно остановлен\n");
        }
    }

    @Override
    public void onServerExecute(String command) {
        try {
            switch (command) {
                case "start":
                    start();
                    break;
                case "stop":
                    stop();
                    break;
            }
        } catch (RuntimeException e) {
            listener.messageReceive("Получена неизвестная команда от пользователя\n");
        }
    }
}
