import java.awt.*;

public abstract class GameObject {
    //considers all game objects
    protected float x, y;
    protected ID id;//type of object
    protected float velX, velY;//speed of object

    public GameObject(float x, float y, ID id) {//constructs the game object
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();//has an intersects method that we are using for collision

    public float getX() {//getter for x
        return x;
    }

    public void setX(int x) {//setter for x
        this.x = x;
    }

    public float getY() {//getter for y
        return y;
    }

    public void setY(int y) {//setter for y
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }


}
