# Snipped-Server
REST API on Springboot for Snipped - A salon booking app.


## FAQ

@PostMapping(value="/faq")
	public Response insert(
			@RequestParam String ques,
			@RequestParam String ans)
      
@GetMapping(value="/faq")
	public Response getAllFaqs()
  
@DeleteMapping(value="faq")
	public String delete(@RequestParam String id)
  
  
## MAIL

@PostMapping(value="/mail/order_placed")
	public String sendEmail(@RequestParam String email)
  
  
##ORDER

@PostMapping(value="/order")
	public Response insert(
			@RequestParam String phone,
			@RequestParam String services,
			@RequestParam int amount,
			@RequestParam String address,
			@RequestParam String date,
			@RequestParam String time,
			@RequestParam String appointmentDate,
			@RequestParam String appointmentTime,
			@RequestParam String status,
			@RequestParam String remarks)


@GetMapping(value="/order")
	public Response getOrderByUser(@RequestParam String phone)
  
  
## PUSH NOTIFICATIONS

@PostMapping(value = "/send_notification", produces = "application/json")
	public ResponseEntity<String> send(
			@RequestParam String topic,
			@RequestParam String title,
			@RequestParam String text)


## SERVICES

@PostMapping(value="/service/{category}/{subcategory}")
	public Response insertService(@RequestParam String name,
			@RequestParam int price,
			@PathVariable String category,
			@PathVariable String subcategory,
			@RequestParam String gender)

@GetMapping(value="/service")
	public Response getAllServices()

@GetMapping(value="/service/{category}")
	public Response getServicesByCategory(@PathVariable String category)

@GetMapping(value="/service/id/{idstring}")
	public Response getServicesById(@PathVariable String idstring)


## SLIDER

@GetMapping(value="/get_all_images")
	public Response getAllImages()


USER

@PostMapping("/user")
	public boolean insertUser(@RequestParam String email, 
			@RequestParam String name, 
			@RequestParam String phone)

@PostMapping("/user")
	public boolean insertUser(@RequestParam String email, 
			@RequestParam String name, 
			@RequestParam String phone)

@GetMapping("/user/{phone}")
	public Response getUserByPhone(@PathVariable String phone)

@GetMapping("/user")
	public Response getAllUsers() 
