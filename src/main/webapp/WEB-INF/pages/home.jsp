<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
	<link rel="stylesheet" href="css/custom.css">
	<link rel="stylesheet" href="css/jquery-ui.css">
    <script type="text/javascript" src="<c:url value="jquery/jquery-3.2.1.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="jquery/jquery-ui.js" />"></script>
    <script type="text/javascript" src="<c:url value="js/home.js" />"></script>

  <script>
  $(function() {
    $( "#date_ex" ).datepicker();
  });
  </script>
</head>
<form id="submitOrderForm">

<div id="container" class="container">
	Enter to check your Zip Code
</div>
<div id="zip-validate-container" class="zip-validate-container">
</div>
<div id="gift-container" class="gift-container">
</div>
<div id="order-container" class="order-container">
</div>
<div id="address-container" class="address-container">
</div>
<div id="date-container" class="date-container" style="display: none">Selected Date to wrap: <input type="text" id="date_ex"></div>
<div id="submit-validate-container" class="submit-validate-container"></div>
<div  id="submit-container" class="submit-container" style="display: none"><input type='submit' value='Place Order'/></div>
</form>

</html>
	