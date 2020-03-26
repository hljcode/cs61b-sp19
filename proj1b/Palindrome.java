public class Palindrome extends LinkedListDeque<Character> implements Deque<Character>{
    public Deque<Character> wordToDeque(String word){
         Deque<Character> wordDeque=new LinkedListDeque<>();
         for(int i=0;i<word.length();i++){
               wordDeque.addLast(word.charAt(i));
        }
         return wordDeque;
    }

    public boolean isPalindrome(String word,CharacterComparator cc){
         Deque<Character> wordDeque=new LinkedListDeque<>();
         wordDeque=wordToDeque(word);
         String reverseWord=new StringBuilder(word).reverse().toString();
         Deque<Character> reverseWordDeque=new LinkedListDeque<>();
         reverseWordDeque=wordToDeque(reverseWord);
         int checklength=word.length()/2;
         return isPalindromeHelper(wordDeque,reverseWordDeque,cc,checklength);
    }

    public boolean isPalindromeHelper(Deque T,Deque L,CharacterComparator cc,int checklength){
          if(checklength==0)
              return true;
          if(cc.equalChars((char)T.removeFirst(),(char)L.removeFirst())==false)
              return false;
          return isPalindromeHelper(T,L,cc,checklength-1);
     }

    public boolean isPalindrome(String word){
        Deque wordArray=wordToDeque(word);
        String reverseword=new StringBuilder(word).reverse().toString();
        Deque reversewordArray=wordToDeque(reverseword);
        int checklength=word.length()/2;
        return isPalindromeHelper(wordArray,reversewordArray,checklength);
    }

    public boolean isPalindromeHelper(Deque T,Deque L,int checklength){
        if(checklength==0)
            return true;
        if(T.removeFirst().equals(L.removeFirst())==false)
            return false;
        return isPalindromeHelper(T,L,checklength-1);
    }
}