#For API Documentation 
open -> Swagger UI - http://localhost:8090/swagger-ui.html

# To monitor middleware
1. Run Prometheus.exe and hit this URL -> http://localhost:9090/
2. Run grafana-server.exe and hit this URL ->http://localhost:3000
3. Configure Prometheus url in Grafana and add Query.

# Centralize Logging Monitoring
1. Run Elasticsearch.bat in cmd from bin folder and verify by hitting http://localhost:9200
2. Run kibana.bat in cmd from bin folder and verify by hitting http://localhost:5601
3. Run logstash -f logstash.conf in cmd from bin folder to start the logstash.
