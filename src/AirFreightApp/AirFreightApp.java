/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.DBAllSourceSPAlg;
import GraphFramework.SingleSourceSPAlg;
import java.util.Scanner;

/**
 *
 * @author hadee
 */
public class AirFreightApp {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("Select the Requirement 1 or 2 or 0 to exit:");
        int r = input.nextInt();
        SingleSourceSPAlg singleSourceSPAlg = new SingleSourceSPAlg();
        DBAllSourceSPAlg dBAllSourceSPAlg = new DBAllSourceSPAlg();
        while (r != 0) {

            AFRouteMap aFRouteMap = new AFRouteMap();

            if (r == 1) {
                Requirement_1(aFRouteMap, r, singleSourceSPAlg, dBAllSourceSPAlg);
            } else if (r == 2) {
                Requirement_2(aFRouteMap, r, singleSourceSPAlg, dBAllSourceSPAlg);
            }

            System.out.print("Select the Requirement 1 or 2 (Enter 0 to exit) :");
            r = input.nextInt();
        }

    }

    public static void Requirement_1(AFRouteMap aFRouteMap, int r, SingleSourceSPAlg singleSourceSPAlg, DBAllSourceSPAlg dBAllSourceSPAlg) throws Exception {
        System.out.println("*******************************************Requirment 1*******************************************");
        aFRouteMap.readGraphFromFile("file");
        dBAllSourceSPAlg.computeDijkstraBasedSPAlg(aFRouteMap, singleSourceSPAlg, r);
    }

    public static void Requirement_2(AFRouteMap aFRouteMap, int r, SingleSourceSPAlg singleSourceSPAlg, DBAllSourceSPAlg dBAllSourceSPAlg) throws Exception {
        System.out.println("*******************************************Requirment 2*******************************************");
        System.out.println("");
        System.out.print("Enter vertices Number: ");
        int verticesNum = input.nextInt();
        System.out.print("Enter edges Number: ");
        int edgesNum = input.nextInt();
        System.out.println("");

        aFRouteMap.makeGraph(verticesNum, edgesNum);

        long dijkstraStartTime = System.currentTimeMillis();//time code
        dBAllSourceSPAlg.computeDijkstraBasedSPAlg(aFRouteMap, singleSourceSPAlg, r);
        long dijkstraEndTime = System.currentTimeMillis();// end time code
         System.out.println("Kruskal Alogrithm Execution Time: " + (dijkstraEndTime - dijkstraStartTime) + " ms \n");

    }
}
