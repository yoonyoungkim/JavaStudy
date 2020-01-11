package generic;

public class BoxGeneric<T> {
    private T box;

    public BoxGeneric() {
    }

    public BoxGeneric(T box) {
        this.box = box;
    }

    public void set(T box) {
        this.box = box;
    }

    public T get() {
        return this.box;
    }
}
