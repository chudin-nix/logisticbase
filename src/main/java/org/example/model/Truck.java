package org.example.model;

public class Truck implements Runnable {
    private int id;
    private boolean loaded;

    public Truck() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public int getId() {
        return id;
    }

    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public void run() {
        LogisticBase logisticBase = LogisticBase.getInstance();
        try {
            logisticBase.process(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
