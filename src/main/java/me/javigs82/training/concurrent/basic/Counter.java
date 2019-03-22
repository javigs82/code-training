package me.javigs82.training.concurrent.basic;

class Counter {
    int count = 0;

    public synchronized void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
