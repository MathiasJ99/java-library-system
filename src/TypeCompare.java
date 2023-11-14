import java.util.Comparator;

public class TypeCompare implements Comparator<Books>
{
	public int compare(Books b1, Books b2) {
		return b1.getType().compareTo(b2.getType());
}
}
