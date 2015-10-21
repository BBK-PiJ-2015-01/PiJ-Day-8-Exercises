public class Exercise5 {

    public static void main(String[] args) {

        new Exercise5().exercise5_1Runner();
    }

    private void exercise5_1Runner() {

        System.out.println("String short hash: " + HashUtilities.shortHash("String".hashCode()));
        System.out.println("String short hash: " + HashUtilities.shortHash("Another string".hashCode()));
        System.out.println("Integer short hash: " + HashUtilities.shortHash(new Integer(44).hashCode()));
    }
}
