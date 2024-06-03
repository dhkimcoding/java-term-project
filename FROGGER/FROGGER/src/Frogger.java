import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Frogger extends JPanel {
    int boardWidth = 271 * 3;
    int boardHeight = 193 * 3;

    //Images
    Image backgroundImg;
    Image carImg;
    Image frogImg;

    //Frog
    int frogX = boardWidth / 2;
    int frogY = boardHeight/2 + boardHeight / 4 + boardHeight/8;
    int frogWidth = 14 * 3;
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

    Frogger() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./frogger_board.png")).getImage();
        frogImg = new ImageIcon(getClass().getResource("./frog.png")).getImage();
        carImg = new ImageIcon(getClass().getResource("./car.png")).getImage();

        frog = new Frog(frogImg);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
        g.drawImage(frog.img, frog.x, frog.y,  frog.width, frog.height, null);
    }
}
