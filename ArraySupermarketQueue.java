import java.util.Arrays;

public class ArraySupermarketQueue implements PersonQueue {

    private Person[] queue;

    private final int QUEUE_SEGMENT_SIZE = 2;
    //
    private final int NO_SLOTS = -1;
    private final int HEAD_OF_QUEUE = 0;
    
    public ArraySupermarketQueue() {
        
        queue = new Person[QUEUE_SEGMENT_SIZE];
    }

    private int getNextSlot() {

        int returnValue = NO_SLOTS;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == null) {
                returnValue = i;
                break;
            }
        }
        return returnValue;
    }

    private int extendQueue() {

        int returnValue = queue.length;
        int newSize = queue.length + QUEUE_SEGMENT_SIZE;
        queue = Arrays.copyOf(queue, newSize);
        return returnValue;
    }

    @Override
    public void insert(Person personToInsert) {

        if (personToInsert == null) {
            System.out.println("Missing person");
            return;
        }
        int insertPosition = getNextSlot();
        if (NO_SLOTS == insertPosition) {
            insertPosition = extendQueue();
        }
        queue[insertPosition] = personToInsert;
    }

    @Override
    public Person retrieve() {

        Person returnValue = queue[HEAD_OF_QUEUE];
        int size = size();
        if (size > 1) {
            System.arraycopy(queue, HEAD_OF_QUEUE + 1, queue, HEAD_OF_QUEUE, size-1);
            Arrays.fill(queue, size-1, queue.length-1, null);
        } else {
            queue[HEAD_OF_QUEUE] = null;
        }
        return returnValue;
    }

    @Override
    public int size() {
        
        int nextSlot = getNextSlot();
        return nextSlot == this.NO_SLOTS ? queue.length : nextSlot;
    }

}
