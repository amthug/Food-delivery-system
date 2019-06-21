package pojos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeliveryExecutive {

	private int id;
	private String current_location;
	private String last_order_delivered_time;
	private Location location;
	private LocalDateTime last_order_time;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public LocalDateTime getLast_order_time() {
		return last_order_time;
	}

	public void setLast_order_time(LocalDateTime last_order_time) {
		this.last_order_time = last_order_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrent_location() {
		return current_location;
	}

	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}

	public String getLast_order_delivered_time() {
		return last_order_delivered_time;
	}

	public void setLast_order_delivered_time(String last_order_delivered_time) {
		this.last_order_delivered_time = last_order_delivered_time;
	}

	public void setLatLong(String location) {
		String[] coordinates = location.split(",");
		this.setLocation(new Location(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
	}

	public void setLastOrderTime(String lastOrderTime) {
		this.setLast_order_time(LocalDateTime.parse(lastOrderTime, formatter));
	}
}
