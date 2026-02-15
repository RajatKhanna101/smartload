🚛 <b>SmartLoad Optimization API</b>

A high-performance Spring Boot microservice for optimizing truck load planning and maximizing carrier revenue.
<br/>

📖 <b>Overview</b>
<br/>
SmartLoad Optimization API is a Spring Boot microservice that helps truck carriers find the most profitable combination of shipments their truck can carry. The service maximizes revenue while respecting weight, volume, route, hazmat, and time constraints. It is fully stateless and runs entirely in-memory.

✨ <b>Features</b>
<br/>
✅ Selects the optimal set of orders for maximum payout
✅ Respects truck weight and volume limits
✅ Ensures route and hazmat compatibility
✅ Checks pickup and delivery time windows
✅ Fast and efficient using bitmask dynamic programming
✅ Dockerized and production-ready
✅ Input validation with proper HTTP error handling

🚀 <b>Quick Start</b>
<br/>
git clone https://github.com/RajatKhanna101/smartload.git
<br/>
cd smartload
<br/>
docker compose up --build
<br/>
→ Service will be available at http://localhost:8080
