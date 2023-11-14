import java.util.Comparator;

public class BarcodeCompare implements Comparator<Books>
{	@Override
	public int compare(Books b1, Books b2) {
	if (b1.getBarcode()< b2.getBarcode()) {
		int i =-1;
		return i;
	}
		
	if (b1.getBarcode()> b2.getBarcode()) return 1;
	else return 0;

	}

	

}