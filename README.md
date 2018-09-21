# CoffeeMachine

# Get cup of coffee
* **Title :** 

  Get cup of coffee.

* **URL :** 

  /getCoffee?type=:type

* **Method :** 

  GET

* **URL Params :** 

  **Required:** 

  type=[string]

* **Success response content:** 

  {"waterReservoir":{"amount":[integer]},"milkReservoir":{"amount":[integer]},"beansReservoir":{"amount":[integer]},"status":"You got a cup of :type"}

* **Response Codes:**

  Success (200 OK)

# Clean machine
* **Title :** 

  Clean machine.

* **URL :** 

  /clean

* **Method :** 

  GET

* **Success response content :**

  {"waterReservoir":{"amount":[integer]},"milkReservoir":{"amount":[integer]},"beansReservoir":{"amount":[integer]},"status":"Coffee Machine has cleaned."}

* **Response Codes :**

  Success (200 OK)

# Add materials
* **Title :** 

  Add materials.

* **URL :** 

  /addMaterial

* **Method :** 

  GET

* **URL Params :** 

  **Required:** 

  type=[string] 
  
  amount=[integer]

* **Success response content :** 

  {"waterReservoir":{"amount":[integer]},"milkReservoir":{"amount":[integer]},"beansReservoir":{"amount":[integer]},"status":":type successfully added."}

* **Response Codes :** 

  Success (200 OK)