# giftService


order
	has 1 or many giftwraps
	associates with user
	createdDate
	wrapDate
	location
user
	id
	email
	
giftwrap
	box
	wrappingPaper
	ribon
	accessorties
	orderId
	
box
	id
	name
	length
	width

wrappingPaper
	name
	style

ribon
	name
	color
	

# AvailableTimeService



2 pages
order page for customer
orders page for admin. magicWoman

https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-mysql-springdatajpa-hibernate
https://github.com/arenfa/CraftDemoTwitter


# how to run
mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

# What to do
predesign gifts

submit order
	show date picker from tommorrow and on. no saturday sunday have validations. show available times from backend based on the chosen day
	show modal on submit order success with text
	Validation of times: validate and show the best time with accept button, and No I will choose
	Validation of zipcodes
	credit card charge. integrate and charge $10 hold. 
	https://developer.squareup.com/docs/payment-form/overview
	see https://developer.squareup.com/docs/checkout-api-overview
	https://github.com/square/connect-api-examples/tree/master/connect-examples/v2/java_payment
	deploy aws
	email to us and customer

	
Design UI

UI
	- Styles: PRE_DESIGNED, CUSTOM, NO_MATERIAL
prices on page
zip codes
	- UI validation on some zip codes
email
	- Use https://aws.amazon.com/ses/pricing/
domain name to aws. aws installation
restrictions. no mavad and aslahae wrap
