package GraphFramework;

import AirFreightApp.Location;
import AirFreightApp.Route;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Random;
import java.util.Set;

public class Graph {

    public Vertex[] vertices;
    public int verticesNo;
    public int edgeNo;
    boolean isDigraph;

    public Graph() {
    }

    public Graph(int verticesNo, int edgeNo) throws Exception {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        //makeGraph(verticesNo, edgeNo);
    }

    /*
     * makeGraph(): void
     * generates a random graph with a specified number of vertices and edges
     */
//==============================================================================================================
    public void makeGraph(int verticesNo, int edgeNo) throws Exception {
        //File newGraph = new File("./newGraph.txt");
        //PrintWriter write = new PrintWriter(newGraph);

        Random random = new Random();

        //generate random number 0 or 1
        int isDi = random.nextInt(2);
        //write.write(isDi+"\n");

        //if isDi =1 then true directed 
        // else then true undirected 
        isDigraph = isDi == 1;

        //If the graph is undirected, then we have double the number of edges
        if (!isDigraph) {
            //
            this.edgeNo = (edgeNo) * 2;

        } else {
            this.edgeNo = edgeNo;
        }

        vertices = new Vertex[verticesNo];
        for (int i = 0; i < verticesNo; i++) {
            Location vertex = createVertex(i + 1);
            vertices[i] = vertex;

        }
        // Create a variable to access verticesArray
        int idx = vertices.length - 1;

        // Initialize a flag to track if all vertices have been connected
        boolean connected = false;

        // Select the first source vertex staring from the last element in the array and decrement the idx
        Location sourceVertex = (Location) vertices[idx];
        idx--;

        // Generate edges and connect vertices
        for (int i = 0; i < edgeNo - 1; i++) {
            Location targetVertex = (Location) vertices[idx];

            //weight of each edge is a random integer between 1 and 20
            int weight = 1 + random.nextInt(20);
            // Add the edge to the graph connecting the target and source vertices with the generated weight
            addEdge(sourceVertex, targetVertex, weight);

            //print edge in the file
            //write.write("src  " + sourceVertex.label + "  trg  " + targetVertex.label + "  wht  " + weight + "\n");
            // Update the source vertex for the next iteration as the target vertex for the previous iterartion, to make sure graph is connected
            sourceVertex = targetVertex;

            idx--;

            //Check if all vertices have been connected or if the idx has reached its limit
            if (connected || idx < 0) {
                // Reset the idx  to select a new source vertex randomly that doesnt point to itself
                idx = random.nextInt(vertices.length);
                while (vertices[idx] == sourceVertex) {
                    idx = random.nextInt(vertices.length);
                }
                connected = true;
            }
        }
        // connect the first with the last vertex
        int weight = 1 + random.nextInt(20);
        addEdge((Location) vertices[vertices.length - 1], (Location) vertices[0], weight);
        //write.write("src  " + vertices[vertices.length - 1].label + "  trg  " + vertices[0].label + "  wht  " + weight + "\n");

        //write.flush();
    }
//==============================================================================================================
    public void readGraphFromFile(String fileName) throws Exception {
        // Create a new file
        File graphFile = new File("./graphFile.txt");

        // Create a scanner to read the file
        Scanner graphFileReader = new Scanner(graphFile);

        // if "digraph 1" then isDigraph= true, directed
        // if "digraph 0" then isDigraph= false, undirected
        String throw_digraph = graphFileReader.next();
        isDigraph = graphFileReader.next().equalsIgnoreCase("1");

        // read #verticies & #edges respectively
        verticesNo = graphFileReader.nextInt();

        edgeNo = graphFileReader.nextInt();

        if (!isDigraph) {
            edgeNo *= 2;
        }
        // initialize vertices arraylist with the given #verticies
        vertices = new Vertex[verticesNo];

        // start reading thegraph file
        while (graphFileReader.hasNextLine()) {
            
            // From each line read: Src Vertex, Trgt Vertex, weight
            String sourceVerexLebel = graphFileReader.next();
            String targetVerexLebel = graphFileReader.next();
            
            //convert the label of the Verex to int   
            int sourceLebel = fromCharToInt(sourceVerexLebel);
            int targetLebel = fromCharToInt(targetVerexLebel);
            
            
            //read the weight 
            int weight = graphFileReader.nextInt();
            
            // first, check if the Vertex already saved in the array of vertices
            Location checkLocation = check(sourceVerexLebel);
            
            //initialize source Vertex and target Vertex
            Location sourceVertex = null;
            Location targetVertex = null;

            //In the first iteration, the array of vertices is empty, so we must add the first Vertex.
            if (vertices.length == 0) {
                sourceVertex = addVertex(sourceLebel);
            } 
            
            else if (checkLocation == null) {
           //If the source Vertex does not exist in the array of vertices, then we add the Vertex
                sourceVertex = addVertex(sourceLebel);

            } else {
                //If the source Vertex exists, then we take it from the array
                sourceVertex = checkLocation;
            }
            //============================================================================================           
            
           //We do the same thing for the target Vertex
            checkLocation = check(targetVerexLebel);
            if (checkLocation == null) {
                targetVertex = addVertex(targetLebel);

            } else {
                targetVertex = checkLocation;
            }

            addEdge(sourceVertex, targetVertex, weight);

        }

    }
//===============================================================================================================
    /*
     * createEdge(): Edge
     * Create an edge that connects the source v to the target u with an edge of
     * weight w
     */
//==========================================================================================================
    public Route createEdge(Location v, Location u, int w) {
        Route newEdge = new Route(v, u, w);
        return newEdge;
    }
//=========================================================================================================
    /*
     * createVertex(): Vertex
     * Create a vertex with a label
     */
//=========================================================================================================
    public Location createVertex(int vnum) {
        Location newVertex = new Location(vnum);
        return newVertex;
    }
//========================================================================================================
    /*
     * addEdge(): Vertex
     * adds Edge e to Vertex v adjList
     */
//=======================================================================================================
    public void addEdge(Location v, Location u, int w) {
        // add edge from source to target 
        Route sourceLine = createEdge(v, u, w);
        v.adjList.add(sourceLine);

        if (!isDigraph) {
            // add edge from target to source 
            Route targetLine = createEdge(u, v, w);
            u.adjList.add(targetLine);
        }

    }
//=======================================================================================================
    public Location addVertex(int vnum) {

        Location V = createVertex(vnum);
        //decreases the vnum because the array is zero based
        vertices[vnum - 1] = V;

        return V;
    }
//=======================================================================================================
    public Location check(String label) {
       //Search in the array of vertices  
        for (int i = 0; i < vertices.length; i++) {
            if (((Location) vertices[i]) == null) {
                continue;
            }
            String s1 = ((Location) vertices[i]).city;
            if (((Location) vertices[i]).city.equalsIgnoreCase(label)) {
                return ((Location) vertices[i]);
            }
        }
        return null;
    }
//======================================================================================================
    public int fromCharToInt(String c) {
        // In ASCII code "A" is 65
        int x = c.charAt(0) - 65;
        return x + 1;
    }

}
