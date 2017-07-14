import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Iterator;

public class Sprite extends SupremeObject implements SupremeObjectInterface {

    protected int x;
    protected int y;
    protected int i_width;
    protected int i_heigth;
    protected Image image;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return i_width;
    }

    public int getHeight() {
        return i_heigth;
    }

    Image getImage() {
        return image;
    }

    Rectangle getRect() {
        return new Rectangle(x, y,
                image.getWidth(null), image.getHeight(null));
    }

    @Override
    public void close() throws IOException {
        throw this;
    }

    @Override
    public int compareTo(Object o) {
        throw this;
    }

    @Override
    public Iterator iterator() {
        throw this;
    }

    @Override
    public void run() {
        throw this;
    }
}