package piglatin;
import java.util.Scanner; 


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
        String[] words = input.split(" ");
        String result; 
        if(input.contains(" ")){
            for(String word : words){
                result = translateSimpleWordWithoutTrailingPunc(word); 
                return word; 
            }
        }
        else{
            return input; 
        }




        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);
        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')"); 
        
        input = input.trim(); 
        if(input.length()==0){
            return input; 
        }
        if(!Character.isAlphabetic(input.charAt(input.length()-1))){
            char ch = input.charAt(input.length()-1); 
            String noDot = input.substring(0, input.length()-1);  
            String result = translateSimpleWordWithoutTrailingPunc(noDot); 
            return result + ch; 
        }
    
        else{
            return translateSimpleWordWithoutTrailingPunc(input);
            
        }

        //String result  = input + "ay"; 
        // Start here first!
        // This is the first place to work.
        //result = input; // delete this line
    }
     
    private static String translateSimpleWordWithoutTrailingPunc(String input) {
        System.out.println("  -> translateWord('" + input + "')"); 
        //String[] words = input.split(" ");
        
        input = input.trim(); 
        if(input.length()==0){
            return input; 
        }
        int indexOfVowel = -1; 
        for(int i = 0; i<input.length(); i++){
            char ch = input.charAt(i); 
            if(isVowel(ch)){
                indexOfVowel = i; 
                break; 
            }
        } 
        
        if(indexOfVowel<=0){
            return input + "ay"; 
        }

    
        else{
            if(Character.isUpperCase(input.charAt(0))){
                return input.substring(indexOfVowel, indexOfVowel+1).toUpperCase() + 
                input.substring(indexOfVowel+1) + 
                input.substring(0, 1).toLowerCase() + 
                input.substring(1,indexOfVowel) + 
                "ay";
            }
            
            return input.substring(indexOfVowel)+input.substring(0, indexOfVowel) + "ay"; 
        }

        //String result  = input + "ay"; 
        // Start here first!
        // This is the first place to work.
        //result = input; // delete this line
    }


    private static boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
        ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'; 
    }



    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)


}
