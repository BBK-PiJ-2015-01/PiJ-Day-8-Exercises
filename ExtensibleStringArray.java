import java.util.Arrays;

public class ExtensibleStringArray {

    private final int ARRAY_SEGMENT_SIZE = 100;
    private String[] array = null;

    private int index = 0;

    public void add(String value) {

        if (array == null) {
            array = new String[ARRAY_SEGMENT_SIZE];
        }
        if (index + 1 >= array.length) {
            array = Arrays.copyOf(array, array.length + ARRAY_SEGMENT_SIZE);
        }
        array[index++] = value;
    }
    
    public String[] getArray() {
        return Arrays.copyOf(array, index);
    }
}
