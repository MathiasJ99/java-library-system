import java.util.Comparator;

public class GenreCompare implements Comparator<Books>
{
	public int compare(Books b1, Books b2) {
		return b1.getGenre().compareTo(b2.getGenre());
}
}
