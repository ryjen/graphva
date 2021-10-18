package com.github.ryjen.graphva.heap.exceptions;

/**
 * Exception when heap reaches capacity
 */
public class HeapCapacityException extends RuntimeException {
    private static final String MESSAGE = "Heap at capacity";

    public HeapCapacityException() {
        super(MESSAGE);
    }

    public HeapCapacityException(Throwable throwable) {
        super(MESSAGE, throwable);
    }
}
