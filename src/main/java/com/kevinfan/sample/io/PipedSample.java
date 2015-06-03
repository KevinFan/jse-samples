/*
 * Copyright 2014 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package com.kevinfan.sample.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * PipedSample
 * 
 * @author Kevin Fan
 * @since 2014年8月18日 下午6:01:37
 */
public class PipedSample {
    public static void main(String[] args) throws Exception {
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        //writer
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        out.write(("no" + i + "\n").getBytes());
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        
        //reader
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                String line=null;
                try {
                    while((line= reader.readLine()) !=null){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
        }).start();
    }
}
