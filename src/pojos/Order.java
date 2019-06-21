package pojos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

	private String restaurant_location, ordered_time;
	private Integer id;
	private Location location;
	private LocalDateTime last_order_time;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public LocalDateTime getLast_order_time() {
		return last_order_time;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setLast_order_time(LocalDateTime last_order_time) {
		this.last_order_time = last_order_time;
	}

	public String getRestaurant_location() {
		return restaurant_location;
	}

	public void setRestaurant_location(String restaurant_location) {
		this.restaurant_location = restaurant_location;
	}

	public String getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(String ordered_time) {
		this.ordered_time = ordered_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLatLong(String location) {
		String[] coordinates = location.split(",");
		this.setLocation(new Location(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
	}

	public void setLastOrderTime(String lastOrderTime) {
		this.setLast_order_time(LocalDateTime.parse(lastOrderTime, formatter));
	}

	@Override
	public String toString() {
		return getId() + ", " + getLast_order_time();
	}

}
