# E-Commerce Project

## Overview
This Spring Boot project is an e-commerce platform designed to facilitate transactions between sellers and customers. It provides APIs for sellers to add their details and items, customers to add their details, manage their carts, and complete transactions. 

##[Demo video using Swagger to test API's](https://drive.google.com/file/d/1SUsNK2uO5-dTuuIseB16b9iJTI11ftzq/view?usp=drivesdk)

## Dependencies
- Starter-web
- JPA
- SQL driver
- Lombok
- Swagger

## APIs

### Sellers
- **Add Seller Details**
  - Method: POST
  - Endpoint: /api/sellers
  - Description: Allows sellers to add their details.

- **Add Item by Seller**
  - Method: POST
  - Endpoint: /api/sellers/{sellerEmail}/items
  - Description: Allows sellers to add items using their email after adding their details.

### Customers
- **Add Customer Details**
  - Method: POST
  - Endpoint: /api/customers
  - Description: Allows customers to add their details.

- **Add Card Details for Transaction**
  - Method: POST
  - Endpoint: /api/customers/{customerId}/cards
  - Description: Allows customers to add card details for transactions.

- **Add Items to Cart**
  - Method: POST
  - Endpoint: /api/customers/{customerId}/cart/items
  - Description: Allows customers to add items to their cart.

- **Checkout Cart**
  - Method: POST
  - Endpoint: /api/customers/{customerId}/cart/checkout
  - Description: Allows customers to checkout items from their cart using their card details.

- **Place Order Directly**
  - Method: POST
  - Endpoint: /api/orders
  - Description: Allows placing an order directly without using the cart.

- **View Products by Category and Price**
  - Method: GET
  - Endpoint: /api/products?category={category}&priceGreaterThan={price}
  - Description: Allows viewing products by category and price greater than a specified amount.

