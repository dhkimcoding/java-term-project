import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Frogger extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 270 * 3;
    int boardHeight = 180 * 3;

    //Images
    Image backgroundImg;
    Image carImg;
    Image frogImg;

    //Frog
    int frogX = boardWidth/2;
    int frogY = boardHeight/2 + boardHeight/4 + boardHeight/8;
    int frogWidth = 15 * 3;
    int frogHeight = 15 * 3;

    class Frog {
        int x = frogX;
        int y = frogY;
        int width = frogWidth;
        int height = frogHeight;
        Image img;

        Frog(Image img) {
            this.img = img;
        }
    }

    // game logic
    Frog frog;
    int direction = -1;

    Timer gameLoop;

    Frogger() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./frogger_board.png")).getImage();
        frogImg = new ImageIcon(getClass().getResource("./frog.png")).getImage();
        carImg = new ImageIcon(getClass().getResource("./car.png")).getImage();

        //frog
        frog = new Frog(frogImg);

        //game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // System.out.println("draw");
        // background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
        
        // frog
        g.drawImage(frog.img, frog.x, frog.y,  frog.width, frog.height, null);
    }

    public void move() {
        //frog
        switch (direction) {
            case 0:
                frog.y = frog.y - frog.height;
                break;
            case 1:
                frog.x = frog.x + frog.width;
                break;
            case 2:
                frog.y = frog.y + frog.height;
                break;
            case 3:
                frog.x = frog.x - frog.width;
                break;
            default:
                break;
        }
        if (frog.x < 0) frog.x = 0;
        else if (frog.x > boardWidth - frog.width) frog.x = boardWidth - frog.width;
        if (frog.y < 0) frog.y = 0;
        else if (frog.y > boardHeight - frog.height) frog.y = boardHeight - frog.height;
        direction = -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_UP:
                direction = 0;
                break;
            case KeyEvent.VK_RIGHT:
                direction =  1;
                break;
            case KeyEvent.VK_DOWN:
                direction = 2;
                break;
            case KeyEvent.VK_LEFT:
                direction = 3;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
