package com.example.datastructureplayground.dsa.graph

import java.util.PriorityQueue
import kotlin.math.min

fun main(){
    val graph = Graph(4)
    graph.createGraph()
    graph.printGraph()
    println("Depth First Search")
    graph.depthFirstSearch(0)
    println("Breadth First Search")
    graph.breadthFirstSearch(0)
    println("All Paths")
    graph.printAllPathsFromSourceToDestination(0,3)
    println("Cycle Detection code")
    val hasCycle = graph.cycleDetection()
    // The reason "No Cycle Detected" is printed even when "Cycle Detected" is printed
    // is because the `cycleDetection` function itself prints "Cycle Detected"
    // when a cycle is found and returns true. The main function then continues
    // its execution. If no cycle is found after checking all nodes, the `cycleDetection`
    // function will then print "No Cycle Detected" and return false.
    // The `println("No Cycle Detected")` inside the `cycleDetection` function
    // is only reached if the loop completes without finding any cycle.
    println("Topological Sort")
    graph.tropologicalSort()

    println("UnDirected Cyclic Graph")
    graph.unDirectedCyclic()

    println("Dijkstra Algorithm")
    graph.dijkstra(0)

    println("Bellman Ford Algorithm")
    graph.bellmanFord(0)

    println("Prim's Algorithm")
    graph.primeAlgorithm()

    println("Tarjan's Algorithm")
    graph.finDBridgeInGraph()

    println("Articulation Point")


    graph.getArticulationPoints()

}

data class Edge(val source: Int, val destination: Int, val weight: Int)

class Graph(vertices: Int) {
    private val adjacencyList: Array<MutableList<Edge>> = Array(vertices) { mutableListOf() }

    fun addEdge(source: Int, destination: Int, weight: Int) {
        val edge = Edge(source, destination, weight)
        adjacencyList[source].add(edge)
    }

    fun createGraph() {
        addEdge(0, 1, 5)
        addEdge(1, 2, 8)
        addEdge(0, 3, 2)
        addEdge(2, 3, 4)
    }

    fun printGraph() {
        for (i in adjacencyList.indices) {
            println("Vertex $i -> ${adjacencyList[i]}")
        }
    }

    /**
     * Performs a Depth-First Search (DFS) traversal of the graph starting from a given vertex.
     *
     * DFS explores as far as possible along each branch before backtracking.
     * It starts at the `startVertex`, explores one of its neighbors, then explores
     * a neighbor of that neighbor, and so on, until it reaches a vertex with no
     * unvisited neighbors. Then it backtracks and explores other branches.
     *
     * This implementation prints each visited vertex to the console as it's discovered.
     *
     * @param startVertex The vertex from which to begin the DFS traversal.
     *                    It's assumed that this vertex exists in the graph.
     */
    fun depthFirstSearch(startVertex: Int) {
        val visited = BooleanArray(adjacencyList.size)
        depthFirstSearchRecursive(startVertex, visited)
    }

    fun depthFirstSearchRecursive(vertex: Int, visited: BooleanArray) {
        visited[vertex] = true
        println(vertex)
        for (edge in adjacencyList[vertex]) {
            if (!visited[edge.destination]) {
                depthFirstSearchRecursive(edge.destination, visited)
            }
        }

    }

    /**
     * Performs a Breadth-First Search (BFS) traversal of the graph starting from a given vertex.
     *
     * BFS explores the graph layer by layer. It starts at the `startVertex`,
     * visits all its direct neighbors, then visits the neighbors of those neighbors,
     * and so on, until all reachable vertices have been visited.
     *
     * This implementation prints each visited vertex to the console.
     *
     * @param startVertex The vertex from which to begin the BFS traversal.
     *                    It's assumed that this vertex exists in the graph.
     */
    fun breadthFirstSearch(startVertex: Int) {
        val visited = BooleanArray(adjacencyList.size)
        val queue = ArrayDeque<Int>()
        visited[startVertex] = true
        queue.add(startVertex)
        while (queue.isNotEmpty()) {
            val currentVertex = queue.removeFirst()
            println(currentVertex)

            // Iterate over all neighbors of the current vertex
            for (edge in adjacencyList[currentVertex]) {
                // If a neighbor has not been visited yet
                if (!visited[edge.destination]) {
                    // Mark it as visited
                    visited[edge.destination] = true
                    // Add it to the queue to visit its neighbors later
                    queue.add(edge.destination)
                }
            }

        }
    }

    /**
     * Prints all possible paths from a given source vertex to a destination vertex in the graph.
     *
     * This function uses a recursive Depth-First Search (DFS) approach to explore
     * all paths. It keeps track of visited vertices in the current path to avoid cycles
     * and ensures that each path is unique. When a path reaches the destination,
     * it is printed to the console.
     *
     * @param source The starting vertex of the paths.
     * @param destination The ending vertex of the paths.
     */
    fun printAllPathsFromSourceToDestination(source: Int, destination: Int) {
        val visited = BooleanArray(adjacencyList.size) { false }
        val path = mutableListOf<Int>()
        printAllPathsFromSourceToDestinationRecursive(source, destination, visited, path)

    }

