import java.util.Comparator;

public class TitleCompare implements Comparator<Books>
{
	public int compare(Books b1, Books b2) {
		return b1.getTitle().compareTo(b2.getTitle());
}
}
