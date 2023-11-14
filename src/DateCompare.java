import java.util.Comparator;

public class DateCompare implements Comparator<Books>
{	@Override
	public int compare(Books o1, Books o2) {
    	return o1.getRelaseDateDate().compareTo(o2.getRelaseDateDate());
	}


}