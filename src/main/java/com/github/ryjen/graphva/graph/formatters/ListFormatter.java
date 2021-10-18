package com.github.ryjen.graphva.graph.formatters;

import com.github.ryjen.graphva.graph.Graph;

import java.util.StringJoiner;

/**
 * Format a vertices in list format
 */
public class ListFormatter<E extends Comparable<E>, V extends Comparable<V>> implements Formatter {

    private final Graph<E, V> graph;

    public ListFormatter(Graph<E, V> graph) {
        assert graph != null;
        this.graph = graph;
    }

    @Override
    public void format(StringBuilder buf) {
        assert buf != null;
        for (V v : graph.vertices()) {
            buf.append(v).append(graph.isDirected() ? " → " : " : ");
            StringJoiner sj = new StringJoiner(", ");
            for (V a : graph.adjacent(v)) {
                sj.add(a.toString());
            }
            buf.append(sj).append('\n');
        }
    }
}
