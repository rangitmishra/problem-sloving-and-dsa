package codingPatterns;

import java.util.Arrays;

/*
Input :  a[] = ["c", "cb", "cba"]
Output : cbacbc
Possible strings are ccbcba, ccbacb,
cbccba, cbcbac, cbacbc and cbaccb.
Among all these strings, cbacbc is
the lexicographically smallest.

Input :  a[] = ["aa", "ab", "aaa"]
Output : aaaaaab
 */
public class SmallestStringAfterConcatenation {

    static class Word implements Comparable<Word>{
        public String str;

        public Word(String str){
            this.str = str;
        }


        @Override
        public int compareTo(Word o) {
            String str1 = this.str + o.str;
            String str2 = o.str + this.str;
            return str1.compareTo(str2);
        }
    }

    public static void main(String[] args) {

        String[] arr = {"aa", "ab", "aaa"};
        Word[] words = new Word[arr.length];

        for(int i=0;i< arr.length;i++){
            words[i] = new Word(arr[i]);
        }
        Arrays.sort(words);

        StringBuilder stringBuilder = new StringBuilder();
        for(Word str: words){
            stringBuilder.append(str.str);
        }

        System.out.println(stringBuilder);


    }
}
