package com.github.ryjen.graphva.graph.matrix;

import com.github.ryjen.graphva.graph.model.Edge;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates edges in a graph
 */
class EdgeIterator<E extends Comparable<E>, V extends Comparable<V>> implements Iterator<Edge<E, V>>, Iterable<Edge<E, V>> {

    private final AdjacencyMatrix<E, V> graph;
    private int row;
    private int col;

    EdgeIterator(AdjacencyMatrix<E, V> graph) {
        assert graph != null;
        this.graph = graph;
        this.row = 0;
        this.col = 0;
    }

    @Override
    public Iterator<Edge<E, V>> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        while (row < graph.size()) {
            while (col < graph.size()) {
                if (graph.isEdgeByRowColumn(row, col)) {
                    return true;
                }
                col++;
            }
            row++;
            col = 0;
        }
        return false;
    }

    @Override
    public Edge<E, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return graph.getEdgeByIndices(row, col++);

    }
}
