package OrderMaintainance;

import Utils.IdGenerator;

public class Order {
    private String orderId, orderType, orderDate, deliveryDate, address,
            status, movies, uname, movieId, province;

    public Order(String orderId, String orderType, String orderDate, String deliveryDate,
                 String address, String status, String title, String uname,
                 String movieId, String province) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.address = address;
        this.status = status;
        this.movies = title;
        this.uname = uname;
        this.movieId = movieId;
        this.province = province;
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

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order other = (Order) o;
        return other.orderType.equals(orderType) &&
                other.orderDate.equals(orderDate) && other.deliveryDate.equals(deliveryDate) &&
                other.address.equals(address) && other.status.equals(status) &&
                other.movies.equals(movies) && other.uname.equals(uname) &&
                other.province.equals(province);

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
                ", movies='" + movies + '\'' +
                ", uname='" + uname + '\'' +
                ", movieId='" + movieId + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
