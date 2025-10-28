package piglatin;
import java.util.Scanner; 


public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();
        
        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        for(int i = 0; i<input.getLineCount(); i++){
            translatedBook.appendLine(translateLine(input.getLine(i))); 
        }
        return translatedBook;
    } 
// implements translateLine() method into translate()
    public static String translate(String input) {
        //System.out.println("  -> translate('" + input + "')");
        Scanner scan = new Scanner(input); 
        String result = ""; 
        while(scan.hasNextLine()){
            String line = scan.nextLine(); 
            String lineTranslated = translateLine(line);
            if(result.length()==0){
                result = lineTranslated; 
            }
            else{
                result = result + '\n' + lineTranslated; 
            }
        } 
        scan.close(); 
        return result;
    }
//check if there is a next line and translates that line
    public static String translateLine(String input) {
        //System.out.println("  -> translate('" + input + "')");
        Scanner scan = new Scanner(input); 
        String result = ""; 
        while(scan.hasNext()){
            String token = scan.next(); 
            String tokenTranslated = translateWord(token);
            if(result.length()==0){
                result = tokenTranslated; 
            }
            else{
                result = result + " " + tokenTranslated; 
            }
        } 
        scan.close(); 
        return result;
    }
    

//translates a word with trailing punctuation 
    private static String translateWord(String input) {
        //System.out.println("  -> translateWord('" + input + "')"); 
        
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
    //this method translates word that do not have a trailing punctuation mark at the end. 
    private static String translateSimpleWordWithoutTrailingPunc(String input) {
       //System.out.println("  -> translateWord('" + input + "')"); 
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

    //small method to check is a letter is a vowel or not
    private static boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
        ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'; 
    }



    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)


}
