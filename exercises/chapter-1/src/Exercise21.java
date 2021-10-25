import edu.princeton.cs.algs4.StdOut;

public class Exercise21 {

    public boolean find(LinkedList<String> stringList, String key) {
        for (String value : stringList) {
            if (value.equals(key)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Exercise21 findKey = new Exercise21();
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("ground control");
        stringList.add("to");
        stringList.add("major tom");

        StdOut.println(findKey.find(stringList, "major"));
    }
}
