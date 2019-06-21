package comparators;

import java.util.Comparator;

import pojos.DeliveryExecutive;

public class DEComparator implements Comparator<DeliveryExecutive> {

	@Override
	public int compare(final DeliveryExecutive obj1, final DeliveryExecutive obj2) {
		return obj1.getLast_order_time().compareTo(obj2.getLast_order_time());
	}

}
