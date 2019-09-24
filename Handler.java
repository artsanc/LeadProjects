import java.awt.*;
import java.util.LinkedList;

public class Handler {
    //updates and renders all objects in our game

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        //loops through all out objects
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);//gets object in list

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }

    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
