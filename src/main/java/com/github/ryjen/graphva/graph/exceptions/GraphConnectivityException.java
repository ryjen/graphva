package com.github.ryjen.graphva.graph.exceptions;

/**
 * Exception for an undesired connected or disconnected graph
 */
public class GraphConnectivityException extends Exception {

    private static final String CONNECTED = "Graph is connected";
    private static final String DISCONNECTED = "Graph is disconnected";

    public GraphConnectivityException() {
        this(true);
    }

    public GraphConnectivityException(Throwable throwable) {
        this(true, throwable);
    }

    public GraphConnectivityException(boolean connected) {
        super(connected ? CONNECTED : DISCONNECTED);
    }

    public GraphConnectivityException(boolean connected, Throwable throwable) {
        super(connected ? CONNECTED : DISCONNECTED, throwable);
    }
}
