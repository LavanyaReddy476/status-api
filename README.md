# status-api
Java Spring boot API with status check

Pre-requisits:
Java 17+
Maven
IDE with spring support
Git

Run instructions :
update maven project
Run as spring boot app


3 apis are available :
URL path: /v1/all-status
Response Sample : 
[{"url":"https://www.amazon.com","statusCode":503,"duration":310,"date":1683212310542},{"url":"https://www.google.com","statusCode":200,"duration":274,"date":1683212310816}]
/v1/google-status
Response Sample : {"url":"https://www.google.com","statusCode":200,"duration":249,"date":1683212328456}
/v1/amazon-status
Response Sample : {"url":"https://www.amazon.com","statusCode":503,"duration":237,"date":1683212332133}

# Documentation using swagger
root is pointing to swagger-ui which is added for manual testing and documentation purpose
open-api url {end-point}/api-docs

# Note : to avoid cross origin access, manual addition of endpoint is done in controller. As of now, it is localhost:3000
