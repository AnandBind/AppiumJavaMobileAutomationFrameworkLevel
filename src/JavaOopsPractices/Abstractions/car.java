package JavaOopsPractices.Abstractions;

public class car extends vehicals {

    @Override
    void start() {
       System.out.println("car is stating");
    }

    public static void main(String [] args){
        car c=new car();
        c.start();
    }
}
