SmartLoad Optimization API
Overview

SmartLoad Optimization API is a Spring Boot microservice that helps truck carriers find the most profitable combination of shipments their truck can carry. The service maximizes revenue while respecting weight, volume, route, hazmat, and time constraints. It is fully stateless and runs entirely in memory.

Features

Selects the optimal set of orders for maximum payout

Respects truck weight and volume limits

Ensures route and hazmat compatibility

Checks pickup and delivery time windows

Fast and efficient using bitmask dynamic programming

Dockerized and production-ready

Input validation with proper HTTP error handling
