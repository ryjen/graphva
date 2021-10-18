package com.github.ryjen.graphva.graph.formatters;

/**
 * interface for formatting a graph
 */
public interface Formatter {

    /**
     * formats an object to a buffer
     *
     * @param buf the buffer to write to
     */
    void format(StringBuilder buf);
}
