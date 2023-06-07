# Dijkstra Algorithm Empirical Analysis
## Intoduction
Dijkstra's algorithm is a greedy algorithm for finding the shortest paths between nodes in a weighted graph. It works by iteratively adding the node with the shortest known distance to a set of visited nodes. The algorithm terminates when all nodes have been visited.
for more more detail, refer to the [project report](./CPCS324-Project-Part#2).
## Purpose
The purpose of this study was to compare the theoretical time efficiency of Dijkstra's algorithm to its empirical time efficiency.

## Study Design
The study used five randomly generated graphs with varying numbers of nodes and edges. The empirical time efficiency of Dijkstra's algorithm was measured by running the algorithm on each graph and recording the total time it took to find the shortest paths between all nodes.

### Characteristics of The Input Sample
The algorithm will be put to the test using graphs that were constructed at random, where n stands for the number of nodes and m for the number of edges:
- n = 2000  m = 10000
- n = 3000  m = 15000
- n = 4000  m = 20000
- n = 5000  m = 25000
- n = 6000  m = 3000

## Results
After computeing empirical runtime and the expected theoretical time.
The results showed that the empirical time efficiency of Dijkstra's algorithm was nearly the same as the expected theoretical time efficiency.
![image](https://github.com/Zinab0/CPCS324-Part2-Dijkstra-Algorithm-Empirical-Analysis/assets/77127247/1aaacd15-d507-4491-a065-9ef4767f462b)

## Sample Output Screenshots
![image](https://github.com/Zinab0/CPCS324-Part2-Dijkstra-Algorithm-Empirical-Analysis/assets/77127247/cfc19b05-9b25-46b6-9bca-9adf1dbe9f4d)


## Conclusion
The results of this study suggest that Dijkstra's algorithm is a very efficient algorithm for finding the shortest paths between nodes in a weighted graph. The algorithm is easy to implement and can be used to solve a wide variety of problems.

## References
Levitin, A. (2011). Introduction to the Design and Analysis of Algorithms. Pearson Higher Ed.



