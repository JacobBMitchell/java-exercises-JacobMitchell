package learn.chess;

public class Knight {
    private int row = 0;
    private int column = 0;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean move(int row, int column){
        if ((row > 7) || (column > 7) || (row < 0) || (column < 0) || (row == this.row && column == this.column)) { // if inbounds and not in the same place
            return false;
        }
        int rowDiff = Math.abs(this.row-row);
        int colDiff = Math.abs(this.column-column);
        if ((rowDiff ==2 && colDiff ==1) || (colDiff ==2 && rowDiff ==1)){
            this.row = row;
            this.column = column;
            return true;
        }
        return false;
    }
}
