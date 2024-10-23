public class Gen<T> {
    // T is any datatype object
    T obj;
    Gen(T obj) {this.obj = obj;}



    public T getobj(T obj){
        return obj;
    }

    @Override
    public String toString() {
        return "Gen{" +
                "obj=" + obj +
                '}';
    }
}
