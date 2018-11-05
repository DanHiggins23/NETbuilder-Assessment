import java.util.ArrayList;

public class Person {
    Person mother;
    Person father;
    String gender;
    String name;
    ArrayList<Person> childrenList = new ArrayList<>();
    ArrayList<Person> parentsList = new ArrayList<>(2);
}
