package comparators;

import java.util.Comparator;

import pojos.Order;

public class OrderComparator implements Comparator<Order> {

	@Override
	public int compare(final Order obj1, final Order obj2) {
		return obj1.getLast_order_time().compareTo(obj2.getLast_order_time());
	}

}
