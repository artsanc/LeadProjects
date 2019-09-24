import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {


    public static final int WIDTH = 640;//width of frame
    public static final int HEIGHT = WIDTH / 12 * 9;//height of frame
    private Thread thread;//thread that game will run on
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Wave by Arturo Sanchez", this);//constructs window

        hud = new HUD();
        spawner = new Spawn(handler, hud);
        r = new Random();//initializes r

        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));//adds objects

        //handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, (Game.HEIGHT/2) -215, ID.EnemyBoss, handler));


    }

    public static float clamp(float var, float min, float max) {//so the players stays in the window
        if (var >= max) {
            var = max;
            return var;
        } else if (var <= min) {
            var = min;
            return var;
        } else {
            return var;
        }
    }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();//starts the thread/game
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();//kills the thread, stops game
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //game loop!
        this.requestFocus();//runs without having to be clicked
        long lastTime = System.nanoTime();
        double amountofTicks = 60.0;
        double ns = 100000000 / amountofTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS: "+ frames);
                frames = 0;

            }
        }
        stop();

    }

    private void tick() {

        handler.tick();
        hud.tick();
        spawner.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();//creates buffers
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.black);//sets frame color
        g.fillRect(0, 0, WIDTH, HEIGHT);//fills whole rectangle

        handler.render(g);

        hud.render(g);

        g.dispose();
        bs.show();

    }
}
