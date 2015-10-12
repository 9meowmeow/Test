package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel implements KeyListener, MouseListener {

    private Ball ball;
    private Racquet racquet;

    public DrawPanel(Ball ball, Racquet racquet) {
        this.ball = ball;
        this.racquet = racquet;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(ball!=null) {
            g.setColor(  ball.getColor()  );
            Position p = ball.getPosition();
            g.fillOval( p.getX(), p.getY(), ball.getD(), ball.getD() );
        }

        if(racquet!=null) {
            g.setColor(  racquet.getColor()  );
            Position p = racquet.getPosition();

            int deltaX = racquet.getWidth()/2;
            int deltaY = racquet.getHeight()/2;

            g.fillRect(p.getX()-deltaX, this.getHeight()-racquet.getHeight(), racquet.getWidth(), racquet.getHeight() );
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
