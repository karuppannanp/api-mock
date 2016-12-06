		<div id="price-create" data-url="/data/sku/create/price?">
			UOM:<input type="text" name="uom">
			Original Price:<input type="text" name="originalPrice">
			Special Price:<input type="text" name="specialPrice">
			Special Buy Price:<input type="text" name="specialBuyPrice">
			Map Above Original Price:<select name="mapAboveOriginalPrice" id="mapAboveOriginalPrice">
  				<option value="" selected>--Select--</option>
  				<option value="true">True</option>
  				<option value="false">False</option>
			</select>
			Alternate Price Display:<select name="alternatePriceDisplay" id="alternatePriceDisplay">
  				<option value="true">True</option>
  				<option value="false" selected>False</option>
			</select>
			Units Per Case:<input type="text" name="unitsPerCase">
			Case Unit Uom:<input type="text" name="caseUnitUom">
			Bulk Price:<input type="text" name="bulkPrice">
			Bulk Price Threshold Qty:<input type="text" name="bulkPriceThresholdQty">
			
			<button>Update Price</button>
		</div>