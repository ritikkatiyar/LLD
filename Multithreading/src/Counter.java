public class Counter extends Thread{
    int counter;

    public void incrementCounter(){
        counter++;
        System.out.println("counter is "+counter);
    }
    @Override
    public void run() {
        incrementCounter();
    }
}
