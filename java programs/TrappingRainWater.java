public class TrappingRainWater {
    public int trap(int[] height) {
        int n=height.length;

        int[] arrLeft=new int[n];
        int[] arrRight=new int[n];

        arrLeft[0]=height[0];
        for(int i=1;i<height.length;i++){
            arrLeft[i]=Math.max(arrLeft[i-1],height[i]);
        }
        arrRight[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            arrRight[i]=Math.max(arrRight[i+1],height[i]);
        }
        int trapped=0;
        for(int i=0;i<height.length;i++){
            trapped+=Math.min(arrLeft[i],arrRight[i])-height[i];
        }
        return trapped;
    }
}
