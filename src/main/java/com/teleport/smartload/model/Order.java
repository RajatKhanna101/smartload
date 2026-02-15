package com.teleport.smartload.model;

import java.time.LocalDate;

public class Order {

    private String id;
    private long payout_cents;
    private long weight_lbs;
    private long volume_cuft;
    private String origin;
    private String destination;
    private LocalDate pickup_date;
    private LocalDate delivery_date;
    private boolean is_hazmat;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getPayout_cents() {
        return payout_cents;
    }
    public void setPayout_cents(long payout_cents) {
        this.payout_cents = payout_cents;
    }
    public long getWeight_lbs() {
        return weight_lbs;
    }
    public void setWeight_lbs(long weight_lbs) {
        this.weight_lbs = weight_lbs;
    }
    public long getVolume_cuft() {
        return volume_cuft;
    }
    public void setVolume_cuft(long volume_cuft) {
        this.volume_cuft = volume_cuft;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public LocalDate getPickup_date() {
        return pickup_date;
    }
    public void setPickup_date(LocalDate pickup_date) {
        this.pickup_date = pickup_date;
    }
    public LocalDate getDelivery_date() {
        return delivery_date;
    }
    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }
    public boolean isIs_hazmat() {
        return is_hazmat;
    }
    public void setIs_hazmat(boolean is_hazmat) {
        this.is_hazmat = is_hazmat;
    }

}