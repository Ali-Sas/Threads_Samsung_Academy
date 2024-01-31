package com.example.threads_samsung_academy.Threads;
import static com.example.threads_samsung_academy.DATA.DATA.Ed1;
import static com.example.threads_samsung_academy.DATA.DATA.isEvenTurn2;
import static com.example.threads_samsung_academy.DATA.DATA.isEvenTurn;
import static com.example.threads_samsung_academy.DATA.DATA.lock;
import static com.example.threads_samsung_academy.MainActivity.handler;

import android.os.Message;

public class Thread1 extends Thread {

    @Override
    public void run() {

        for (int j = 0; j < Ed1.length() + 1; j++) {
            synchronized (lock) {
                try {
                    while (isEvenTurn == 0) {

                        lock.wait();

                    }
                    if (j == Ed1.length() || Ed1.charAt(j) == ' ') {

                        Message msg = new Message();
                        msg.obj = ' ';
                        handler.sendMessage(msg);

                        isEvenTurn = 0;
                        isEvenTurn2 = 1;
                        lock.notifyAll();

                        Thread.sleep(1000);
                    } else {

                        Thread.sleep(200);

                        Message msg = new Message();
                        msg.obj = Ed1.charAt(j);
                        handler.sendMessage(msg);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

                }
            }
        }
    }
}