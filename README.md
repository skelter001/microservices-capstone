# Microservices capstone

## Table of content:

1. [Download](#Download)
2. [Services](#Services)
3. [Set up](#setup)


## Download

```git clone https://github.com/xaghoul/microservices-capstone.git```

## Services
- Catalog service:
  - Holds online store product data in-memory from the product data set above. 
    The application exposes REST API for retrieving products by ‘uniq_id’ and list of products by ‘sku’.
- Inventory service:
  - Holds online store product availability data. Generate random availability status 
    for each product from the product data set above and keep it in an in-memory data structure. 
    The application exposes REST API for retrieving product availability by a list of ‘uniq_id’.
- Product service:
  - Returns product data to end-clients. The application exposes 
    REST API for retrieving available products data by ‘uniq_id’ and by ‘sku’ (multiple products are returned). 
    The REST service makes REST call to catalog application to get product data by ‘uniq_id’ or by ‘sku’, 
    and make a call to the inventory application to get product availability and filter out only available product before returning.
- Eureka service:
  - Registering applications and discovering them for inter-component REST calls.
##   
Using Resilience4j for protecting inter-component REST calls from the product application. 
The fallback behavior is supposed to result in ‘503 service unavailable’ in case of unavailability of any dependant services. 
Using sleuth request tracing through the inter-component REST calls and the Zipkin server for monitoring request flow and latency.

<a name="setup"></a>
## Set up 

### Sample dataset
https://www.kaggle.com/PromptCloudHQ/all-jc-penny-products

### Load data from dataset [Optional]:
Warning: you should use GNU awk to execute query above

```
docker cp <path-to-csv-file>/data.csv product_container:/data.csv
awk -vFPAT='([^,]*)|("[^"]+")' -vOFS=, '{print $1, $2}' /data.csv | head -10 | psql -U admin -d product_database -c "\COPY product(uniq_id, sku) FROM STDIN WITH (FORMAT CSV, HEADER"
```

- Up docker container: 
```
cd <path-to-project>/catalog-app
docker build -f Dockerfile
docker-compose up
```

- To up zipkin server: 

``docker run -d -p 9411:9411 openzipkin/zipkin``