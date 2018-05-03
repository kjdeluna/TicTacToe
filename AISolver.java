import java.util.LinkedList;

public class AISolver {
    private char token;
    State stateToBeTaken;
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

    public int maxValue(State s, int level) {
        System.out.println("MAX");
        System.out.println("LEVEL: " + level);
        int m = Constants.NEGATIVE_INFINITY;
        for(State branchingState : successors(s)) {
            int v = value(branchingState, level);
            m = max(v, m, level,branchingState);
        }
        System.out.println("MAX RETURNED: " + m);
        return m;
    }

    public int minValue(State s, int level) {
        System.out.println("MIN");
        System.out.println("LEVEL: " + level);
        int m = Constants.POSITIVE_INFINITY;
        for(State branchingState : successors(s)) {
            int v = value(branchingState, level);
            m = min(v,m,level,branchingState);
        }
        System.out.println("MIN RETURNED: " + m);
        return m;
    }

    public int max(int v, int m, int level, State s) {
        if(v > m){
            if(level == 1){
                this.stateToBeTaken = s;
            }
            return v;
        }
        return m;
    }

    public int min(int v, int m, int level, State s) {
        if(v < m){
            if(level == 1){
                this.stateToBeTaken = s;
            }
            return v;
        }
        return m;
    }

    public int value(State s, int level) {
        System.out.println("VALUE");
        System.out.println("Turn: " + s.getTurn());
        if(Actions(s).size() == 0 || s.checkWin()) return utility(s);
        else if(s.getTurn() == token) {
            // If it is the AI's turn
            return maxValue(s, level + 1);    
        }
        else if(s.getTurn() != token) {
            return minValue(s, level + 1);
        }
        return 0;
    }
    public int utility(State s) {
        System.out.println("UTILITY");
        s.checkWin();
        // AI wins
        if(s.getWinner() == token){
            System.out.println("UTILITY RETURNED: 1");
            return 1;
        }
        // Player wins
        else if(s.getWinner() == Game.invert(token)){
            System.out.println("UTILITY RETURNED: -1");
            return -1;
        }
        // Draw
        else{
            System.out.println("UTILITY RETURNED: 0");
            return 0;
        }
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
        System.out.println(value(s, 0));
        System.out.println("AI's turn: " + this.stateToBeTaken.getRecentAction());
        s.getBoard().getBoardTiles()[this.stateToBeTaken.getRecentAction() / 3][this.stateToBeTaken.getRecentAction() % 3].aiAction(s.getTurn());
        this.stateToBeTaken = null;
    }
}
