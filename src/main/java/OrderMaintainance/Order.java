package OrderMaintainance;

public class Order {
    private String orderId, orderType, orderDate, deliveryDate, address, status, title, uname;

    public Order(String orderId, String orderType, String orderDate, String deliveryDate,
                 String address, String status, String title, String uname) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.address = address;
        this.status = status;
        this.title = title;
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
