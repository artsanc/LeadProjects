import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    private int greenValue = 255;//used for healthbar effect

    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = (int) Game.clamp(HEALTH, 0, 100);

        greenValue = (int) Game.clamp(greenValue, 0, 255);//healthbar

        greenValue = HEALTH * 2;

        score++;
    }


    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(10, 15, 200, 32);
        //g.setColor(new Color(75,greenValue,0));//healthbar effect

        g.setColor(Color.getHSBColor((1f * HEALTH) / 360, 1f, 1f));
        g.fillRect(10, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(10, 15, 200, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);

        g.drawString(HEALTH + "%", 10, 12);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
