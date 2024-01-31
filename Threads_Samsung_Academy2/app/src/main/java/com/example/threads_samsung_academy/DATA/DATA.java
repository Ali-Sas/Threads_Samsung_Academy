package com.example.threads_samsung_academy.DATA;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class DATA {
    public static final Object lock = new Object();
    public static String Ed1, Ed2, Ed3;
    public static int isEvenTurn = 1, isEvenTurn2 = 0, isEvenTurn3 = 0;
}
