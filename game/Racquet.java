package game;
import java.awt.*;

public class Racquet {
    private int width;
    private int height;
    private Position position;
    private Color color;

    private int step = 5;

    public Racquet(int width, int height, Position position, Color color) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Center of Racquet
     * @return
     */
    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void moveRight() {
        position.setX(  position.getX() + step  );
    }

    public void moveLeft() {
        position.setX(  position.getX() - step  );
    }
}