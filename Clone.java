public class Clone {
    public static Board cloneBoard(Board arg) {
        Tile[][] source = arg.getBoardTiles();
        Tile[][] target = new Tile[Constants.ROWS][Constants.COLUMNS];
        for(int i = 0; i < Constants.ROWS; i++) {
            for(int j = 0; j < Constants.COLUMNS; j++) {
                target[i][j] = new Tile(source[i][j].getToken());
            }
        }
        Board ret = new Board();
        ret.setBoardTiles(target);
        return ret;
    }
}