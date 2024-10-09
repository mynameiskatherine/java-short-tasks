package Test;

public abstract class OurAbstractClass {
    public OurAbstractClass() {
        System.out.println("This is abstract class constructor");
    }
}
class OurDemoClass extends OurAbstractClass {
    public OurDemoClass() {
        System.out.println("This is demo class constructor");
    }
    public static void main(String[] args) {
        OurDemoClass ourDemoClass = new OurDemoClass();
    }
}
