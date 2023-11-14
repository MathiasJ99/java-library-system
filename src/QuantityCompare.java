import java.util.Comparator;

public class QuantityCompare implements Comparator<Books>
{	@Override
	public int compare(Books b1, Books b2) {
	if (b1.getQuantityInStock()< b2.getQuantityInStock()) {
		int i =-1;
		return i;
	}
		
	if (b1.getQuantityInStock()> b2.getQuantityInStock()) return 1;
	else return 0;

	}

	

}