import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
        public int[] dijkstra(int V, int[][] edges, int src) {
            // code here


            List<List<Pair>> adj=new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] e:edges){
                int u=e[0],v=e[1],w=e[2];
                adj.get(u).add(new Pair(w,v));
                adj.get(v).add(new Pair(w,u));
            }


            int[] dist=new int[V];
            for(int i=0;i<V;i++) dist[i]=(int)(1e9);

            PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x, y)->
                    x.distance-y.distance
            );
            //System.out.print(adj);

            dist[src]=0;
            pq.add(new Pair(0,src));

            while(pq.size()!=0){
                int d=pq.peek().distance;
                int node=pq.peek().node;

                pq.remove();
                if (d > dist[node]) continue; // skip outdated entry

                for(Pair p:adj.get(node)){
                    int newDist=d+p.distance;
                    if(newDist<dist[p.node]){
                        dist[p.node]=newDist;
                        pq.add(new Pair(newDist,p.node));
                    }
                }
            }
            return dist;
        }
    class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

    }
}
