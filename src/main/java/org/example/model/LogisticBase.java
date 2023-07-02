package org.example.model;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class LogisticBase {
    private static LogisticBase instance;
    private List<Terminal> terminals;
    private Semaphore semaphore;
    private Lock lock;

    public static LogisticBase getInstance() {
        if (instance == null) {
            instance = new LogisticBase();
        }
        return  instance;
    }

    public void process(Truck truck) throws InterruptedException {
        semaphore.acquire();
        lock.lock();
        try {
            //todo 0 поставил как заглушку пока, потом разберусь исправлю
            Terminal terminal = terminals.get(0);
            terminal.process(truck);
        } finally {
            semaphore.release();
            lock.unlock();
        }
    }
}
