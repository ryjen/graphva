package com.github.ryjen.graphva.graph.exceptions;

/**
 * Exception for an undesired cyclic or acyclic graph
 */
public class GraphCyclicException extends Exception {

    private static final String CYCLIC = "Graph is cyclic";
    private static final String ACYCLIC = "Graph is acyclic";

    public GraphCyclicException() {
        this(true);
    }

    public GraphCyclicException(Throwable throwable) {
        this(true, throwable);
    }

    public GraphCyclicException(boolean value) {
        super(value ? CYCLIC : ACYCLIC);
    }

    public GraphCyclicException(boolean value, Throwable throwable) {
        super(value ? CYCLIC : ACYCLIC, throwable);
    }
}
