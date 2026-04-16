You are a Lead Network Architect for a global telecommunications firm. 
Your company operates a series of Data Hubs connected by Fiber-Optic Cables.

A connection is defined as "Mission Critical" if its failure would result in at least one 
hub becoming completely isolated from the rest of its regional network, thereby splitting the
network into two or more disconnected segments.

Your objective is to perform a vulnerability scan on the current infrastructure and generate 
a report of all "Mission Critical" links.


Input Specifications:
--------------------
First Line: The first line provides two integers, H (Total Data Hubs) and L (Total Cables).
Second Line:The subsequent L lines each contain two integers, u and v,
            representing a direct fiber-optic link between Hub u and Hub v.

Output Specifications:
----------------------
List the pairs of hubs (u, v) that represent a Mission Critical link.
If the network is redundant enough that no single cable failure causes a split, leave the report empty.

Operational Parameters:
----------------------
1 <= H <= 10,0000 
0 <= L <= 100,000
Hub IDs are zero-indexed (0 to H-1).
The infrastructure may already be divided into multiple independent regional clusters.
Assume no redundant cables between the same two hubs and no hub connects back to itself.


Example Input 1:
----------------
5 5
1 0
0 2
2 1
0 3
3 4

Example Output 1:
----------------
3 4
0 3

Explanation:
-------------
In this architecture, the cluster of Hubs {0, 1, 2} is configured in a ring topology. 
If any single cable between them fails, data can still be rerouted through the other two.

However, the link between Hub 3 and Hub 4 is the only path to reach Hub 4. 
Severing it isolates Hub 4 entirely. 

Similarly, the link between Hub 0 and Hub 3 is the sole gateway connecting the {0, 1, 2} 
cluster to the {3, 4} segment.


import java.io.*;
import java.util.*;

class MissionCritical {
    private int V;
    private ArrayList<Integer>[] adj;
    private int time = 0;

    @SuppressWarnings("unchecked")
    MissionCritical(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    
    void findBridgesUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
        //Write Your Code Here
        
    }

    void reportCriticalLinks() {
       //Write Your Code Here
       
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int hubs = sc.nextInt();
        int links = sc.nextInt();
        
        MissionCritical network = new MissionCritical(hubs);
        
        for (int i = 0; i < links; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            network.addEdge(u, v);
        }

        network.reportCriticalLinks();
        }
}