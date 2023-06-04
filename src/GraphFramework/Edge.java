package GraphFramework;

import AirFreightApp.Location;



public class Edge implements Comparable<Edge> {

    public int weight;
    public Vertex target;
    public Vertex source;
    public Vertex parent;

    public Edge(Location source, Location target, int weight) {
        this.target = target;
        this.source = source;
        this.weight = weight;

    }

//       @Override
//    public int compare(Edge o, Edge a) {
//        return o.weight - a.weight;
//      
//    }
    public void displayInfo() {
     
    }

    @Override
    public int compareTo(Edge edge) {

        return this.weight - edge.weight;
    }

}