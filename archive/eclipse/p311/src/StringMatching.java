import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class StringMatching {

    static String getAlphaNumericString(int n){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
        "0123456789"+"abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i<n; i++){
            int index = (int)(AlphaNumericString.length()*Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
    
    public static void BruteForceStringMatch(String str, String pattern) {
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            int j = 0;
            while ((j < pattern.length()) && (pattern.charAt(j) == str.charAt(i + j)))
                j++;
            //if (j == pattern.length())
                //System.out.println("Patter found at index "+i);
        }
        return;
    }


    
     public static void KMP(String text, String pattern)
    {
        // base case 1: pattern is null or empty
        if (pattern == null || pattern.length() == 0)
        {
            //System.out.println("The pattern occurs with shift 0");
            return;
        }
 
        // base case 2: text is NULL, or text's length is less than that of pattern's
        if (text == null || pattern.length() > text.length())
        {
            System.out.println("Pattern not found");
            return;
        }
 
        char[] chars = pattern.toCharArray();
 
        //creates the table
        int[] next = new int[pattern.length() + 1];
        for (int i = 1; i < pattern.length(); i++)
        {
            int j = next[i + 1];
 
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j];
            }
 
            if (j > 0 || chars[j] == chars[i]) {
                next[i + 1] = j + 1;
            }
        }
 
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            //if there is a match between text and pattern
            if (j < pattern.length() && text.charAt(i) == pattern.charAt(j))
            {
                //increase j and if j = pattern length, the pattern was found
                if (++j == pattern.length()) {
                    //System.out.println("The pattern occurs with shift " + (i - j + 1));
                }
            }
            //if there isn't a match
            else if (j > 0)
            {
                //j = the next best in the table
                j = next[j];
                i--;    // since `i` will be incremented in the next iteration
            }
        }
    }
 


    //BM Algorithm

    static int NO_OF_CHARS = 256;
    //get max
    static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    //ABCBALAA
    // BC



    //Fills the table for chars
    static void badCharHeuristic(String str, int size, int badchar[]) {
        //all elements become -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        //fills the actual value of the last occurrence of a char
        for (int i = 0; i < size; i++)
            badchar[(int) str.charAt(i)] = i;
            
    }


    //the main function
    static void BMStringMatch(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        int badchar[] = new int[NO_OF_CHARS];

        //fills the table in array badchar
        badCharHeuristic(pat, m, badchar);

        //abcbba
        // bba
        //b: 1, a: 2 *:3

        //b:1, b:2, a:1

        //s is how much we will shift
        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;
            //checks to see if the words match or not
            while (j >= 0 && pat.charAt(j) == txt.charAt(s+j))
                j--;
            //if j is negative, there was a match, else we increase s
            if (j < 0) {
                //System.out.println("Patterns occur at shift " + s);
                //checks to see if its at the end of the word or not
                //txt[s+m] is the next m length word after
                if(s+m<n)
                    s+=m-badchar[txt.charAt(s+m)];
                else
                    s++;
            } else //shifts the pattern to the next bad character in the text
            /*we use max because if the last occurrence of a bad character in
              the pattern is on the right of the current character, it will do
              a negative shift. but the main operation should be
              j - badchar[txt.charAt(s+j)]*/
              //

              //
                s += max(1, j - badchar[txt.charAt(s+j)]);
        }
    }

    public static void main(String args[]) {
        
//    	int k= 0;
//    	long[] nbf = new long[100] ;
//    	long[] nkmp = new long[100] ;
//    	long[] nbm = new long[100] ;
    	
    	
            for(int n = 100; n<=10000; n+=100){
                long sumTimeOfBruteForce = 0;
                long sumTimeOfKMP = 0;
                long sumTimeOfBM = 0;
                for(int i = 0; i<5; i++){
                //System.out.println("\nWhen input size is: "+n);
                String str = getAlphaNumericString(n);
                String pattern = getAlphaNumericString(3);
                long startBrute = System.nanoTime();
                BruteForceStringMatch(str, pattern);
                long endBrute = System.nanoTime();
                long totalTimeBrute = endBrute-startBrute;
                //System.out.println("Time elapsed for brute force: "+totalTimeBrute+"ns");
                sumTimeOfBruteForce+=totalTimeBrute;

                long startKMP = System.nanoTime();
                KMP(str, pattern);
            
                long endKMP = System.nanoTime();
                long totalTimeKMP = endKMP-startKMP;
                //System.out.println("Time elapsed for KMP: "+totalTimeKMP+"ns");
                sumTimeOfKMP+=totalTimeKMP;
            
                long startBM = System.nanoTime();
                BMStringMatch(str, pattern);
                long endBM = System.nanoTime();
                long totalTimeBM = endBM-startBM;
                //System.out.println("Time elapsed for BM: "+totalTimeBM+"ns");
                sumTimeOfBM+=totalTimeBM;
            }
    
        System.out.println("Total time elapsed for brute force: "+(sumTimeOfBruteForce/5)+"ns when input size = " + n);
        System.out.println("Total time elapsed for KMP: "+(sumTimeOfKMP/5)+"ns when input size = "+n);
        System.out.println("Total time elapsed for BM: "+(sumTimeOfBM/5)+"ns when input size = "+n+"\n");
        
        
      
        
//        nbf[k] = sumTimeOfBruteForce/5;
//        
//        nkmp[k] = sumTimeOfKMP/5 ;
//        
//        nbm[k] = sumTimeOfBM/5 ;
//        k++;
//        }
            
//            for (k=0 ; k<100 ; k++) {
//            	
//            	System.out.println(nbf[k]);
//            }
//            
//            System.out.println("KMP \n");
//            
//            for (k=0 ; k<100 ; k++) {
//            	
//            	System.out.println( nkmp[k]);
//            }
//            
//            System.out.println("BM /n");
//            for (k=0 ; k<100 ; k++) {
//            	
//            	System.out.println( nbm[k]);
            }
    }

}
