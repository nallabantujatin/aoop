import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// 1. Customer Class
class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', email='" + email + "'}";
    }
}

// 2. Order Class (Implements Comparable and Cloneable)
class Order implements Comparable<Order>, Cloneable {
    private int orderId;
    private Customer customer;
    private double totalPrice;
    private Date orderDate;

    public Order(int orderId, Customer customer, double totalPrice, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderId, other.orderId);
    }

    @Override
    public Order clone() {
        try {
            return (Order) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", customer=" + customer +
                ", totalPrice=" + totalPrice + ", date=" + orderDate + "}";
    }
}

// 3. Order Comparators (Implements Comparator)
class OrderByTotalPriceComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return Double.compare(o1.getTotalPrice(), o2.getTotalPrice());
    }
}

class OrderByDateComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getOrderDate().compareTo(o2.getOrderDate());
    }
}

class OrderByCustomerNameComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getCustomer().getName().compareTo(o2.getCustomer().getName());
    }
}

// 4. OrderProcessor Class (Implements Iterable)
class OrderProcessor implements Iterable<Order> {
    private List<Order> orders;

    public OrderProcessor() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getOrderId() == orderId);
    }

    public void sortOrdersBy(Comparator<Order> comparator) {
        Collections.sort(orders, comparator);
    }

    public Order findOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public Order cloneOrder(int orderId) {
        Order order = findOrder(orderId);
        if (order != null) {
            return order.clone();
        }
        return null;
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}

// 5. Main Class (Demonstrates the System)
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", "alice@example.com");
        Customer customer2 = new Customer("Bob", "bob@example.com");

        Order order1 = new Order(1, customer1, 250.50, new Date());
        Order order2 = new Order(2, customer2, 150.75, new Date());
        Order order3 = new Order(3, customer1, 300.00, new Date());

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(order1);
        orderProcessor.addOrder(order2);
        orderProcessor.addOrder(order3);

        System.out.println("Original Order List:");
        for (Order order : orderProcessor) {
            System.out.println(order);
        }

        System.out.println("\nSorting by Total Price:");
        orderProcessor.sortOrdersBy(new OrderByTotalPriceComparator());
        for (Order order : orderProcessor) {
            System.out.println(order);
        }

        System.out.println("\nSorting by Customer Name:");
        orderProcessor.sortOrdersBy(new OrderByCustomerNameComparator());
        for (Order order : orderProcessor) {
            System.out.println(order);
        }

        System.out.println("\nCloning Order with ID 2:");
        Order clonedOrder = orderProcessor.cloneOrder(2);
        System.out.println("Cloned Order: " + clonedOrder);
    }
}
