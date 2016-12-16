
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
    	var queryParams = appendItemId(elementId);
    	console.log("queryParams" + queryParams);
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
    
    function appendItemId(elementId) {
    	console.log("New test elementId: " + elementId)
    	if ("#sku-create" !== elementId && $('#sku-create #itemId').length > 0) {
    		return "itemId=" + $('#sku-create #itemId').val();
    	} else {
    		return "";
    	}
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
	    
	    $('.left-menu > div').each(function(index) {
			var id = $(this).attr('id');
	    	$(document).off('module-selection' + index).on('click.module-selection' + index,'#' + id, function(e) {
	    		e.preventDefault();
	    		toggleMenus(id);
	    	});
		});
    }
    
    function toggleMenus(id) {
    	$('.left-menu div').each(function(e) {
    		$(this).removeClass('active');
    	});
    	$('.left-menu #' + id).addClass('active');
    	$('.input-forms div').each(function(e) {
    		$(this).removeClass('on');
    	})
    	$('.input-forms #' + id + '-create').addClass('on');
    }
    
    $(function () {
    	initEventListeners();
    });
    </script>
</head>
<body>
	<div class="sku border">
		<%@ include file="sku.jsp" %>
	</div>
	<div class="item-info border">
		<div class="left-menu">
			<div id="info" class="active">Info</div>
			<div id="item-availability">Item Availability</div>
			<div id="media">Media</div>
			<div id="fulfillment">Fulfillment</div>
			<div id="price">Price</div>
			<div id="inventory">Inventory</div>
			<div id="promotion">Promotion</div>
			<div id="attribute">Attributes</div>
			<div id="shipping">Shipping</div>
			<div id="rating">Rating</div>
			<div id="rebate">Rebate</div>
			<div id="aisle-bay">Aisle &amp; Bay</div>
			<div id="inventory-overlay">Overlay</div>
		</div>

		<div class="input-forms">
			<%@ include file="info.jsp" %>
			<%@ include file="itemAvailability.jsp" %>
			<%@ include file="media.jsp" %>
			<%@ include file="fulfillment.jsp" %>
			<%@ include file="price.jsp" %>
			<%@ include file="inventory.jsp" %>
			<%@ include file="promotion.jsp" %>
			<%@ include file="attribute.jsp" %>
			<%@ include file="shipping.jsp" %>
			<%@ include file="rating.jsp" %>
			<%@ include file="rebate.jsp" %>
			<%@ include file="aisleBay.jsp" %>
			<%@ include file="inventoryOverlay.jsp" %>
		</div>
	</div>
</body>
</html>