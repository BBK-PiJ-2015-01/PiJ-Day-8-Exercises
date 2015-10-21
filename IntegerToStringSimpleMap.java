public class IntegerToStringSimpleMap implements SimpleMap {
    
    private final int mapArraySize = 1000;
    private final String[] mapArray = new String[mapArraySize];

    @Override
    public void put(int key, String name) {
        
        
        if (key >= mapArray.length) {
            System.out.println("Trapped array out of bounds");
            return;
        }
        if  (mapArray[key] == null) {
            mapArray[key] = name;
        }        
    }

    @Override
    public String get(int key) {
        
        if (key >= mapArray.length) {
            System.out.println("Trapped array out of bounds");
            return null;
        }
        return mapArray[key];
    }

    @Override
    public void remove(int key) {
        
        if (key >= mapArray.length) {
            System.out.println("Trapped array out of bounds");
            return;
        }
        mapArray[key] = null;
    }

    @Override
    public boolean isEmpty() {
        
        for (String member: mapArray) {
            if (member != null) {
                return false;
            }
        }
        return true;
    }    
}
