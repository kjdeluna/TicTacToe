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
    public LinkedList<Integer> Actions(State s) {
        LinkedList<Integer> actions = new LinkedList<Integer>();
        char[] str = s.getBoardStringRepresentation().toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == Constants.EMPTY) {
                actions.add(i);
            }
        }
        return actions;
    }
    
    public State Result(State s, int action) {
        State newState = new State(Clone.cloneBoard(s.getBoard()));
        newState.getBoard().getBoardTiles()[action/Constants.ROWS][action%Constants.COLUMNS].setToken(Game.TURN);
        return newState;
    }

    public int maxValue(State s) {
        int m = Constants.NEGATIVE_INFINITY;
        for(State branchingState : successors(s)) {
            int v = value(branchingState);
            m = max(v, m);
        }
        return m;
    }

    public int minValue(State s) {
        int m = Constants.POSITIVE_INFINITY;
        for(State branchingState : successors(s)) {
            int v = value(branchingState);
            m = min(v,m);
        }
        return m;
    }

    public int max(int v, int m) {
        return (v > m ? v : m);
    }

    public int min(int v, int m) {
        return (v < m ? v : m);
    }

    public int value(State s) {
        // TODO:
        return 0;
    }

    public LinkedList<State> successors(State s) {
        return null;
    }
}
