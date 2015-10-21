public class Exercise5 {

    public static void main(String[] args) {

//        new Exercise5().exercise5_1Runner();
//        new Exercise5().exercise5_2Runner();
        new Exercise5().exercise5_3Runner();
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

    private void exercise5_3Runner() {

        SimpleMap2 map5_3 = new IntegerToStringSimpleMap2();
        //
        map5_3.put(66, "66: first item position");
        map5_3.put(66, "66: second item position");
        map5_3.put(66, "66: third item position");
        map5_3.put(66, "66: fourth item position");

        String[] values = map5_3.get(66);
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("\n Perform delete \n");
        map5_3.remove(66, "66: third item position");
        values = map5_3.get(66);
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("\n Check is empty \n");

        System.out.println("Map is " + (map5_3.isEmpty() ? "EMPTY!" : "NOT empty!"));

        for (int i = 0; i < 200; i++) {
            map5_3.put(99, "99: position " + i);
        }
        values = map5_3.get(99);
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("\n Add a high key \n");

        map5_3.put(2015, "2015: first item position");
        
        values = map5_3.get(2015);
        for (String value : values) {
            System.out.println(value);
        }
    }
}
