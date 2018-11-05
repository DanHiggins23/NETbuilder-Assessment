import java.util.ArrayList;
import java.util.Arrays;

public class Family {
    ArrayList<Person> peopleList = new ArrayList<>();

    // Method to get person
    public Person findPerson(String name) {
        for (Person person:peopleList) {
            if (person.name.equals(name)) {
                return person;
            }
        }
        return null;
    }

    public boolean male(String name) {
        Person person =  findPerson(name);

        // Creates a new record if there isn't one matching the name
        // This also acts as validation - will only allow one person with the same name
        if (person == null) {
            person = new Person();
            person.name = name;
            person.gender = "male";
            peopleList.add(person);
            return true;
        } else if (!person.gender.equals("male")) {
            // Will return false if person is anything other than male
            return false;
        }
        return false;
    }

    public boolean female(String name) {
        Person person =  findPerson(name);

        if (person == null) {
            person = new Person();
            person.name = name;
            person.gender = "female";
            peopleList.add(person);
            return true;
        } else if (!person.gender.equals("female")) {
            // Will return false if person is anything other than female
            return false;
        }
        return false;
    }

    public boolean isMale(String name) {
        Person person =  findPerson(name);

        if (person.gender.equals("male")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFemale(String name) {
        Person person = findPerson(name);

        if (person.gender.equals("female")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setParent(String childName, String parentName) {
        Person child = findPerson(childName);
        Person parent = findPerson(parentName);

        // If child hasn't been created, create one
        if (child == null) {
            child = new Person();
            child.name = childName;
            child.gender = "undefined";
            peopleList.add(child);
        }

        // If parent hasn't been created, create one
        if (parent == null) {
            parent = new Person();
            parent.name = parentName;
            parent.gender = "undefined";
            peopleList.add(parent);
        }

        // Check if parent is male or female
        if (isMale(parentName)) {
            child.father = parent;
        } else if (isFemale(parentName)) {
            child.mother = parent;
        }

        parent.childrenList.add(child);
        child.parentsList.add(parent);

        return true;
    }

    public void getParents(String name) {
        // Create string array
        String[] outputArray1 = new String[2];
        int count = 0;

        for (Person person:findPerson(name).parentsList) {
            // Add item to array and output array items
            outputArray1[count] = person.name;
            count++;
        }

        // Sort array (does not provide support for parents that have the same name)
        String firstParent = outputArray1[0];
        String secondParent = outputArray1[1];

        // Get ascii code of first letter and second letter of name
        int asciiNum = Character.codePointAt(firstParent, 0);
        int asciiNum2 = Character.codePointAt(secondParent, 0);

        // If the ascii number is lower, they should be placed in the array first
        if (asciiNum < asciiNum2) {
            outputArray1[0] = firstParent;
            outputArray1[1] = secondParent;
        } else {
            outputArray1[0] = secondParent;
            outputArray1[1] = firstParent;
        }

        // Print string array all on one line
        System.out.println(Arrays.toString(outputArray1));
    }

    public void getChildren(String name) {
        // Get size of children array so I know how big to create the string array
        int arraySize = findPerson(name).childrenList.size();

        // Create string array
        String[] outputArray2 = new String[arraySize];
        int count = 0;

        for (Person person:findPerson(name).childrenList) {
            // Add item to array and output array items
            outputArray2[count] = person.name;
            count++;
        }

        // Print string array all on one line
        System.out.println(Arrays.toString(outputArray2));
    }
}
