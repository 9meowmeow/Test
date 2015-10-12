package game;
import java.awt.*;

public class Ball {
    private Position position;
    private int d;
    private Color color;

    public Ball(Position position, int d, Color color) {
        this.position = position;
        this.d = d;
        this.color = color;
    }

    public void move(int dx, int dy) {
        position.setX(  position.getX() + dx  );
        position.setY(position.getY() + dy);
    }

    public Position getPosition() {
        return position;
    }

    public int getD() {
        return d;
    }

    public Color getColor() {
        return color;
    }
}