package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    final static int WINDOW_WIDTH = 400;
    final static int WINDOW_HEIGHT = 400;

    public static boolean checkBorderX(Ball ball, int fieldWidth) {

        int ballX = ball.getPosition().getX();

        if( ballX < 0 || ballX+ball.getD() > fieldWidth) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkBorderY(Ball ball, int fieldHeight) {

        int ballY = ball.getPosition().getY();

        if( ballY < 0 || ballY+ball.getD() > fieldHeight) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My window");
        frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        Ball ball = new Ball(new Position(50,0), 70, new Color(255, 100, 247));
        final Racquet racquet = new Racquet(
                100,
                20,
                new Position(WINDOW_WIDTH/2, WINDOW_HEIGHT-10),
                new Color(157, 33,255) );





        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
                    racquet.moveLeft();
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                    racquet.moveRight();
                }
            }
        });



        final DrawPanel mainPanel = new DrawPanel(ball, racquet);

        topPanel.setLayout(new FlowLayout());

        JButton btn1 = new JButton();
        btn1.setText("Create Ball");

        // 0 - speed OX
        // 1 - speed OY
        final int[] speed = new int[2];

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Ball ball = mainPanel.getBall();
                if(ball!=null) {

                    if( checkBorderX(ball, mainPanel.getWidth() ) ) {
                        ball.move(speed[0], 0);
                    } else {
                        speed[0] =-speed[0];
                        ball.move(speed[0], 0);
                    }

                    if( checkBorderY(ball, mainPanel.getHeight() )) {
                        ball.move(0, speed[1]);
                    } else {
                        speed[1] =-speed[1];
                        ball.move(0, speed[1]);
                    }

                }

                mainPanel.repaint();

            }
        });
        timer.start();


        topPanel.add(btn1);

        JButton btn2 = new JButton();
        btn2.setText("Add speed x");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed[0]+=2;
            }
        });

        topPanel.add(btn2);

        JButton btn3 = new JButton();
        btn3.setText("Add speed y");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed[1]+=2;
                // mainPanel.getBall().move(0,5);
            }
        });

        topPanel.add(btn3);

        mainPanel.setBackground(new Color(255, 191, 243));
        topPanel.setBackground(new Color(255, 191, 243));

        frame.add(topPanel, BorderLayout.NORTH);

        // mainPanel.setFocusable(true);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}