import java.util.LinkedList;

public class AISolver {
    private char token;
    public AISolver(char token) {
        this.token = token;
    }
    public char getToken() {
        return this.token;
    }
    // Result
    // TODO: FIX THIS
    public LinkedList<Integer> Actions(State s) {
        LinkedList<Integer> actions = new LinkedList<Integer>();
        // char[] str = s.getBoardStringRepresentation().toCharArray();
        // for(int i = 0; i < str.length; i++) {
        //     if(str[i] == Constants.EMPTY) {
        //         actions.add(i);
        //     }
        // }
        return actions;
    }

}