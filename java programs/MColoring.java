import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MColoring {

    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0],x=edge[1];
            graph.computeIfAbsent(u,k->new ArrayList<>())
                    .add(x);
            graph.computeIfAbsent(x,k->new ArrayList<>())
                    .add(u);
        }
        int[] vis=new int[v];
        return dfs(0,graph,m,v,vis);

    }

    private boolean dfs(int node,Map<Integer,List<Integer>> graph,int m,int v,int[] vis){
        if(node==v) return true;

        for(int c=1;c<=m;c++){
            if(isSafe(node,graph,c,vis)){
                vis[node]=c;
                if(dfs(node+1,graph,m,v,vis)) return true;
                vis[node]=0;//backtrack
            }
        }
        return false;
    }

    public boolean isSafe(int node ,Map<Integer,List<Integer>> graph,int color,int[] vis){
        for(int neigh:graph.getOrDefault(node,new ArrayList<>())){
            if(vis[neigh]==color){
                return false;
            }
        }
        return true;
    }
}

