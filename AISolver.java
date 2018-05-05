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
    public static LinkedList<Integer> Actions(State s) {
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
        State newState = new State(Clone.cloneBoard(s.getBoard()), Game.invert(s.getTurn()), s.getActions(), action);
        // 
        newState.getBoard().getBoardTiles()[action/Constants.ROWS][action%Constants.COLUMNS].setToken(s.getTurn());
        return newState;
    }

    public ActionValue maxValue(State s) {
        ActionValue m = new ActionValue(0,Constants.NEGATIVE_INFINITY);
        for(State branchingState : successors(s)) {
            ActionValue v = value(branchingState);
            // m = max(v, m,branchingState);
            m = max(v,m,branchingState);
        }
        return new ActionValue(m.getAction(),m.getValue());
    }

    public ActionValue minValue(State s) {
        ActionValue m = new ActionValue(0, Constants.POSITIVE_INFINITY);
        // int m = Constants.POSITIVE_INFINITY;
        for(State branchingState : successors(s)) {
            ActionValue v = value(branchingState);
            // m = min(v,m,branchingState);
            m = min(v, m, branchingState);
        }
        return new ActionValue(m.getAction(),m.getValue());
    }

    public ActionValue max(ActionValue v, ActionValue m, State s) {
        if(v.getValue() > m.getValue()){
            return new ActionValue(v.getAction(),v.getValue());
        }
        return new ActionValue(m.getAction(), m.getValue());
    }

    public ActionValue min(ActionValue v, ActionValue m, State s) {
        if(v.getValue() < m.getValue()){
            return new ActionValue(v.getAction(), v.getValue());
        }
        return new ActionValue(m.getAction(), m.getValue());
    }

    public ActionValue value(State s) {
        if(Actions(s).size() == 0 || s.checkWin()) return utility(s);
        else if(s.getTurn() == token) {
            // If it is the AI's turn
            return maxValue(s);    
        }
        else if(s.getTurn() != token) {
            return minValue(s);
        }
        return null;
    }
    public ActionValue utility(State s) {
        s.checkWin();
        // AI wins
        if(s.getWinner() == token){
            return new ActionValue(s.getActions().get(0),1);
        }
        // Player wins
        else if(s.getWinner() == Game.invert(token)){
            return new ActionValue(s.getActions().get(0),-1);
        }
        // Draw
        return new ActionValue(s.getActions().get(0),0);
    }
    public LinkedList<State> successors(State s) {
        LinkedList<Integer> actions = Actions(s);
        LinkedList<State> children = new LinkedList<State>();
        for(int action : actions) {
            State child = Result(s, action);
            child.checkWin();
            children.add(child);
        }
        return children;
    }

    public void think(State s) {
        ActionValue av = value(s);
        s.getBoard().getBoardTiles()[av.getAction() / 3][av.getAction() % 3].aiAction(s.getTurn());
        this.stateToBeTaken = null;
    }
}
