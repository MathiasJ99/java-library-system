import java.util.Comparator;

public class PriceCompare implements Comparator<Books>
{	@Override
	public int compare(Books b1, Books b2) {
	if (b1.getRetailPrice()< b2.getRetailPrice()) {
		int i =-1;
		return i;
	}
		
	if (b1.getRetailPrice()> b2.getRetailPrice()) return 1;
	else return 0;

	}

	

}