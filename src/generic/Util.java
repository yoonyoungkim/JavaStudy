package generic;

public class Util {
    public static <T> BoxGeneric<T> boxing(T t) {
        BoxGeneric<T> box = new BoxGeneric<>();
        box.set(t);
        return box;
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());

        return keyCompare && valueCompare;
    }

    public static <T extends Number> int compareNumber(T t1, T t2) {
        return Double.compare(t1.doubleValue(), t2.doubleValue());
    }
}
