import java.util.Arrays;

public class HashFunction{
    
    //constructors have no publics or voids i suppose.... for now... lol.....
    HashFunction(int size){
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }
    
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;
    
    public static void main(String[] args){
        
        HashFunction theFunc = new HashFunction(30);
        String[] elementsToAdd = {"1", "5", "17"};
        //theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
        //theFunc.displayTheStack();   
        
        
        
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
        
        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
        
        
        
        theFunc.displayTheStack();
        
        theFunc.findKey("723");
        
    }
    
    
    public void hashFunction2(String[] stringsForArray, String[] theArray) {
        for (int n = 0; n < stringsForArray.length; n++) {
            
            String newElementVal = stringsForArray[n];
            // Create an index to store the value in by taking
            // the modulus
            int arrayIndex = Integer.parseInt(newElementVal) % 29;
            System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);
            // Cycle through the array until we find an empty space
            while (theArray[arrayIndex] != "-1") {
                ++arrayIndex;
                System.out.println("Collision Try " + arrayIndex + " Instead");
                // If we get to the end of the array go back to index 0
                arrayIndex %= arraySize;
            }
            theArray[arrayIndex] = newElementVal;
        }
    }
    
    
    
    
    public String findKey(String key){
        
        
        int arrayIndexHash = Integer.parseInt(key) % 29; 
        
        while(theArray[arrayIndexHash]!="-1"){
            if(theArray[arrayIndexHash] == key){
                System. out.println(key + " was found in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            
            ++arrayIndexHash;
            arrayIndexHash %= arraySize;
            
        }
        return null;
        
    }
    
    public void hashFunction1(String[] stringsForArray, String[] theArray){
    
        for( int n = 0; n < stringsForArray.length; n++){
            String newElementVal = stringsForArray[n];
            //this is basically the hash function part of the function
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }    
    }
    
    public void displayTheStack() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {
            increment += 10;
            for (int n = 0; n < 71; n++) System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1")) System.out.print("|      ");
                else System.out.print(String.format("| %3s " + " ", theArray[n]));
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) System.out.print("-");
            System.out.println();
        }
    }
    
}




