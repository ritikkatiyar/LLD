public class ThreadCount implements Runnable{
    Counter counter;
    ThreadCount(Counter counter){
        this.counter=counter;
    }
    @Override
    public void run() {
        counter.incrementCounter();
    }
}
