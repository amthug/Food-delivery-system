package driver;

import java.io.FileInputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import criteria.OrderPriority;
import pojos.AssignedOrders;
import pojos.DeliveryExecutive;
import pojos.Order;

public class Driver {

	public static void main(String args[]) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<DeliveryExecutive> deliveryExecutives = mapper.readValue(
					new FileInputStream("C://Users/Shubhank/eclipse-workspace/swiggy/src/input/deliveryExecutive.json"),
					new TypeReference<List<DeliveryExecutive>>() {
					});
			List<Order> orders = mapper.readValue(
					new FileInputStream("C://Users/Shubhank/eclipse-workspace/swiggy/src/input/orders.json"),
					new TypeReference<List<Order>>() {
					});

			for (Order order : orders) {
				order.setLatLong(order.getRestaurant_location());
				order.setLastOrderTime(order.getOrdered_time());
			}
			for (DeliveryExecutive deliveryExecutive : deliveryExecutives) {
				deliveryExecutive.setLatLong(deliveryExecutive.getCurrent_location());
				deliveryExecutive.setLastOrderTime(deliveryExecutive.getLast_order_delivered_time());
			}
			getAssignment(orders, deliveryExecutives);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void getAssignment(List<Order> orders, List<DeliveryExecutive> deliveryExecutives) {
		OrderPriority assignmentCriteria = new OrderPriority();
		List<AssignedOrders> results = assignmentCriteria.assignOrders(orders, deliveryExecutives);
		for (AssignedOrders result : results) {
			System.out.println("OrderId : " + result.getOrderId() + " DEId : " + result.getDeliveryExecutiveId());
		}
	}
}
