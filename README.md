# Graphva

A graph implementation in Java.

## Graphs

- Generic data types for edges and vertices
- Directed, undirected graphs
- Adjacency list or matrix graph implementations
- Labeled edges and vertices with degrees
- Iteratable iterators
- Formatters (stdout or custom)
- In/out vertex degrees

## Heaps
- Dynamic array based heap implementation

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
```

## Iterating

```Java
// iterate all vertices
Iterable<String> it = graph.vertices();

// or iterate adjacent vertices
for (String vertex : graph.adjacent("Robot")) {
  System.out.println(vertex);
}

// iterate all edges
Iterable<Edge<Integer,String>> it = graph.edges();
// or iterate edges for a vertex
for (Edge<Integer,String>> edge : graph.edges("Robot")) {
  System.out.println(edge);
}
```

## Searching

Breadth or Depth first:

```Java
// Store the results as a list, could be a custom callback
List<String> result = new ArrayList<>();

// breadth first from Robot vertex
graph.bfs("Robot", result::add)

// depth first from Hello vertex (pre, post, reversePost)
graph.dfs("Hello", result::add, Ordering.Pre)

```

Dijkstra path:

```Java
// Store the result as a list, could be a custom callback
List<String> result = new ArrayList<>();

// Create the search for the graph
Dijkstra<Integer> path = new Dijkstra<>(graph, actual::add);

// start search from World vertex
path.search("World")

```

Topological sort:
```Java
TopologicalSort<Integer, String> sorter = new TopologicalSort<>(graph);

Collection<String> sorted = sorter.sort();
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

Other
=====

## [Trees](src/main/java/com/github/ryjen/graphva/graph/tree)

A disjointed set used to implement minimum spanning tree implementations.

```Java

Iterable<Edge<Integer, String>> minimum = new MinimumSpanningTree.Kruskals<>(graph).find();
Iterable<Edge<Integer, String>> actual = new MinimumSpanningTree.Prims<>(graph).find();

```

## [Heaps](src/main/java/com/github/ryjen/graphva/heap)

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

for (Integer i : heap) {
  System.out.println(i);
}

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


## [Permutations](src/main/java/com/github/ryjen/graphva/Permutation.java)

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

- `mvn test`: run unit tests
- `mvn package`: to build jar
- `mvn compile`: to compile
