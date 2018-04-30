package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException {
            String name = null;
            boolean isAccepted = false;
            while (!isAccepted) {
                Message output = new Message(MessageType.NAME_REQUEST);
                connection.send(output);
                Message input = null;
                try {
                    input = connection.receive();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (input.getType().equals(MessageType.USER_NAME)) {
                    name = input.getData();
                    if ((!name.isEmpty()) && (connectionMap.get(name) == null)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        isAccepted = true;
                    }
                }
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> entry: connectionMap.entrySet()){
                String name = entry.getKey();
                if (!userName.equals(name)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();
                if (MessageType.TEXT.equals(message.getType())) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else { ConsoleHelper.writeMessage("Not a message"); }
            }
        }

        public void run(){
            String name = null;
            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());
            }
            try(Connection connection = new Connection(socket)){
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);

            }catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                    ConsoleHelper.writeMessage("Remote connection closed successfully");
                }
            }
        }

    }

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> entry: connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Cannot send a message");
            }
        }
    }

    public static void main(String[] args){
        try(
                ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        )
        {
            ConsoleHelper.writeMessage("Server started!");
            while (true) {
                Socket incomeSocket = serverSocket.accept();
                new Handler(incomeSocket).start();
            }

        } catch (IOException e){
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}
