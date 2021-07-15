import edu.cmu.cs.glacier.qual.*;

@Immutable
public class Test {
	
	@Immutable
	public int n = 8;
	
	//public java.util.Date date;
	
	public int i = 9;

	public String string = "name";
	
	//@Immutable
	public Mutable mutable; // = new Mutable();
	
	//public Test(){
	//	mutable.n = 10;
	//}
	
}

@Immutable
final class Mutable {

public int n = 8;
}