    private fun printAllPathsFromSourceToDestinationRecursive(
        source: Int,
        destination: Int,
        visited: BooleanArray,
        path: MutableList<Int>
    ) {
        if (source == destination) {
            println(path)
            return
        }
        visited[source] = true
        path.add(source)
        for (edge in adjacencyList[source]) {
            if (!visited[edge.destination]) {
                printAllPathsFromSourceToDestinationRecursive(
                    edge.destination,
                    destination,
                    visited,
                    path
                )
            }
        }
        path.removeAt(path.size - 1)
        visited[source] = false

    }

    fun tropologicalSort() {
        val visited = BooleanArray(adjacencyList.size) { false }
        val stack = ArrayDeque<Int>()
        for (source in adjacencyList.indices) {
            if (!visited[source]) {
                topologicalSortRecursive(source, visited, stack)
            }
        }
        while (stack.isNotEmpty()) {
            print("${ stack.removeLast() } ")
        }

    }

    private fun topologicalSortRecursive(
        source: Int, visited: BooleanArray, stack: ArrayDeque<Int>
    ) {
        visited[source] = true
        for (edge in adjacencyList[source]) {
            if (!visited[edge.destination]) {
                topologicalSortRecursive(edge.destination, visited, stack)
            }
        }
        stack.addFirst(source)

    }

    fun cycleDetection(): Boolean {
        val visited = BooleanArray(adjacencyList.size) { false }
        val recStack = BooleanArray(adjacencyList.size) { false }

        for (i in adjacencyList.indices) {
            if (!visited[i]) {
                if (cycleDetectionRecursive(i, visited, recStack)) {
                    println("Cycle Detected")
                    return true
                }
            }

        }
        println("No Cycle Detected")
        return false

    }

    private fun cycleDetectionRecursive(
        vertex: Int,
        visited: BooleanArray,
        recStack: BooleanArray
    ): Boolean {
        visited[vertex] = true
        recStack[vertex] = true
        for (edge in adjacencyList[vertex]) {
            if (!visited[edge.destination]) {
                if (cycleDetectionRecursive(edge.destination, visited, recStack)) {
                    return true
                }
            } else if (recStack[edge.destination]) {
                return true
            }
        }
        recStack[vertex] = false
        return false
    }

    fun unDirectedCyclic() {
        val visited = BooleanArray(adjacencyList.size) { false }
        for (i in adjacencyList.indices) {
            if (!visited[i]) {
                if (unDirectedCycleDetectionRecursive(i, -1, visited)) {
                    println("Cycle Detected")
                    return
                }
            }
        }
    }


    private fun unDirectedCycleDetectionRecursive(curr: Int, parent: Int, visited: BooleanArray) : Boolean {
        visited[curr] = true
        for (edge in adjacencyList[curr]) {
            if (!visited[edge.destination]) {
                if (unDirectedCycleDetectionRecursive(edge.destination,  edge.source,visited)) {
                    return true
                }
            } else if (edge.destination != parent) {
                return true
            }
        }
        return false
    }

    class Pair(val node : Int , val distance : Int) : Comparable<Pair>{

        override fun compareTo(other: Pair): Int {
            return this.distance - other.distance
        }
    }

    //implement dijkstra algorithm
    // not useful in negative weight
    fun dijkstra(source: Int) {
        val visited = BooleanArray(adjacencyList.size) { false }
        val distance = IntArray(adjacencyList.size) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair>()
        distance[source] = 0
        pq.add(Pair(source, 0))

        while (pq.isNotEmpty()){
            val current = pq.remove()
            if (!visited[current.node]){
                visited[current.node] = true
                for (edge in adjacencyList[current.node]){
                    val u = edge.source
                    val v = edge.destination
                    if(distance[u] + edge.weight < distance[v]){
                        distance[v] = distance[u] + edge.weight
                        pq.add(Pair(v, distance[v]))
                    }
                }
            }
        }

        // print distance queue
        for (i in distance.indices) {
            println("Distance from $source to $i is ${distance[i]}")
        }

    }

    //implement Bellman ford algorithm
    // not useful in negative weight cycle
    fun bellmanFord(source: Int) {
        val distance = IntArray(adjacencyList.size) { Int.MAX_VALUE }
        distance[source] = 0
        for (i in 1 until adjacencyList.size) {
            for (j in adjacencyList.indices) {
                for (edge in adjacencyList[j]) {
                    val u = edge.source
                    val v = edge.destination
                    if (distance[u] != Int.MAX_VALUE && distance[u] + edge.weight < distance[v]) {
                        distance[v] = distance[u] + edge.weight
                    }
                }
            }
        }

        for (i in distance.indices) {
            println("Distance from $source to $i is ${distance[i]}")
        }

    }

