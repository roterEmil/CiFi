import edu.cmu.cs.glacier.qual.*;

public class ConcreteClassTypeIsKnown {

    @Immutable
    public final Object knownObject = new Object();

    private Object unknownObject;

    public ConcreteClassTypeIsKnown(Object object) {
        this.unknownObject = object;
    }
}
