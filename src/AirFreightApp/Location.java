/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;
import GraphFramework.Vertex;
/**
 *
 * @author hadee
 */
public class Location extends Vertex{
public String city;

    public Location(int label) {
       super(label);
       this.city = String.valueOf((char) ( (label-1) + 65));  
    }
//==========================================================================================    
  public String displayInfo() {
         return "loc. " + city+": city "+label;
    }
  
    
}
