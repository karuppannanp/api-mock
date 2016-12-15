
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <%@ include file="styles.jsp" %>
    
    <script type="text/javascript">
    function doAjax(elementId) {
    	var queryParams = formQueryParams(elementId);
    	var url = $(elementId).attr("data-url") + queryParams;
    	$.ajax({
    		cache : false,
    		url : url,
    		dataType : "json"
    	}).done(function(data) {
			alert( "success" );
    	}).fail(function(data) {
			alert("fail");
    	})
    }
    
    function formQueryParams(elementId) {
    	var queryParams = "";
    	var selector = elementId + " input, " + elementId + " select";
    	console.log("selector" + selector);
    	$(selector).each(function(index) {
    		var input = $(this);
    		if (input.val() && input.val() != "" && input.attr('name') && input.attr('name') != "") {
    			if (queryParams != "") {
    				queryParams += "&";
    			}
				queryParams += input.attr('name') + "=" + input.val();
    		}
    	});
		console.log("queryParams:" + queryParams);
    	return queryParams;
    }
    
    function initEventListeners() {
	    $(document).off('sku-create').on('click.sku-create', '#sku-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#sku-create");
	    });
	    
	    $(document).off('info-create').on('click.info-create', '#info-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#info-create");
	    });
	    
	    $(document).off('item-availability-create').on('click.item-availability-create', '#item-availability-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#item-availability-create");
	    });
	    
	    $(document).off('promotion-create').on('click.promotion-create', '#promotion-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#promotion-create");
	    });
	    
	    $(document).off('rating-create').on('click.rating-create', '#rating-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#rating-create");
	    });
	    
	    $(document).off('rebate-create').on('click.rebate-create', '#rebate-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#rebate-create");
	    });
	    
	    $(document).off('inventory-create').on('click.inventory-create', '#inventory-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#inventory-create");
	    });
	    
	    $(document).off('price-create').on('click.price-create', '#price-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#price-create");
	    });
	    
	    $(document).off('shipping-create').on('click.shipping-create', '#shipping-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#shipping-create");
	    });
	    
	    $(document).off('fulfillment-create').on('click.fulfillment-create', '#fulfillment-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#fulfillment-create");
	    });
	    
	    $(document).off('media-create').on('click.media-create', '#media-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#media-create");
	    });
	    
	    $(document).off('aisle-bay-create').on('click.aisle-bay-create', '#aisle-bay-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#aisle-bay-create");
	    });
	    
	    $(document).off('inventory-overlay-create').on('click.inventory-overlay-create', '#inventory-overlay-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#inventory-overlay-create");
	    });
	    
	    $(document).off('attribute-create').on('click.attribute-create', '#attribute-create button', function(e) {
	    	e.preventDefault();
	    	doAjax("#attribute-create");
	    });
	    
	    $(document).off('attribute-group-delete').on('click.attribute-group-delete', '#attribute-group-delete button', function(e) {
	    	e.preventDefault();
	    	doAjax("#attribute-group-delete");
	    });
    }
    
    $(function () {
    	initEventListeners();
    });
    </script>
</head>
<body>
	<div class="sku">
		<%@ include file="sku.jsp" %>
	</div>
	<div class="item-info">
		<div class="left-menu"></div>
		<div class="input-forms">
			<%@ include file="info.jsp" %><br><br>
			<%@ include file="itemAvailability.jsp" %><br><br>
			<%@ include file="media.jsp" %><br><br>
			<%@ include file="fulfillment.jsp" %><br><br>
			<%@ include file="price.jsp" %><br><br>
			<%@ include file="inventory.jsp" %><br><br>
			<%@ include file="promotion.jsp" %><br><br>
			<%@ include file="attribute.jsp" %><br><br>
			<%@ include file="shipping.jsp" %><br><br>
			<%@ include file="rating.jsp" %><br><br>
			<%@ include file="rebate.jsp" %><br><br>
			<%@ include file="aisleBay.jsp" %><br><br>
			<%@ include file="inventoryOverlay.jsp" %><br><br>
		</div>
	</div>
</body>
</html>