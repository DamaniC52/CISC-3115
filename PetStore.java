//Name: Damani Chung
public class PetStore {

    public static void main(String[] args) {

        // pets created with the three argument constructor
        Pet pet1 = new Pet("Buddy", "Dog", 5);
        Pet pet2 = new Pet("Whiskers", "Cat", 3);
        Pet pet3 = new Pet("Polly", "Parrot", 2);

        Pet pet4 = new Pet("Rex", "Dog");
        Pet pet5 = new Pet("Fluffy", "Cat");

        pet1.displayInfo();
        pet2.displayInfo();
        pet3.displayInfo();
        pet4.displayInfo();
        pet5.displayInfo();
    }
}

class Pet {

    private String name;
    private String type;
    private int age;

    // constructor that sets all three fields
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Pet(String name, String type) {
        this(name, type, 0);
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Type: " + type + ", Age: " + age);
    }
}
