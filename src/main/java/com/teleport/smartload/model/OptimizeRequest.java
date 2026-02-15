package com.teleport.smartload.model;

import java.util.List;

public class OptimizeRequest {

    private Truck truck;
    private List<Order> orders;

    public Truck getTruck() {
        return truck;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
