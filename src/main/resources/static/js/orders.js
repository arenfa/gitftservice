$( document ).ready(function() {
	
	function showOrders() {
		  $.ajax({
			type: "GET",
			dataType: "json",
			cache: false,
			url: "../gift/orders",
			success: function(data) {
				$('#orders-container').empty();
				handleOrders(data);
				
			}
		});
		bindEvents(); 
	}
	//$.datepicker.formatDate('dd M yy', new Date())
	function handleOrders(data) {
		var result = "<p><div><table border='0' align='left'>";
		result += "<tr><th>Order Id</th><th>Wrap Start Date</th><th>Wrap End Date</th><th>Amount</th></tr>";
		$.each(data, function(i, item) {
			result += "<tr><td><a id='showOrder' class='showOrder' href='#'>" + item.id + "</a></td>";
			result += "<td>" + item.wrapDateStart + "</td><td>" + item.wrapDateEnd + "</td><td>" + item.amount + "</td>";
			result += "</tr>";
		});

		result+="</table></div></p>";
		$('#orders-container').append(result);
	}
	
	function showOrder() {
		// TODO show modal with close
		// whichever easier
	}
	
	function bindEvents() {
		
		$(document).on('click','.showOrder', function(e){
			 e.preventDefault();
			 showOrder();
		});



	}
	
	
	showOrders();
});