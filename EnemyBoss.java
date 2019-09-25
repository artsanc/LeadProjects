import javax.management.relation.RelationNotFoundException;
import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject {

    private Handler handler;

    Random r = new Random();

    private int timer = 80;

    private int timer2 = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (float) 0;
        velY = (float) .50;
    }

    public Rectangle getBounds() {//collision method
        return new Rectangle((int) x, (int) y, 96, 96);
    }

    public void tick() {

        x += velX;
        y += velY;

        if (timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }

        if (timer <= 0) {
            timer2--;
        }
        if (timer2 <= 0) {
            if (velX == 0) {
                velX = (float).25;
            }

            int spawn = r.nextInt(10);

            if (spawn ==0){
              handler.addObject(new EnemyBossBullet((int)x+48,(int)y+48,ID.BasicEnemy,handler));
            }
        }


        if (x <= 0 || x >= Game.WIDTH - 96) {
            velX *= -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.02f, handler));


    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 96, 96);
    }
}

