package domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name="table_order")
public class Order {

	@Id
	@GeneratedValue
	private int ordernumber;
	private String date;
	private String status;
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToMany(cascade=CascadeType.ALL,  fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(int ordernumber, String date, String status) {
		this.ordernumber = ordernumber;
		this.date = date;
		this.status = status;
	}

	public void setOrderlines(Collection<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

	@Override
	public String toString() {
		return "Order{" +
				"ordernumber=" + ordernumber +
				", date='" + date + '\'' +
				", status='" + status + '\'' +
				", customer=" + customer +
				", orderlines=" + orderlines +
				'}';
	}
}
