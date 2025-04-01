package JavaOopsPractices.Encapsulation;

public class person {
    private String name1; // Encapsulation we achive with help of "private" keyword

    private static String name2; // Encapsulation we achive with help of "private" keyword

    public void setName1(String nameA) { // To access with help of object
        name1 = nameA; // without this keyword
        System.out.println("successfully name updated");
    }

    public void setNameBythisKeywords(String name) { // To access with help of object
        this.name1 = name;
        System.out.println("successfully name updated");
    }

    public String getName() { // To access with help of object
        return name1;
    }

    public static void setNameForStaticVariable(String name) { // To access no need to create object
        name2 = name;
    }

    public static String getStaticName() {// To access no need to create object
        return name2;
    }

    public static void main(String[] args) {
        person p = new person(); // creating object of classs to access the entair variables and methods
        // p.setName2("mohan1");
        // p.setNameBythisKeywords("mohan2");
        // String updatedName=p.getName();
        // System.out.println(updatedName);

        
        setNameForStaticVariable("rameStatic1");  // we can directaly access 
        System.out.println("static name : --" + getStaticName());  // we can directaly access
    }

}
