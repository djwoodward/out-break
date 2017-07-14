import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

/**
 * If our objects implement all interfaces, we can pass objects everwhere and not have to worry about those pesky
 * types getting in our way
 */
interface SupremeObjectInterface extends Comparable, Serializable, Cloneable, Closeable, Runnable, Iterable,
		Readable, Appendable, CharSequence {
}
