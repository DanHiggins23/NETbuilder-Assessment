public class Main {
    public static void main(String[] args) {
        Family fam = new Family();
        fam.setParent("Frank", "Morgan"); // true
        fam.setParent("Frank", "Dylan"); // true
        fam.male("Dylan"); // true
        fam.setParent("Joy", "Frank"); // true
        fam.male("Frank"); // true
        fam.male("Morgan"); // false
        // (Morgan is a woman because she both is Frank's parent, but not his father)
        fam.setParent("July", "Morgan"); // true
        // (We know Joy is Frank's child, but we can't derive Joy's gender)
        fam.getChildren("Morgan"); // ["Frank", "July"]
        fam.setParent("Jennifer", "Morgan"); // true
        fam.getChildren("Morgan"); // ["Frank", "Jennifer", "July"]
        fam.getChildren("Dylan"); // ["Frank"]
        // (That is all we know for sure)
        fam.getParents("Frank"); // ["Dylan", "Morgan"]
        fam.setParent("Frank", "Frank"); // false
        // (It is impossible to be the parent of your parent)
    }
}


