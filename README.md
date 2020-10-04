# Algorithms and Data Structures Encyclopedia
**Work in progress...**

A encyclopedia of computer science algorithms and data structures.
## Available languages
- [Java](src/java)
- [Kotlin](src/kotlin)
- [Python](src/python)
- [Swift](src/swift)
- ...
## Algorithms
...

All the links refer to `Kotlin` implementations by default. If you prefer another language feel free to check the list of [available languages](#available-languages).

`B` - Base, `A` - Advanced
### By category
- **Graph**
    - `B` [Breadth-First Traversal](src/kotlin/sequential/graph/bfs) - BFS
    - `B` [Deapth-First Traversal](src/kotlin/sequential/graph/dfs) - DFS, recursive and iterative implementations.
    - `B` [Topological Sorting](src/kotlin/sequential/graph/topologicalsort) - based on DFS, recursive and iterative implementations.
    - `B` [Dijkstra's Algorithm](src/kotlin/sequential/graph/dijkstra) - greedy algorithm, finding shortest/fastest path to vertex.
- **Maze**
    - Generation
        - ...
    - Pathfinding
        - ...
- **Sorting**
    - `B` [Selection sort](src/kotlin/sorting/selectionsort)
    - `B` [Insertion sort](src/kotlin/sorting/insertionsort)
    - `B`, `A` [Shellsort](src/kotlin/sorting/shellsort) - including 14 gap sequences.
    - `B` [Merge sort](src/kotlin/sorting/mergesort)
    - `B` [Quicksort]() - including Lomuto's and Hoare's partition schemes.
    - `B` [Bubble sort](src/kotlin/sorting/bubblesort)
    - `B` [Radix sort](src/kotlin/sorting/radixsort)
- **Shuffling**
    - `B` [Fisher-Yates shuffling](src/kotlin/shuffling/fisheryates)
    - `A` [Sattolo shuffling](src/kotlin/shuffling/sattolo)
- ...

### By design paradigm
- **Greedy**
    - `B` [Dijkstra's Algorithm](src/kotlin/sequential/graph/dijkstra) - greedy algorithm, finding shortest/fastest path to vertex.
    - ...
- **Divide and conquer**
    - ...
- **Dynamic programming**
    - ...
    
    



## Data structures
- [Graph]()
- [Tree]()
    - `B` [Binary search tree]()
    - `A` [AVL tree]()
    - `A` [Red-Black tree]()
- [Heap]() - including **max** and **min** version.
- [Hash table]()
- ...
## Project structure
```
algorithms
└── _tools
└── src
    └── java
    └── kotlіn
    └── ...
    └── <language-name>
        └── _util
        └── parallel
        │   └── ...
        └── sequential
            └── graph
            └── sorting
            └── ...
            └── <algorithm-category>
                └── BUILD  <-- build target definition file
                └── <src-file(s)>
```
## How to build source code
All the source code in this project is built with Bazel build system. [Learn more about Bazel...](https://bazel.build/)

### Why Bazel?
Bazel provides a unified way of building projects with **multiple** programming languages. Bazel's glanularity allows to have many build targets where each contains only source code related to the specific algorithm or data structure.

### Install on macOS

```bash
brew install bazelisk
```
### Install on Windows, Linux and macOS
```bash
npm install -g @bazel/bazelisk
```
Learn more about [other installation options](https://docs.bazel.build/versions/master/install-bazelisk.html).
### Run algorithms
In order to run desired algorithm use the following command:
```bash
bazelisk run @kotlіn//sequential/graph/dijkstra:dijkstra
```
Where `@kotlin` can be replaced with any of the [available languages](#available-languages).
## Useful references
- ...