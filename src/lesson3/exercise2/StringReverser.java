package lesson3.exercise2;

import lesson3.exercise1.stack.StackImpl;

public class StringReverser implements Reverser {

    private StackImpl<Character> stack;

    public StringReverser() {
    }

    public StringReverser(String str) {
        add(str);
    }

    public void add(String word) {
        this.stack = new StackImpl<>(word.length());
        for (Character c : word.toCharArray()) {
            stack.push(c);
        }
    }

    public void append(String word) {
        StringReverser tmpSr = new StringReverser(this.stack.toString());
        add(tmpSr.stack.toString() + word);
    }

    public String reverse() throws NullPointerException {
        return stack.display();
    }
}
