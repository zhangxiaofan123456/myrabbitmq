package com.heida.main;

import com.heida.producer.Producer;

public class MainThread {
    public static void main(String[] args) {
            new Thread(new Producer()).start();
    }
}
