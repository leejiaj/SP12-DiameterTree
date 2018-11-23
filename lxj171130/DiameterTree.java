package lxj171130;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import rbk.BFSOO;
import rbk.Graph;
/**
 * @author Leejia James
 * @author Vishwanath D C
 * 
 * Short Project 12: BFS, Enumeration
 * Implementing the algorithm to find the diameter of a tree using the
 * algorithm that runs BFS twice
 * 
 * Ver 1.0: 2018/11/22
 */

import rbk.Graph.Vertex;

public class DiameterTree {

	/**
	 * Finding the diameter of the tree
	 * @param g
	 * @return diameter of the tree
	 */
	int diameter(Graph g) {
		
		Vertex s = null;
		for(Vertex u: g) {
			s = u;
			break;
		}
		
		// Running BFS from a random node as source
		BFSOO b = BFSOO.breadthFirstSearch(g, s);
		
		// finding farthest node from source
		Vertex max = null;
		int maxDistance = 0;
		for(Vertex u: g) {
			if(b.getDistance(u) > maxDistance) {
				maxDistance = b.getDistance(u);
				max = u;
			}
		}
		
		// running bfs from max as source
		BFSOO b1 = BFSOO.breadthFirstSearch(g, max);
		
		// finding distance of farthest node from max - diameter of tree
		maxDistance = 0;
		for(Vertex u: g) {
			if(b1.getDistance(u) > maxDistance) {
				maxDistance = b1.getDistance(u);
			}
		}
		return maxDistance;
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		String string = "10 9   1 2 2   1 3 3   2 4 5   2 5 4   4 8 1   3 6 -7   3 7 -1   7 9 -1   7 10 -1 1";
		Scanner in;
		// If there is a command line argument, use it as file from which
		// input is read, otherwise use input from string.
		in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
		// Read graph from input
	        Graph g = Graph.readGraph(in);


		g.printGraph(false);

		DiameterTree dt = new DiameterTree();
		System.out.println("Diameter of Tree: "+ dt.diameter(g));
		
	    }
	
}
