/**Given (S,T) that correspond to (tokyo,kyoto)
They become interesting if S=A+B AND T=B+A
A and B are parts of the string after they get split
In this case A=to and B=kyo
When the second pair gets its A and B rearranged it equals the first pair

Relating this to the constraints, S will have between 2 to 50 elements
The elements themselves are of 1 to 50 characters long. 
* */

/*The program accepts an array as input that contain strings*/
/*In order to find out if the strings in the array form interesting pairs, they
need to split and compared. If the re-arranged parts equal like in the forumula
then they are interesting.
The approach taken to achieve this is to take the first letter of the string S
and move it to the back. Compare the result with the String T, and keep doing 
this until we get to the original string we had in first place. If a match is 
found then they form an interesting pair.*/
package wordpairs;
/**
 *
 * @author Dimash
 */
public class WordPairs {

    public static void main(String[] args) {
        //Arrays used to test how many pairs can be found
        String[] wordpairs = {"tokyo", "kyoto"};
        String[] wordpairs2 = {"aaaaa","bbbbb"};
        String[] wordpairs3 = {"ababab", "bababa", "aabbb"};
        String[] wordpairs4 = {"eel", "ele", "lee"};
        String[] wordpairs5 = {"aaa", "aab", "aba", "abb", "baa", "bab","bba", "bbb"};
        String[] wordpairs6 = {"top","coder"};
        
        //calling the method interesting() to get a number of pairs found back.
        int count = interesting(wordpairs);
        System.out.println("First testcase(o). Interesting pairs found = "+count);
        int count2 = interesting(wordpairs2);
        System.out.println("Second testcase(1). Interesting pairs found = "+count2);
        int count3 = interesting(wordpairs3);
        System.out.println("Third testcase(2). Interesting pairs found = "+count3);
        int count4 = interesting(wordpairs4);
        System.out.println("Forth testcase(3). Interesting pairs found = "+count4);
        int count5 = interesting(wordpairs5);
        System.out.println("Fifth testcase(5). Interesting pairs found = "+count5);
        int count6 = interesting(wordpairs6);
        System.out.println("Sixth testcase(6). Interesting pairs found = "+count6);
    }
    
    /*taking the first word of the array and shifting its first letter to its
    back. Then checking if the new string matches the one of the strings in the array.
    */
    public static int interesting(String[] words){
        int countPairs = 0;
        String word1="";
        for(int i=0; i<words.length;i++){
            word1=words[i];
            for(int j=0; j<word1.length(); j++){
                char firstLetter=word1.charAt(0);
                word1=word1.substring(1);
                word1=word1+firstLetter;

                //check to see if this matches the original string.
                //it means we shifted all the letters.
                if(word1.equals(words[i])){
                    break;
                }
                //if the shuffled word1 equals ones of the strings in the array then they form a pair.
                //it only considers string that come after it in the array.
                //this allows the pairs to be distinct. Otherwise, the count will 
                //be double the result found.
                for(int k=i+1; k<words.length;k++){
                    if (word1.equals(words[k])){
                        countPairs=countPairs+1;
                        System.out.println(words[i]+" == "+ words[k]);
                    }
                }
            }
        }
        return countPairs;
    }
}
