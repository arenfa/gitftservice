$( document ).ready(function() {
	var order = { giftWraps: [], user: {}, address: {} };
	var preDesignedGiftWraps = [];
    console.log( "ready!" );
//	var PATH="rest/usertweet/";
	
	function getPreDesignedGifts(){
		  $.ajax({
			type: "GET",
			dataType: "json",
			cache: false,
			url: "gift/predesigned-giftwraps",
			success: function(data) {
				$('#gift-container').empty();
				var mapIndex = 0;
				$.each(data, function(key, value) {
					handlePreDesignedGiftMap(mapIndex++, key, value);
				});
				$("#gift-container").append("<p><a id='goToOrder' class='goToOrder' href='#'>Go to my order</a></p>");
			}
		});
		bindEvents(); 
	}
	
	function handleZips() {
		var result = "<p>"
		result +="<input id='initial-zip' type='text' value='' size='20' />";
		result +="<a id='initial-zip-button' class='initial-zip-button' href='#'>Go</a>"
		result +="</p>";
		$("#container").append(result);
	}
	
	function handlePreDesignedGiftMap(mapIndex, key, value) {
		var result = "<p><img src='images/" + value[0].image +"' height='50' width='42'><br/></p>";
		result += "<p><label>" + value[0].name +"</label><br/></p>";
		result +=""+
		"<select id='preDesignSelect" + mapIndex + "'>";
		$.each(value, function(i, item) {
			preDesignedGiftWraps.push(item);
			result += createPreDesignedGifts(i, item);
		});
		result += "</select>";
		result += "<a id='addToOrder' class='addToOrder' href='#?i=" + mapIndex + "'>Add to order</a>";
		$("#gift-container").append(result);
	}
	
	function createPreDesignedGifts(i, preDesignedGift) {
		// image
		// name
		// selectbox
		var result ="";
		result += "<option value='" + preDesignedGift.id + "'>$" + preDesignedGift.price + " " + preDesignedGift.size + " " + preDesignedGift.length + " " + preDesignedGift.width + " " + preDesignedGift.height +"</option>";
		return result;
	};
	
	function addToOrder(hash){
		console.log( "add to order!" );
		// #?i=0
		var i = hash.split("=")[1];
		var preDesignedId = parseInt($( "#preDesignSelect"+i ).val());
		console.log("select: " + preDesignedId);
		var giftWrap = {};
		var preDesignedGiftWrap = {id : preDesignedId, quantity: 1};
		giftWrap.preDesignedGiftWrap = preDesignedGiftWrap;
		order.giftWraps.push(giftWrap);
		console.log(order);
		// get select box value
		// its a list: order/giftWraps/preDesignedGiftWrap/id
//		var data1 ='{"Username" :"'+$.trim($('#followbox').val())+'" ,"Follow" : true}';
//
//		$.ajax({
//			type: "POST",
//			cache: false,
//			contentType:"application/json; charset=utf-8",
//			dataType: "json",
//			data: data1,
//			url: PATH + "follow",
//			success: function(data) {
//				$('#followbox').val('');
//				//getFeed();
//			}
//		});	
	}
	
	function goToOrder() {
		console.log( "go to order!" );
		$('#order-container').empty();
		$('#order-container').append(fillOrder());
		$('#order-container').append("</br><div><p><a id='goToAddress' class='goToAddress' href='#'>Enter address</a></p></div>");
		// TODO go to address and submit order
	}
	
	function fillOrder() {
		var result = "<label> My Order </label>";
		result += "<p><div><table border='0' align='left'>";
		result += "<tr><th>Gift Name</th><th>Price(each)</th><th>Quantity</th><th>Action</th></tr>";
//		for (var i = 0; i < order.giftWraps; i++) {
//			var item = order.giftWraps[i];
//			var orderedPreDesigned = findAddedPreDesginedGiftWrap(item.preDesignedGiftWrap.id)
//			result += "<tr><td>" + orderedPreDesigned.name + " (" + orderedPreDesigned.size + ")</td>";
//			result += "<td> $" + orderedPreDesigned.price + "</td><td> " + item.preDesignedGiftWrap.quantity + "</td>";
//			result += "<td><a id='deleteFromOrder' class='deleteFromOrder' href='#?id=" + item.preDesignedGiftWrap.id + "'>Delete</a></td>";
//			result += "</tr>";
//		}
		var orderAmount = 0;
		$.each(order.giftWraps, function(i, item) {
			// preDesignedGiftWraps get obj with the given id
			var orderedPreDesigned = findAddedPreDesginedGiftWrap(item.preDesignedGiftWrap.id)
			result += "<tr><td>" + orderedPreDesigned.name + " (" + orderedPreDesigned.size + ")</td>";
			result += "<td> $" + orderedPreDesigned.price + "</td><td> " + item.preDesignedGiftWrap.quantity + "</td>";
			result += "<td><a id='deleteFromOrder' class='deleteFromOrder' href='#?id=" + item.preDesignedGiftWrap.id + "'>Delete</a></td>";
			result += "</tr>";
			orderAmount += orderedPreDesigned.price * item.preDesignedGiftWrap.quantity;
			item.amount = orderedPreDesigned.price;
		});
		result+="</table></div></p>";
		result+="</br><p><div>Order total: $" + orderAmount +"</div></p>";
		order.amount = orderAmount;
		return result;
		// TODO go to address and submit order
	}
	
	function findAddedPreDesginedGiftWrap(id) {
		//$.each(preDesignedGiftWraps, function(key, value) {
			return preDesignedGiftWraps.find(x => x.id === id);
			//console.log("xxx: " + xxx);
//			$.each(value, function(i, item) {
//				if (id === item.id) {
//					return item;
//				}
//			});
		//});
	}
	
	function deleteFromOrder(hash) {
		console.log( "delete from order!" );
		// #?id=1
		var id = hash.split("=")[1];
		// TODO delete from order
	}
	
	function goToAddress() {
		console.log( "address!" );
		$('#address-container').empty();
		// address, city, state, zip code
		// TODO validate zip code
		// TODO validate address later if needed
		var result = "<label>Where to wrap</label><p>";
		result+= "<table border='0'>";
		result+= "<tr><td>Street and Apt/Unit</td><td><input id='street' type='text' value='' size='40'/></td></tr>";
		result+= "<tr><td>City: </td><td><input id='city' type='text' value='' size='40'/></td></tr>";
		result+= "<tr><td>Zip Code: </td><td><input id='zipcode' type='text' value='' size='40'/></td></tr>";
		result+= "<tr><td>Phone: </td><td><input id='phone' type='tel' value='' size='40'/></td></tr>";
		result+= "<tr><td>Email: </td><td><input id='email' type='email' value='' size='40'/></td></tr>";
		result+= "</table></p>";
		// TODO select box for calendar and time
		// Months
//		result +="<p><select id='months'></p>";
//		$.each(getMonths(), function(key, value) {
//			result+="<option value='" + key + "'>" + value + "</option>";
//		});
//		result +="</select>";
//		
		// Days
//		result +="<select id='days'>";
//		$.each(getDays(), function(i, item) {
//			result+="<option value='" + item + "'>" + item + "</option>";
//		});
//		result +="</select>";
		
		result+= "<p><label>Notes:</label><textarea id='notes' rows='4' cols='50'></textarea></p>";
		$('#address-container').append(result);
		
		// Times
		var times="<select id='times'>";
		$.each(getTimes(), function(i, item) {
			times+="<option value='" + item + "'>" + item + "</option>";
		});
		times +="</select>";
		$("#date-container").css("display", "block");
		$('#date-container').append(times);
		$("#submit-container").css("display", "block");
	}
	
	var monthsArray = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'Novemeber', 'December'];
	function getMonths() {
		var result = {};
		//var result = ['December'];
		var date = new Date();
		let currentMonth = date.getMonth();
		result[currentMonth] = monthsArray[currentMonth] + " " + date.getFullYear();
		if (currentMonth == 11) {
			result[0] = monthsArray[0] + " " + (date.getFullYear() + 1);
		} else {
			result[currentMonth+1] = monthsArray[currentMonth+1] + " " + date.getFullYear();
		}
		
		return result;
	}
	
	function getDays(year, month) {
		// TODO call backend and get
	}
	
	function getTimes(year, month, day) {
		// TODO call backend and get
		var result = ['9:30 AM', '10:00 AM','10:30 AM', '11:00 AM', '11:30 AM', '12:00 PM', '12:30 PM', '1:00 PM', '1:30 PM', '2:00 PM', 
			'2:30 PM', '3:00 PM', '3:30 PM', '4:00 PM', '4:30 PM', '5:00 PM'];
		return result;
	}
	
	function daysInMonth (month, year) { 
        return new Date(year, month, 0).getDate(); 
    }
	
	
	function submitOrder() {
		$("#submit-validate-container").empty();
		// validate
		var zip = $( "#zipcode" ).val();
		if(!findZip(zip)) {
			$("#submit-validate-container").append("<p><label>Sorry we cannot submit your order beacsue we don't service your area.</label></p>");
			return;
		}
		// fill the rest of the order
		fillTheRestOfOrder();
		
		var data1 = JSON.stringify(order);
		console.log("order to submit: " + data1);
		$.ajax({
			type: "POST",
			cache: false,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			data: data1,
			url: "gift/order",
			success: function(data) {
				$("#submit-validate-container").append("<p><label>Order successfully submitted.</label></p>");
				return;
			}
		});	
	}
	
	function fillTheRestOfOrder() {
		order.user.email = $( "#email" ).val();
		order.user.phone = $( "#phone" ).val();
		
		order.address.street1 = $( "#street" ).val();
		order.address.city = $( "#city" ).val();
		order.address.zipcode = $( "#zipcode" ).val();
		order.notes = $( "#notes" ).val();
		
		order.pickedDate = $( "#date_ex" ).val();
		order.pickedTime = $( "#times" ).val();
	}
	
	var zipArray = ['91202', '91344'];
	
	function validateInitialZip () {
		$("#zip-validate-container").empty();
		var zip  = $( "#initial-zip" ).val();
//		for (var i = 0; i < order.giftWraps; i++) {
//			
//		}
		var found = findZip(zip);
		if (!found) {
			$("#zip-validate-container").append("<p><label>We don't service your area at the moment, however you can explore our services.</label></p>");
		} else {
			$("#zip-validate-container").append("<p><label>Great! We service your area. Please continue below.</label></p>");
		}
		
	}
	
	function findZip(zip) {
		var found = zipArray.find(function(element) { 
			  return element === zip; 
		});
		return found
	}
	
	function bindEvents(){

		
		$("#submitOrderForm").submit(function( event ) {
			  event.preventDefault();
			  submitOrder();
		});
		
		$(document).on('click','.addToOrder', function(e){
			 e.preventDefault();
			 console.log("a:" + e.target.hash)
			 addToOrder(e.target.hash);
		});
		
		$(document).on('click','.deleteFromOrder', function(e){
			 e.preventDefault();
			 console.log("a:" + e.target.hash)
			 deleteFromOrder(e.target.hash);
		});
		
		$(document).on('click','.goToOrder', function(e){
			 e.preventDefault();
			 goToOrder();
		});
		
		$(document).on('click','.goToAddress', function(e){
			 e.preventDefault();
			 goToAddress();
		});
		
		$(document).on('click','.initial-zip-button', function(e){
			 e.preventDefault();
			 validateInitialZip();
		});

	}
		  
	handleZips();
	getPreDesignedGifts();
	
});