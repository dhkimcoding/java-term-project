import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Frogger extends JPanel {
    int boardWidth = 271;
    int boardHeight = 193;

    //Images
    Image backgroundImg;
    Image carImg;
    Image frogImg;

    Frogger() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./frogger_board.png")).getImage();
        frogImg = new ImageIcon(getClass().getResource("./frog.png")).getImage();
        carImg = new ImageIcon(getClass().getResource("./car.png")).getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
    }
}
