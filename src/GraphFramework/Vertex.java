package GraphFramework;

import java.util.ArrayList;


/**
 *
 * @author hadee
 */
public class Vertex {

    public int label;
    public boolean isVisited=false;
    public ArrayList<Edge> adjList = new ArrayList<Edge>();
    

    public Vertex(int label) {
        this.label = label;
    }
//===================================================================================================
    public Vertex() {

    }
//===================================================================================================
    public String displayInfo() {
        //System.out.println("label=" + label);
        return "";
    }

}