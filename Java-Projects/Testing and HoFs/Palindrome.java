public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        if(word == null) {
            return true;
        }

        Deque<Character> wordDeque = wordToDeque(word);

        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        } else {
            if (wordDeque.removeFirst() == wordDeque.removeLast()) {
                return isPalindrome(word.substring(1, word.length() - 1));
            } else {
                return false;
            }
        }
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {
        if(word == null) {
            return null;
        }

        Deque<Character> wordDeque = wordToDeque(word);

        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        } else {
            if (cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
                return isPalindrome(word.substring(1, word.length() - 1), cc);
            } else {
                return false;
            }
        }
    }

}
