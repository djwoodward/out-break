import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.nio.CharBuffer;
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

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        throw this;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        throw this;
    }

    @Override
    public Appendable append(char c) throws IOException {
        throw this;
    }

    @Override
    public int length() {
        throw this;
    }

    @Override
    public char charAt(int index) {
        throw this;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        throw this;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        throw this;
    }
}