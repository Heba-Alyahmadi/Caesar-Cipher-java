/**
 * Caesar cipher program.
 */
public class Caesar {
    /**
     * this method will rotate ONE character by the given shift.
     * @param shift the number of positions to shift
     * @param ch the character to rotate
     * @return the rotated character
     */
    public static char rotate(int shift, char ch) {

        //-----Lowercase letters-----
        if (ch >= 'a' && ch <= 'z'){
            // find it's position
            int position = ch - 'a';
            // finding new position
            int newPosition = (position + shift) % 26;

            //in case the shift is negative
            if ( newPosition < 0) {
                newPosition += 26;
            }
            //converting the new position to it's letter
            return (char) ('a' + newPosition); 
        }
        //-----Uppercase letters-----
        else if (ch >= 'A' && ch <= 'Z'){
            int position = ch - 'A';
            int newPosition = (position + shift) % 26;
            if (newPosition < 0){
                newPosition += 26;
            }
            return (char) ('A' + newPosition);
        }
        //-----Others-----
        else {
            return ch; //if it is a space it will return unchanged
        }    
    }

    /** 
     *  this method will rotate a whole string.
     * @param shift the number of positions to shift
     * @param text the string to rotate
     * @return the rotated string
     */
    public static String rotate(int shift, String text){
        String result = "";

        //For loop to go each character in the text string
        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);
            // used the rotate(char) method for each character
            result = result + rotate(shift, currentChar);
        }
        return result;
    }
    
    /**
     * Main method: reads shift and message from command line. 
     * @param args command line arguments
     */
    public static void main(String[] args){
        // in case the user entered many parameters:
        if(args.length > 2){
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar n \"cipher text\"");
            return;
        }
        // in case the user entered too few parameters
        if(args.length < 2){
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar n \"cipher text\"");
            return; 
        }
        //the first argument: shift (convert string to int)
        int shift = Integer.parseInt(args[0]);
        //the second argument: message
        String message = args[1];
        //output the rotated result
        System.out.println(rotate(shift, message));
        System.out.println("--------------------------------------------------------");
        

    }
}

