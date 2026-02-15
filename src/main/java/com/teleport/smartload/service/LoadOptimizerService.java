package com.teleport.smartload.service;

import com.teleport.smartload.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadOptimizerService {

    public OptimizeResponse optimize(OptimizeRequest request) {

        Truck truck = request.getTruck();
        List<Order> orders = request.getOrders();

        if (orders == null || orders.isEmpty()) {
            OptimizeResponse response = new OptimizeResponse();
            response.setTruck_id(truck.getId());
            response.setSelected_order_ids(new ArrayList<>());
            response.setTotal_payout_cents(0);
            response.setTotal_weight_lbs(0);
            response.setTotal_volume_cuft(0);
            response.setUtilization_weight_percent(0.0);
            response.setUtilization_volume_percent(0.0);
            return response;
        }

        int n = orders.size();
        long bestPayout = 0;
        int bestMask = 0;

        int totalMasks = 1 << n;

        for (int mask = 0; mask < totalMasks; mask++) {
            long weight = 0;
            long volume = 0;
            long payout = 0;
            String origin = null;
            String destination = null;
            boolean hazmatFound = false;
            boolean hazmatMixed = false;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    Order o = orders.get(i);
                    weight += o.getWeight_lbs();
                    volume += o.getVolume_cuft();
                    payout += o.getPayout_cents();

                    if (weight > truck.getMax_weight_lbs() || volume > truck.getMax_volume_cuft()) {
                        valid = false;
                        break;
                    }

                    if (origin == null) {
                        origin = o.getOrigin();
                        destination = o.getDestination();
                        hazmatFound = o.isIs_hazmat();
                    } else {
                        if (!origin.equals(o.getOrigin()) || !destination.equals(o.getDestination())) {
                            valid = false;
                            break;
                        }
                        if (hazmatFound != o.isIs_hazmat()) {
                            hazmatMixed = true;
                        }
                    }

                    if (o.getPickup_date() != null && o.getDelivery_date() != null && o.getPickup_date().isAfter(o.getDelivery_date())) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid || hazmatMixed) continue;

            if (payout > bestPayout) {
                bestPayout = payout;
                bestMask = mask;
            }
        }

        List<String> selected = new ArrayList<>();
        long totalWeight = 0;
        long totalVolume = 0;

        for (int i = 0; i < n; i++) {
            if ((bestMask & (1 << i)) != 0) {
                Order o = orders.get(i);
                selected.add(o.getId());
                totalWeight += o.getWeight_lbs();
                totalVolume += o.getVolume_cuft();
            }
        }

        OptimizeResponse response = new OptimizeResponse();
        response.setTruck_id(truck.getId());
        response.setSelected_order_ids(selected);
        response.setTotal_payout_cents(bestPayout);
        response.setTotal_weight_lbs(totalWeight);
        response.setTotal_volume_cuft(totalVolume);
        response.setUtilization_weight_percent(
                totalWeight == 0 ? 0.0 : Math.round(((double) totalWeight * 100 / truck.getMax_weight_lbs()) * 100.0) / 100.0
        );
        response.setUtilization_volume_percent(
                totalVolume == 0 ? 0.0 : Math.round(((double) totalVolume * 100 / truck.getMax_volume_cuft()) * 100.0) / 100.0
        );

        return response;
    }
}