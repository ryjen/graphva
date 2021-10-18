package com.github.ryjen.graphva.graph;

import com.github.ryjen.graphva.graph.matrix.AdjacencyMatrix;

/**
 * Runs the test cases with an adjacency matrix implementation
 */
public class AdjacencyMatrixTest extends GraphTest {

    @Override
    protected <E extends Comparable<E>, V extends Comparable<V>> Graphable<E, V> getImplementation() {
        return new AdjacencyMatrix<>();
    }
}
