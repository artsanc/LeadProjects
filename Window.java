import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(int width, int height, String title, Game game) {
        /*
        Builds frame/window of game
         */
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes the game "x at top right corner"
        frame.setResizable(false);//no resize
        frame.setLocationRelativeTo(null);//trick to make window in center of screen
        frame.add(game);//adds game to window
        frame.setVisible(true);//allows us to see it
        game.start();
    }

}
