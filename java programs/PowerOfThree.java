public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if (n == 0)
            return false;

        System.out.println(n);
        if(n%3!=0) return false;

        return isPowerOfThree(n/3);
    }
    public static void main(String[] args){
        PowerOfThree powerOfThree=new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(27));
    }
}
