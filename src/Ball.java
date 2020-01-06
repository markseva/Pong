import java.awt.*;

public class Ball {

    private int x, y;
    private final int DIAMETER = 25;
    private final int SPEED = 5;

    double dx = SPEED, dy = SPEED;

    Board board;

    public Ball(Board board){
        x = 0;
        y = 0;

        //'this' keyword refs the object that is executing the this reference

        this.board = board;

    }

    public void move(){

        //LEFT AND RIGHT
        if(x<= 0){
            board.setcScore(board.getcScore() + 1);
            dx*=-1;
        }
        if(x <= 0 || x + DIAMETER >= board.getWidth()){
            board.setpScore(board.getpScore()-1);
            dx*=-1;
        }
        if(y <= 0 || y + DIAMETER >= board.getHeight()){
            board.setpScore(board.getcScore()+1);

            dy*=-1;

        }

        x+=dx;
        y+=dy;

    }

    public void setPosition(int x, int y){

        this.x = x - DIAMETER/2;
        this.y = y - DIAMETER/2;

    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }
    double MAXANGLE = 5*Math.PI/12; // 70 degree
    public void checkCollisions(Paddle other) {
        if (getBounds().intersects(other.getBounds())) {
            if( x < board.getWidth()/2){
                dx*= -1;
            }
            if(x > board.getWidth()/2){
                dx*=-1;
            }

        }
    }

    public void paint(Graphics g){
        g.fillOval(x,y,DIAMETER,DIAMETER);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getDiam(){
        return DIAMETER;
    }
}