    //implement prim's algorithm minimum spanning tree
    fun primeAlgorithm(){
        val visited = BooleanArray(adjacencyList.size) { false }
        val pq = PriorityQueue<Pair>()
        var minCost = 0
        pq.add(Pair(0, 0))

        while (pq.isNotEmpty()){
            val current = pq.remove()
            visited[current.node] = true

            for (edge in adjacencyList[current.node]){
                val u = edge.source
                val v = edge.destination
                if(!visited[v]){
                    minCost += edge.weight
                    pq.add(Pair(v, edge.weight))
                }

            }
        }

        println("Minimum cost is $minCost")

    }
    // add tarjans algorithm
    fun finDBridgeInGraph(){
        val visited = BooleanArray(adjacencyList.size) { false }
        val low = IntArray(adjacencyList.size) { Int.MAX_VALUE }
        val disc = IntArray(adjacencyList.size) { Int.MAX_VALUE }
        val time = 0

        for (i in adjacencyList.indices) {
            if (!visited[i]) {
                finDBridgeInGraphRecursive(i, visited, low, disc, -1, time)
            }
        }

    }

    private fun finDBridgeInGraphRecursive(
        curr: Int,
        visited: BooleanArray,
        low: IntArray,
        disc: IntArray,
        parent: Int,
        time: Int
    ) {
        visited[curr] = true
        low[curr] = time+1
        disc[curr] = time+1

        for (edge in adjacencyList[curr]) {

            if(edge.destination == parent) continue

            if(!visited[edge.destination]){

                finDBridgeInGraphRecursive(edge.destination, visited, low, disc, curr, +1)
                low[curr] = min(low[curr], low[edge.destination])
                if(low[edge.destination] > disc[curr]){
                    println("Bridge found between ${curr} and ${edge.destination}")
                }

            }else{
                low[curr] = min(low[curr], disc[edge.destination])
            }
        }

    }

    // Assuming adjacencyList is a member of the class:
// class Graph {
//     private val adjacencyList: Array<MutableList<Edge>> = // ... initialization
//     private var time = 0 // Initialize time outside the recursive function


    private fun findArticulationPointsRecursive(
        currentNode: Int,
        visited: BooleanArray,
        discoveryTime: IntArray, // Renamed from disc
        lowLink: IntArray,       // Renamed from low
        parentNode: Int,
        articulationPoint: BooleanArray,
        time: Int
        // time is now a member variable or passed differently and incremented
    ) {
        visited[currentNode] = true

        discoveryTime[currentNode] = time+1
        lowLink[currentNode] = time+1
        var childrenInDfsTree = 0 // More descriptive name

        for (edge in adjacencyList[currentNode]) {
            val neighbor = edge.destination

            if (neighbor == parentNode) {
                continue
            }

            if (!visited[neighbor]) {
                childrenInDfsTree++
                findArticulationPointsRecursive(
                    neighbor,
                    visited,
                    discoveryTime,
                    lowLink,
                    currentNode,
                    articulationPoint,
                    time+1
                )

                // Check if the subtree rooted with 'neighbor' has a connection to
                // one of the ancestors of 'currentNode'
                lowLink[currentNode] = minOf(lowLink[currentNode], lowLink[neighbor])

                // currentNode is an articulation point in following cases:

                // (1) currentNode is root of DFS tree and has two or more children.
                // This is handled after the loop for the initial call.

                // (2) If currentNode is not root and low value of one of its children
                // is greater than discovery value of currentNode.
                if (parentNode != -1 && lowLink[neighbor] >= discoveryTime[currentNode]) {
                    articulationPoint[currentNode] = true
                }
            } else {
                // Update low value of currentNode for parent function calls.
                lowLink[currentNode] = minOf(lowLink[currentNode], discoveryTime[neighbor])
            }
        }

        // (1) Handle the root of the DFS tree case (initial call to the recursive function)
        if (parentNode == -1 && childrenInDfsTree > 1) {
            articulationPoint[currentNode] = true
        }
    }

    // Public wrapper function to start the process
    fun getArticulationPoints(): List<Int> {
        val numVertices = adjacencyList.size
        val visited = BooleanArray(numVertices)
        val discoveryTime = IntArray(numVertices)
        val lowLink = IntArray(numVertices)
        val articulationPoint = BooleanArray(numVertices)
        val parentNode = -1 // Parent of the starting node is -1 (or any invalid node index)
        var time = 0 // Reset time for each call to getArticulationPoints if it's a member

        // Call the recursive helper for all unvisited vertices (handles disconnected graphs)
        for (i in 0 until numVertices) {
            if (!visited[i]) {
                findArticulationPointsRecursive(i, visited, discoveryTime, lowLink, parentNode, articulationPoint,time)
            }
        }

        val result = mutableListOf<Int>()
        for (i in articulationPoint.indices) {
            if (articulationPoint[i]) {
                result.add(i)
                println("Articulation point found at vertex: $i") // Or just add to list
            }
        }
        return result
    }
// }


}