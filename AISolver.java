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
        // System.out.println(actions.toString());
        return actions;
    }
    
    public State Result(State s, int action) {
        // A result of another function will invert the turn
        State newState = new State(Clone.cloneBoard(s.getBoard()), Game.invert(s.getTurn()), action);
        // 
        newState.getBoard().getBoardTiles()[action/Constants.ROWS][action%Constants.COLUMNS].setToken(s.getTurn());
        return newState;
    }

    public int maxValue(State s) {
        // System.out.println("solving4");
        int m = Constants.NEGATIVE_INFINITY;
        for(State branchingState : successors(s)) {
            int v = value(branchingState);
            m = max(v, m);
        }
        return m;
    }

    public int minValue(State s) {
        // System.out.println("solving3");
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
        // System.out.println("solving");
        // System.out.println("Turn: " + s.getTurn());
        if(s.getTurn() == token) {
            // If it is the AI's turn
            return maxValue(s);    
        }
        else if(Actions(s).size() == 0) return utility(s);
        else if(s.getTurn() != token) {
            // If it is the player's turn
            return minValue(s);
        }
        return 0;
    }
    public int utility(State s) {
        // AI wins
        if(s.getWinner() == token) return 1;
        // Player wins
        else if(s.getWinner() == Game.invert(token)) return -1;
        // Draw
        else return 0;
    }

    public LinkedList<State> successors(State s) {
        LinkedList<Integer> actions = Actions(s);
        LinkedList<State> children = new LinkedList<State>();
        for(int action : actions) {
            State child = Result(s, action);
            child.checkWin();
            children.add(child);
        }
        // System.out.println(children.toString());
        return children;
    }

    public void think(State s) {
        System.out.println("x" + minValue(s));
        System.out.println("y" + maxValue(s));
        System.out.println("z" + value(s));
    }
}
