package com.kevinfan.sample.io.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioEchoServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        System.out.println("listening on 9999...");
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor(sk));

        while (!Thread.currentThread().isInterrupted()) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectedKeys) {
                dispatch(selectionKey);
            }
            selectedKeys.clear();
        }

        serverSocketChannel.close();
        selector.close();
    }

    /**
     * @param selectionKey
     */
    private static void dispatch(SelectionKey selectionKey) {
        Runnable runnable = (Runnable) selectionKey.attachment();
        if (runnable != null) {
            new Thread(runnable).start();
        }
    }

    public static class Acceptor implements Runnable {
        private final SelectionKey sk;

        public Acceptor(SelectionKey sk) {
            super();
            this.sk = sk;

        }

        @Override
        public void run() {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) sk.channel();
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                SelectionKey selectionKey = socketChannel.register(sk.selector(), SelectionKey.OP_READ
                        | SelectionKey.OP_WRITE, new Handler(sk, socketChannel));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static class Handler implements Runnable {
        private final SelectionKey sk;
        private final SocketChannel socketChannel;
        private final ByteBuffer    inBuf  = ByteBuffer.allocate(1024);
        private final ByteBuffer    outBuf = ByteBuffer.allocate(1024);

        public Handler(Selector selector, SocketChannel socketChannel) {
            super();
            this.selector = selector;
            this.socketChannel = socketChannel;
            try {
                socketChannel.configureBlocking(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            if (sk.isReadable()) {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (socketChannel.read(inBuf) > 0) {
                        sb.append(inBuf.asCharBuffer().flip().toString());
                        inBuf.clear();
                    }

                    System.out.println("<echo>: " + sb.toString());
                } catch (IOException e) {
                }
            } else if (sk.isWritable()) {

            }
        }

    }
}
