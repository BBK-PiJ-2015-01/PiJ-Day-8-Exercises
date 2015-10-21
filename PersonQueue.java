public interface PersonQueue {

    /**
     * Adds another person to the queue.
     *
     * @param person
     */
    void insert(Person person);

    /**
     * Removes a person from the queue.
     *
     * @return
     */
    Person retrieve();

    /**
     * Returns the size of the queue
     *
     * @return
     */
    int size();
}
