package criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import comparators.DEComparator;
import comparators.OrderComparator;
import pojos.AssignedOrders;
import pojos.DeliveryExecutive;
import pojos.Order;
import utils.HaversineDistance;

public class OrderPriority {

	public List<AssignedOrders> assignOrders(List<Order> orders, List<DeliveryExecutive> deliveryExecutives) {
		List<AssignedOrders> result = new ArrayList<AssignedOrders>();
		Collections.sort(orders, new OrderComparator());
		Collections.sort(deliveryExecutives, new DEComparator());

		Iterator<Order> ordersIterator = orders.iterator();
		while (ordersIterator.hasNext()) {
			Order order = ordersIterator.next();
			TreeMap<Double, List<DeliveryExecutive>> distances = new TreeMap<Double, List<DeliveryExecutive>>();

			Iterator<DeliveryExecutive> deliveryExecutivesIterator = deliveryExecutives.iterator();
			while (deliveryExecutivesIterator.hasNext()) {
				DeliveryExecutive deliveryExecutive = deliveryExecutivesIterator.next();

				Double haversineD = HaversineDistance.distance(order.getLocation().getLatitude(),
						order.getLocation().getLongitude(), deliveryExecutive.getLocation().getLatitude(),
						deliveryExecutive.getLocation().getLongitude());
				if (distances.containsKey(haversineD)) {
					distances.get(haversineD).add(deliveryExecutive);
				} else {
					List<DeliveryExecutive> deliveryExecutives1 = new ArrayList<DeliveryExecutive>();
					deliveryExecutives1.add(deliveryExecutive);
					distances.put(haversineD, deliveryExecutives1);
				}
			}
			Map.Entry<Double, List<DeliveryExecutive>> s = distances.firstEntry();
			DeliveryExecutive deliveryExecutive = s.getValue().get(0);
			result.add(new AssignedOrders(order.getId(), deliveryExecutive.getId()));
			deliveryExecutive.getLocation().setLatitude(order.getLocation().getLatitude());
			deliveryExecutive.getLocation().setLongitude(order.getLocation().getLongitude());
		}
		return result;
	}
}
