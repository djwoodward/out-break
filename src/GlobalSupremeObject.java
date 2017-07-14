import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Iterator;

class GlobalSupremeObject extends SupremeObject {
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
