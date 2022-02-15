public class Monster {
    private final char symbol = 'Q';
    private int x;
    private int y;

    public Monster(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void moveX(int x) {
        if (x+1 == Game.WIDTH) {
            this.x = x--;
        }
        else {this.x++;}
    }
    public  void moveXNeg(int x){
        if(x-1 == 0){
            this.x = x++;
        }
        else {this.x--;}
    }

    public int getY() {
        return y;
    }

    public void moveY(int y) {
        if (y+1 == Game.HEIGHT) {
            this.y = y--;
        }
        else {this.y++;}
    }
    public  void moveYNeg(int y){
        if(y-1 == 0){
            this.y = y++;
        }
        else {this.y--;}
    }
    public int[] moveRandom() {
        int xOrY = (int) (Math.random() * 2);
        int plusOrMinus = (int) (Math.random() * 2);
        switch (xOrY) {
            case 0:
                if (plusOrMinus == 1) {
                    moveX(this.x);
                } else {
                    moveXNeg(this.x);
                }
                break;
            case 1:
                if (plusOrMinus == 1) {
                    moveY(this.y);
                } else {
                    moveYNeg(this.y);
                }
                break;

        }
        return new int[] {this.x, this.y};
    }

    public char getSymbol() {
        return symbol;
    }
}
