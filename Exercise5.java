public class Exercise5 {

    public static void main(String[] args) {

//        new Exercise5().exercise5_1Runner();
        new Exercise5().exercise5_2Runner();
    }

    private void exercise5_1Runner() {

        System.out.println("String short hash: " + HashUtilities.shortHash("String".hashCode()));
        System.out.println("String short hash: " + HashUtilities.shortHash("Another string".hashCode()));
        System.out.println("Integer short hash: " + HashUtilities.shortHash(new Integer(44).hashCode()));
    }

    private void exercise5_2Runner() {

        SimpleMap map5_2 = new IntegerToStringSimpleMap();
        //
        map5_2.put(533, "Original 533 position");
        System.out.println(map5_2.get(533));
        //
        map5_2.put(533, "New 533 position");
        System.out.println("Still '" + map5_2.get(533) + "' after another insert at same position");
        //
        System.out.println("Map is " + (map5_2.isEmpty() ? "EMPTY!" : "NOT empty!"));
        //
        map5_2.remove(533);
        System.out.println("Map is now " + (map5_2.isEmpty() ? "EMPTY!" : "NOT empty!"));

    }
}
