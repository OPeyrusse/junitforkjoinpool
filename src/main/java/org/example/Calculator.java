package org.example;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {
    static final AtomicInteger COUNTER = new AtomicInteger(0);

    private static final ForkJoinPool POOL = new ForkJoinPool(2);

    public int doubleIntWithTask(int a) throws ExecutionException, InterruptedException {
        return doubler(new DoublerTask(a));
    }

    public int doubleIntWithCompleter(int a) throws ExecutionException, InterruptedException {
        return doubler(new DoublerCompleter(a));
    }

    private int doubler(final ForkJoinTask<Integer> task) throws ExecutionException, InterruptedException {
        final var count = COUNTER.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " starting a new test. Running: " + count);
        if (count > 10) {
            System.out.println("Too many tests running in parallel: " + count);
            // In case of failure, cancel the whole project here
            // Chosen mode as it is less tedious than cancelling each of the future test to run in case of an error
            System.exit(1);
        }

        try {
            POOL.submit(task);
            return task.get();
        } finally {
            COUNTER.decrementAndGet();
            System.out.println(Thread.currentThread().getName() + " completed a test");
        }
    }

    static class DoublerTask extends RecursiveTask<Integer> {
        final int a;
        DoublerTask(final int a) {
            this.a = a;
        }

        protected Integer compute() {
            try {
                TimeUnit.SECONDS.sleep(10);
                return 2 * this.a;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }

    static class DoublerCompleter extends CountedCompleter<Integer> {
        final int a;
        int result;
        DoublerCompleter(final int a) {
            this.a = a;
        }

        public void compute() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                this.result = 2 * this.a;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("External interruption", e);
            }
            tryComplete();
        }

        @Override
        public Integer getRawResult() {
            return this.result;
        }
    }
}
