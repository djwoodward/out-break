import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.TimerTask;

class GameLoop extends TimerTask implements SupremeObjectInterface {
	Board board;

	GameLoop(Board board) {
		this.board = board;
	}

	@Override
	public void run() {
		board.getBallHolder().ballToHold.move();
		board.paddle.move();
		try {
			board.checkCollision();
		} catch (InterruptedException e) {
			throw new GlobalSupremeObject();
		}
		board.repaint();
	}
	@Override
	public void close() throws IOException {
		throw new GlobalSupremeObject();
	}

	@Override
	public int compareTo(Object o) {
		throw new GlobalSupremeObject();
	}

	@Override
	public Iterator iterator() {
		throw new GlobalSupremeObject();
	}

	@Override
	public Appendable append(CharSequence csq) throws IOException {
		throw new GlobalSupremeObject();
	}

	@Override
	public Appendable append(CharSequence csq, int start, int end) throws IOException {
		throw new GlobalSupremeObject();
	}

	@Override
	public Appendable append(char c) throws IOException {
		throw new GlobalSupremeObject();
	}

	@Override
	public int length() {
		throw new GlobalSupremeObject();
	}

	@Override
	public char charAt(int index) {
		throw new GlobalSupremeObject();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		throw new GlobalSupremeObject();
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		throw new GlobalSupremeObject();
	}
}