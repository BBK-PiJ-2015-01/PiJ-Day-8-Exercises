import java.util.Arrays;

public class PriorityArrayPersonQueue implements PersonQueue {

	private final int FIRST_PRIORITY_AGE = 65;
	private final int SECOND_PRIORITY_AGE = 18;
    private Person[] queue;

    private final int QUEUE_SEGMENT_SIZE = 2;
    //
    private final int NO_ITEM = -1;
    private final int HEAD_OF_QUEUE = 0;
    
    public PriorityArrayPersonQueue() {
        
        queue = new Person[QUEUE_SEGMENT_SIZE];
    }
	
    @Override
    public void insert(Person personToInsert) {

        if (personToInsert == null) {
            System.out.println("Missing person");
            return;
        }
        int insertPosition = getNextSlot();
        if (NO_ITEM == insertPosition) {
            insertPosition = extendQueue();
        }
        queue[insertPosition] = personToInsert;
    }
	
	@Override
    public int size() {
        
        int nextSlot = getNextSlot();
        return nextSlot == this.NO_ITEM ? queue.length : nextSlot;
    }
	
//    @Override
    public Person __retrieve() {

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
    public Person retrieve() {
		
		int size = size();
		if (size == 0) {
			return null;
		}
		// Retrieve by priority
		int retrievePersonIndex = getIndexOfNextPriorityPerson(FIRST_PRIORITY_AGE);
		if (retrievePersonIndex == NO_ITEM) {
			retrievePersonIndex = getIndexOfNextPriorityPerson(SECOND_PRIORITY_AGE);
		}		
		if (retrievePersonIndex == NO_ITEM) {
			System.out.println("No item found so returning");
			return null;
		}
        Person returnValue = queue[retrievePersonIndex];
		shiftQueue(retrievePersonIndex);
        return returnValue;
    }


	
	private int getIndexOfNextPriorityPerson(int priorityAge) {
		
		int returnValue = NO_ITEM;
		for (int i = 0; i<queue.length; i++) {			
			if(queue[i] != null && queue[i].getAge() >= priorityAge) {
				returnValue = i;
				break;
			}
		}
		return returnValue;
	}
	
	private int getNextSlot() {

        int returnValue = NO_ITEM;
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
	
	private void shiftQueue(int startPos) {

		int lastPos = getNextSlot();
		lastPos = lastPos == NO_ITEM ? queue.length - 1 : lastPos -1;

		if (startPos == lastPos) {
			 queue[startPos] = null;
		} else {
            System.arraycopy(queue, startPos + 1, queue, startPos, queue.length-1-startPos);
			if ((startPos + 1) == (queue.length)) {
				queue[startPos+1] = null;
			} else {
				Arrays.fill(queue, lastPos, queue.length, null);
			}
        } 

	}
	private void printArray() {
		for(int i = 0; i < queue.length; i++) {
			System.out.print("["+i + "="+ (queue[i] == null ? 0: queue[i].getAge()) + "]");
		}
		System.out.println("");
	}
}
