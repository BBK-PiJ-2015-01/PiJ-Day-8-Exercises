/**
 * Map from integer to Strings
 */
public interface SimpleMap {

    /**
     * Puts a new String in the map.
     *     
* If the key is already in the map, nothing is done.
     *
     * @param key
     * @param name
     */
    void put(int key, String name);

    /**
     * Returns the name associated with that key, or null if there is none.
     *
     * @param key
     * @return
     */
    String get(int key);

    /**
     * Removes a name from the map. Future calls to get(key) will return null
     * for this key unless another name is added with the same key. 
     *
     * @param key
     */
    void remove(int key);

    /**
     * Returns true if there are no workers in the map, false otherwise
     *
     * @return
     */
    boolean isEmpty();
}
