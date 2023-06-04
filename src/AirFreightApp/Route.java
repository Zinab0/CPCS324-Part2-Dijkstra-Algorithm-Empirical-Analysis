/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;


/**
 *
 * @author hadee
 */
public class Route extends Edge{
    
    public Route(Location source, Location target, int weight) {
        super(source, target, weight);
    }

     public void displayInfo() {
       
    }
}
