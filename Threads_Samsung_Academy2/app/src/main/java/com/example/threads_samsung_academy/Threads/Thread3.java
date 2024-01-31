package com.example.threads_samsung_academy.Threads;

import static com.example.threads_samsung_academy.DATA.DATA.Ed3;
import static com.example.threads_samsung_academy.DATA.DATA.isEvenTurn3;
import static com.example.threads_samsung_academy.DATA.DATA.isEvenTurn;
import static com.example.threads_samsung_academy.DATA.DATA.lock;
import static com.example.threads_samsung_academy.MainActivity.handler;

import android.os.Message;

public class Thread3 extends Thread {

    @Override
    public void run() {
        for (int j = 0; j < Ed3.length() + 1; j++) {
            synchronized (lock) {
                try {
                    while (isEvenTurn3 == 0) {

                        lock.wait();
                    }

                    if (j == Ed3.length() || Ed3.charAt(j) == ' ') {

                        Message msg = new Message();
                        msg.obj = ' ';
                        handler.sendMessage(msg);

                        isEvenTurn3 = 0;
                        isEvenTurn = 1;
                        lock.notifyAll();

                        Thread.sleep(1000);
                    } else {

                        Thread.sleep(200);

                        Message msg = new Message();
                        msg.obj = Ed3.charAt(j);
                        handler.sendMessage(msg);

                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

                }
            }
        }
    }
}