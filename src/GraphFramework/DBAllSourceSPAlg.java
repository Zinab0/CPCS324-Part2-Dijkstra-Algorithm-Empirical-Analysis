/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

/**
 *
 * @author hadee
 */
public class DBAllSourceSPAlg extends ShortestPathAlgorithm{
    
  public void computeDijkstraBasedSPAlg(Graph graph, SingleSourceSPAlg singleSourceSPAlg, int r){
      
      for (int i = 0; i < graph.vertices.length; i++) {
         //send each vertex to start with
          singleSourceSPAlg.computeDijkstraAlg(graph, i);
          
          if(r==1)
          singleSourceSPAlg.printResult(graph);
      }
    }

    public DBAllSourceSPAlg() {
    }
  
}
