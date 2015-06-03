package com.kevinfan.sample.io.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9988);
            System.out.println("listen on 9988...");

            while (!Thread.currentThread().isInterrupted()) {
                final Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        handleRequest(socket);
                    } catch (Exception e) {

                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static void handleRequest(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        writer.append("Welcom to my echo... quit with empty input ..");
        writer.newLine();
        writer.flush();

        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                writer.append("Bye bye!\n").flush();
                break;
            } else {
                writer.append(line);
                writer.newLine();
            }

            writer.flush();
        }

        in.close();
        out.close();
    }
}
