import java.io.Closeable;
import java.io.Serializable;

/**
 * If our objects implement all interfaces, we can pass objects everwhere and not have to worry about those pesky
 * types getting in our way
 */
public interface SupremeObject extends Comparable, Serializable, Cloneable, Closeable, Runnable, Iterable {

}
