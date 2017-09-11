import java.util.ArrayList;
import java.util.Arrays;

public class HashFunction2 {

	String[] theArray;
	int arraySize;
	int itemsInArray = 0;

    HashFunction2(int size) {
        arraySize = size;
        theArray = new String[size];
        // Fill Array with -1 for each empty space
        fillArrayWithNeg1();
    }
    public void fillArrayWithNeg1() {

		Arrays.fill(theArray, "-1");

	}
    public void displayTheStack() {
        int increment = 0;
        int numberOfRows = (arraySize / 10) + 1;
        for (int m = 0; m < numberOfRows; m++) {
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
                if (n >= arraySize) System.out.print("|      ");
                else if (theArray[n].equals("-1")) System.out.print("|      ");
                else System.out.print(String.format("| %3s " + " ", theArray[n]));
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) System.out.print("-");
            System.out.println();
        }
    }
    public void hashFunction2(String[] stringsForArray, String[] theArray) {
    for (int n = 0; n < stringsForArray.length; n++) {
        String newElementVal = stringsForArray[n];
        // Create an index to store the value in by taking
        // the modulus
        int arrayIndex = Integer.parseInt(newElementVal) % arraySize;
        /*
         * 
         * System.out.println("Modulus Index= " + arrayIndex + " for value "
         * + newElementVal);
         */
        // Cycle through the array until we find an empty space
        while (theArray[arrayIndex] != "-1") {
            ++arrayIndex;
            // System.out.println("Collision Try " + arrayIndex +
            // " Instead");
            // If we get to the end of the array go back to index 0
            arrayIndex %= arraySize;
        }
        theArray[arrayIndex] = newElementVal;
    }
}
    
	public static void main(String[] args) {
        System.out.println("hello");
        
        HashFunction2 theFunc = new HashFunction2(30);
        
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398", "235", "802", "900", "723", "699", "1", "16", "999", "890", "725", "998", "978", "988", "990", "989", "984", "320", "321", "400", "415", "450", "50", "660", "624" };

        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
        theFunc.displayTheStack();
        
        
        
        
    }   
    
    
    
    
    
}