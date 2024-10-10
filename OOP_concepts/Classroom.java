public abstract class Classroom extends Departments implements Create {
    private String act;
    private String authority;

    public Classroom(int sr_no, String name, String city, String state, String act, String authority) {
        super(sr_no, name, city, state, act, authority);
        this.act = act;
        this.authority = authority;
    }
    public Classroom(){
        super();
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();

    // Getters for act and authority
    public String getAct() {
        return act;
    }

    public String getAuthority() {
        return authority;
    }
}
