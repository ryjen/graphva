# Graphva: a graph implementation in Java

## Graphs

- Generic directed, undirected graphs.
- Adjacency list or matrix graph implementations.
- labeled edges and vertices with degrees
- iterators
- formatters (stdout or custom)

## Heaps
- Dynamic array based heap implementation.

## Trees

- Disjointed sets
- Minimum spanning tree

## Algorithms
- Breadth first search 
- Depth first search 
- Dijkstra search
- Permutations
- Topological sort
- Kruskals minimum spanning tree
- Prims minimum spanning tree



[Graphs](src/main/java/com/github/ryjen/graphva/graph)
======

## Adjacency List and Matrix implementations

```Java
Graphable impl = new AdjacencyList()
Graphable impl = new AdjacencyMatrix()
```

## Creating

```Java
bool directed = false;

Graph<Integer,String> graph = Graph<>(impl, directed);

// add some vertices

graph.addVertices("Hello", "World", "Robot", "Unnecessary", "Point");

// add some edges between vertices
        
graph.addEdge("World", "Robot", 1);

graph.addEdge("Hello", "Point", 2);

// iterate adjacent verticies
Iterable<String> it = graph.adjacent("Robot");
```

## Default formatters

```Java
// print as a symbol matrix
System.out.println(graph.toString(new SymbolFormatter<>(graph)));

/*
 * OUTPUT:
 *             │ Hello       World       Robot       Unnecessary Point       
 * ────────────┼─────────────────────────────────────────────────────────────
 * Hello       │ ○           ○           ○           ○           ●           
 * World       │ ○           ○           ●           ○           ○           
 * Robot       │ ○           ●           ○           ○           ○           
 * Unnecessary │ ○           ○           ○           ○           ○           
 * Point       │ ●           ○           ○           ○           ○           
 *
 */
```

```Java
// print as a edge label matrix
System.out.println(graph.toString(new LabelFormatter<>(graph)));

/*
 * OUTPUT:
 *             │ Hello       World       Robot       Unnecessary Point       
 * ────────────┼─────────────────────────────────────────────────────────────
 * Hello       │ ○           ○           ○           ○           2           
 * World       │ ○           ○           1           ○           ○           
 * Robot       │ ○           1           ○           ○           ○           
 * Unnecessary │ ○           ○           ○           ○           ○           
 * Point       │ 2           ○           ○           ○           ○           
 *
 */
```

[Trees](src/main/java/com/github/ryjen/graphva/graph/tree)
=====

A disjointed set used to implement minimum spanning tree implementations.

```Java

Iterable<Edge<Integer, String>> minimum = new MinimumSpanningTree.Kruskals<>(graph).find();
Iterable<Edge<Integer, String>> actual = new MinimumSpanningTree.Prims<>(graph).find();

```

[Heaps](src/main/java/com/github/ryjen/graphva/heap)
=====

```Java
// create a max heap with capacity of 5
// could also be a MinHeap<>(5) for reverse order output

Heap<Integer> heap = new MaxHeap<>(5);

// offer values to the heap
assert heap.offer(3);
assert heap.offer(8);
assert heap.offer(1);
assert heap.offer(4);
assert heap.offer(10);

// we've reach capacity and this value is not greater than the top
assert !heap.offer(7);

// however this value is greater
assert heap.offer(13);

while (!heap.isEmpty()) {
	System.out.println(heap.remove());
}

/*
 * OUTPUT:
 * 13
 * 10
 * 8
 * 4
 * 3
 */
```


[Permutations](src/main/java/com/github/ryjen/graphva/Permutation.java)
============

```Java

// create an array of items
List<Character> items = Arrays.asList('A', 'B', 'C');

// find the permutations of the array
Permutation<Character> permutations = Permutation.generate(items);

// print the result
for(List<Character> perm : permutations) {
	for(Character ch : perm) {
		System.out.printf("%c ", ch);
	}
	System.out.println();
}

/*
 * OUTPUT:
 * C B A
 * B C A
 * B A C 
 * C A B
 * A C B
 * A B C
 */

```

Setup
=====

use maven or import maven project
