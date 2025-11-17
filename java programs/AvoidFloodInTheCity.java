import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        Map<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            if(rains[i]==0){
                set.add(i);
            }
            else if(map.containsKey(rains[i])){
                int prevRainDay=map.get(rains[i]);
                Integer nextDryDay=set.higher(prevRainDay);
                if(nextDryDay==null){
                    return new int[]{};
                }
                result[nextDryDay]=rains[i];
                set.remove(nextDryDay);
                result[i]=-1;

            }else{
                result[i]=-1;
                map.put(rains[i],i);
            }

        }
        return result;
    }
    public static void main(String[] args){
        int[] rains={1,2,0,1,2};
        AvoidFloodInTheCity city=new AvoidFloodInTheCity();
        System.out.println(city.avoidFlood(rains));
    }
}
