public class Value extends Gen {
    int value;

    Value(Object obj) {
        super(obj);
        this.value= (int) getobj(obj);
    }


    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }

}
