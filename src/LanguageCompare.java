import java.util.Comparator;

public class LanguageCompare implements Comparator<Books>
{
	public int compare(Books b1, Books b2) {
		return b1.getLanguage().compareTo(b2.getLanguage());
}
}
