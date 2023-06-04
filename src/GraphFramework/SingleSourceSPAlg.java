/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import AirFreightApp.Location;
import AirFreightApp.Route;

/**
 *
 * @author hadee
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    public int[] distance;
    public String[] paths;
    int inf = Integer.MAX_VALUE;
    Location slLocation;
    int statindx;

    public SingleSourceSPAlg() {

    }

    public void computeDijkstraAlg(Graph graph, int i) {
        distance = new int[graph.vertices.length];// save the shortest distance cost from the start vertex to each vertex
        paths = new String[graph.vertices.length];// save the vertices path from the source to the vertex
        slLocation = (Location) graph.vertices[i];// save start vertex to used in the print 

        statindx = i;//save the index of the start vertex to used in the print 

        for (int j = 0; j < graph.vertices.length; j++) {
            //Initialize 
            graph.vertices[j].isVisited = false;
            distance[j] = inf;//Initialize all distances to max int
            paths[j] = null;
        }

        distance[i] = 0; //Start the algorithm by set the distance of the start vertex to zero 
        Location start = (Location) graph.vertices[i];
        paths[i] = start.displayInfo();

        // Loop Through the array of vertices
        for (int j = 0; j < graph.vertices.length - 1; j++) {

            int minDistIndx = minDistance(distance, graph);// save the vertex index with the smallest distance

            //If we get a vertex with infinity distance or do not have a path from the start vertex, then we end the loop,
            //because there is no path from the start vertex to other remaining vertices
            if (distance[minDistIndx] == inf || paths[minDistIndx] == null || graph.vertices[minDistIndx].isVisited == true) {
                break;
            }

            graph.vertices[minDistIndx].isVisited = true;// Mark the picked vertex as visited

            Location location = (Location) graph.vertices[minDistIndx];// vertex with smallest distance
            //loop through the adjList of the vertex
            for (int k = 0; k < location.adjList.size(); k++) {

                if (location.adjList.get(k).target.isVisited != true) {

                    // if the distance of the (vertex with smallest distance) + the weight betwen the source(vertex with smallest distance) and th target
                    //is smaller than distance of the target 
                    if (distance[minDistIndx] + location.adjList.get(k).weight < distance[location.adjList.get(k).target.label - 1]) {
                        //then update both distance array and path array
                        distance[location.adjList.get(k).target.label - 1] = distance[minDistIndx] + location.adjList.get(k).weight;

                        paths[location.adjList.get(k).target.label - 1] = paths[minDistIndx] + "-" + ((Location) location.adjList.get(k).target).displayInfo();

                    }

                }
            }// End of for loop through the adjList of the vertex

        } // End of for loop through the array of vertices

    }// End function
//==================================================================================================================
    public int minDistance(int[] distance, Graph graph) {
        // Find theindex of vertex with smallest distance
        int minindx = 0;
        int minDistance = inf;
        for (int i = 0; i < distance.length; i++) {
            if (graph.vertices[i].isVisited != true && distance[i] < minDistance) {
                minDistance = distance[i];
                minindx = i;
            }
        }
        return minindx;
    }
//================================================================================================================

    public void printResult(Graph graph) {
        System.out.println("The starting point location is " + slLocation.city);
        System.out.println("The routes from location " + slLocation.city + " to the rest of the locations are:");

        for (int i = 0; i < distance.length; i++) {

            if (i == statindx) {
                continue;
            }
            if (distance[i] == inf || paths[i] == null) {
                //there is no path from the start vertex to other remaining vertices
                String l = ((Location) graph.vertices[i]).displayInfo();
                System.out.println("*NO Path* From " + slLocation.displayInfo() + " to " + l);
            } else {
                System.out.println(paths[i] + " --- route length: " + distance[i]);
            }
        }
        System.out.println("==========================================================================\n");
    }
}
