# api-mock-data

# Run the app and do the steps below for setting up the data.
1. Create a sku.
http://localhost:8080/data/sku/create?itemId=123456789&appliance=false

2. Create data for store inventory overlay
http://localhost:8080/data/sku/create/overlay?itemId=123456789&storeId=121&primary=bopis-2-SUPPRESS&nearby=boss|bopis-100|bopis-10-SUPPRESS

3. Hit the API URL to get the expected response
http://localhost:8080/ProductAPI/v2/products/sku/123456789/storefulfillment?keyword=121&localStoreId=121&type=json&key=tRXWvUBGuAwEzFHScjLw9ktZ0Bw7a335&callback=jQuery1124014115808590070378
