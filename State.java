public class State {
    private Board currentBoard;
    private int value;
    private char turn;
    public State(Board board, char turn) {
        this.currentBoard = board;
        this.value = Constants.NON_EXISTING_VALUE;
        this.turn = turn;
    }
    public Board getBoard() {
        return this.currentBoard;
    }
    public int getValue() {
        return this.value;
    }
    public char getTurn() {
        return this.turn;
    }
    public void setTurn(char turn) {
        this.turn = turn;
    }
    private boolean checkDiagonal() {
        /*
            DIAGONAL:
                    [0][0]
                            [1][1]
                                    [2][2]
                    ----------------------
                                    [0][2]
                            [1][1]
                    [2][0]
        */
        Tile[][] boardTiles = currentBoard.getBoardTiles(); 
        boolean continuous = true;
        // Check backslash (' \ ') diagonal
        char first = boardTiles[0][0].getToken();
        for(int i = 1; i < Constants.COLUMNS; i++) {
            if(first != Constants.EMPTY) {
                if(first != boardTiles[i][i].getToken()) {
                    continuous = false;
                    break;
                }
            } 
            else {
                continuous = false;
                break;
            }
        }
        if(continuous) return true;
        continuous = true;
        first = boardTiles[Constants.ROWS - 1][0].getToken();
        for(int i = 2, j = 0; i >= 0 && j < Constants.COLUMNS; i--, j++) {
            if(first != Constants.EMPTY) {
                if(first != boardTiles[i][j].getToken()) {
                    continuous = false;
                    break;
                }
            }
            else {
                continuous = false;
                break;
            }
        }
        if(continuous) return true;
        return false;
    }

    private boolean checkHorizontal() {
        /*
            HORIZONTAL:
                    [0][0]  [0][1]  [0][2],

                    [1][0]  [1][1]  [1][2],

                    [2][0]  [2][1]  [2][2]
        */
        Tile[][] boardTiles = currentBoard.getBoardTiles(); 
        for(int i = 0; i < Constants.ROWS; i++) {
            char first = boardTiles[i][0].getToken();
            if(first == Constants.EMPTY) continue;
            boolean continuous = true;
            for(int j = 1; j < Constants.COLUMNS; j++) {
                if(first != boardTiles[i][j].getToken()) {
                    continuous = false;
                    break;
                }
            }
            if(continuous) return true;
        }
        return false;
    }
    public static void stop() {
        Game.STATUS = "DONE";
    }
    public static void restart() {
        Game.STATUS = "~";
    }
    private boolean checkVertical() {
        /*
            VERTICAL:
                    [0][0]
                    [1][0]
                    [2][0]
                    ------
                    [0][1]
                    [1][1]
                    [2][1]
                    ------
                    [0][2]
                    [1][2]
                    [2][2]
        */
        Tile[][] boardTiles = currentBoard.getBoardTiles(); 
        for(int i = 0; i < Constants.COLUMNS; i++) {
            char first = boardTiles[0][i].getToken();
            boolean continuous = true;
            if(first == Constants.EMPTY) continue;
            for(int j = 0; j < Constants.ROWS; j++) {
                if(first != boardTiles[j][i].getToken()) {
                    continuous = false;
                    break;
                }
            }
            if(continuous) return true;
        }
        return false;
    }
    public boolean checkWin() {
        if(checkHorizontal() || checkVertical() || checkDiagonal() ) {
            return true;
        }
        return false;
    }
    public void printStatus() {
        Tile[][] boardTiles = currentBoard.getBoardTiles();
        for(int i = 0; i < Constants.ROWS; i++) {
            for(int j = 0; j < Constants.COLUMNS; j++) {
                System.out.print(boardTiles[i][j].getToken());
            }
        }
        System.out.println("");
    }
    public String getBoardStringRepresentation() {
        StringBuilder sb = new StringBuilder();
        Tile[][] boardTiles = currentBoard.getBoardTiles();
        for(int i = 0; i < Constants.ROWS; i++) {
            for(int j = 0; j < Constants.COLUMNS; j++) {
                sb.append(boardTiles[i][j].getToken());
            }
        }
        return sb.toString();
    }
}