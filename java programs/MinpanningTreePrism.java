import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinpanningTreePrism {
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0],v=edge[1],w=edge[2];
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.weight-b.weight);
        boolean[] vis=new boolean[V];
        pq.add(new Pair(0, 0));

        int mstWeight = 0;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int w=pair.weight;
            int node=pair.node;


            if (vis[node]) continue; // Skip if already in MST
            vis[node] = true;
            mstWeight+=w;

            for (Pair p : adj.get(node)) {
                if (!vis[p.node]) {
                    pq.offer(new Pair(p.weight, p.node));
                }
            }
        }
        return mstWeight;
    }
    class Pair{
        int weight;
        int node;
        Pair(int weight,int node){
            this.weight=weight;
            this.node=node;
        }
    }
}


