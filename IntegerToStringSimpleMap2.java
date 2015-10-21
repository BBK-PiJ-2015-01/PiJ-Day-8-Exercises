import java.util.Arrays;


public class IntegerToStringSimpleMap2 implements SimpleMap2 {

    private final int MAP_ARRAY_SIZE = 100;
    private DoubleLinkedStringList[] mapArray = new DoubleLinkedStringList[MAP_ARRAY_SIZE];

    @Override
    public String put(int key, String name) {

        if (key >= mapArray.length) {
            extendArrayTo(key);
        }
        if (mapArray[key] == null) {
            mapArray[key] = new DoubleLinkedStringList();
        }
        mapArray[key].add(name);
        return "Don't know what is required here";
    }

    @Override
    public String[] get(int key) {

        if (mapArray[key] == null) {
            return new String[0];
        }
        return mapArray[key].get();
    }

    @Override
    public void remove(int key, String name) {

        if (mapArray[key] != null) {
            mapArray[key].remove(name);
        }
    }

    @Override
    public boolean isEmpty() {

        for (DoubleLinkedStringList item : mapArray) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }

    //
    // private methods
    //
    private void extendArrayTo(int key) {

        int length = mapArray.length;
        if (key < length) {
            return;
        }
        double sizeToAdd = key - mapArray.length;
        double ceil =  Math.ceil(sizeToAdd / MAP_ARRAY_SIZE);
        double newSize = mapArray.length + MAP_ARRAY_SIZE * ceil;
        mapArray = Arrays.copyOf(mapArray, (int) newSize);
    }
}
