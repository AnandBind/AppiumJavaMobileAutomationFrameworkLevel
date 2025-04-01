package JavaOopsPractices.HeapMemory;

public class test {

    static car c; // static variable(stored in method area,but object in heap)

    public static void createCar(){
        c=new car(); // store in heap area
        c.name="hero";
    }

    public static void main(String[] args){
        createCar();// method completes,but object still exists;
        System.out.println(c.name);
    }

}
