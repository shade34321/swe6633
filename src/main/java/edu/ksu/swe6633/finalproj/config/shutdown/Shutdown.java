package edu.ksu.swe6633.finalproj.config.shutdown;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

import java.util.Set;
import java.util.concurrent.ExecutorService;

public class Shutdown implements AutoCloseable {

    private final Set<AutoCloseable> closeables;

    private final Set<ExecutorService> executors;

    @Inject
    Shutdown(Set<AutoCloseable> closeables, Set<ExecutorService> executors) {
        this.closeables = closeables;
        this.executors = executors;
    }
    public void close() throws Exception {
        for (ExecutorService executor : executors) {
            executor.shutdown();
        }

        for (AutoCloseable closeable : closeables) {
            closeable.close();
        }

        Set<ExecutorService> awaiting = Sets.newIdentityHashSet();
        awaiting.addAll(executors);
        while (!awaiting.isEmpty()) {
            for (ExecutorService executorService : awaiting) {
                if (executorService.isTerminated()) {
                    awaiting.remove(executorService);
                }
            }
        }
    }
}
