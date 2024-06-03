import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 271;
        int boardHeight = 193;

        JFrame frame = new JFrame("FROGGER");
        
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Frogger frogger = new Frogger();
        frame.add(frogger);
        frame.pack();
        frame.setVisible(true);
    }
}
