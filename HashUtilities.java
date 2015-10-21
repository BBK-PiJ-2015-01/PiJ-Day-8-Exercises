public class HashUtilities {
    
    public final static int SHORT_HASH_MODULUS = 1000;
    
    public static int shortHash(int value){
        
        return Math.abs(value % SHORT_HASH_MODULUS);      
    }    
}
