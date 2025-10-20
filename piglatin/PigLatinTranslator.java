package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");
        boolean end = ; 
        String result = "";
        String text = ""; 
        int upperbound = 0; 
        int lowerbound = 1; 
        // TODO: Replace this code to correctly translate a single word.
        String first = input.substring(lowerbound, upperbound);

        boolean startsWithVowel1 = 
            first.equals("a") || first.equals("e") ||
            first.equals("i") || first.equals("o") ||
            first.equals("u"); 
        
        if (startsWithVowel1){
            text = input.substring(upperbound) ; 
        }
        else{
            for(int i = 0; i<input.indexOf('a'); i++){
                char character = input.charAt(i); 

            }

        }

        }

        result  = input.substring(1) + input.substring(0,1) +"ay";
        // Start here first!
        // This is the first place to work.
        //result = input; // delete this line

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
