package com.example.threads_samsung_academy.Threads;

import static com.example.threads_samsung_academy.DATA.DATA.Ed2;
import static com.example.threads_samsung_academy.DATA.DATA.isEvenTurn2;
import static com.example.threads_samsung_academy.DATA.DATA.isEvenTurn3;
import static com.example.threads_samsung_academy.DATA.DATA.lock;
import static com.example.threads_samsung_academy.MainActivity.handler;

import android.os.Message;

public class Thread2 extends Thread {

    @Override
    public void run() {
        for (int j = 0; j < Ed2.length() + 1; j++) {
            synchronized (lock) {
                try {
                    while (isEvenTurn2 == 0) {

                        lock.wait();
                    }

                    if (j == Ed2.length() || Ed2.charAt(j) == ' ') {

                        Message msg = new Message();
                        msg.obj = ' ';
                        handler.sendMessage(msg);

                        isEvenTurn2 = 0;
                        isEvenTurn3 = 1;
                        lock.notifyAll();

                        Thread.sleep(1000);
                    } else {

                        Thread.sleep(200);

                        Message msg = new Message();
                        msg.obj = Ed2.charAt(j);
                        handler.sendMessage(msg);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

                }
            }
        }
    }
}