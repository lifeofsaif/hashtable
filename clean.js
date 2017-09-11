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