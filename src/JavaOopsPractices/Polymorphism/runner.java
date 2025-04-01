package JavaOopsPractices.Polymorphism;

public class runner {
    
    public static void main(String [] args){
        methodoverloading mol=new methodoverloading();
        int sumOfTreeDigit=mol.add(2,3,4);
        int sumOfTwoDigit=mol.add(12,3 );
        System.out.println("sum of three digint:- "+sumOfTreeDigit);
        System.out.println("sum of two digint:- "+sumOfTwoDigit);
    }

}
