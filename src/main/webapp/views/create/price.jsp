<div id="price-create" data-url="/data/sku/create/price?">
	<table width="100%">
		<tr>
			<td width="50%">
				UOM:<input type="text" name="uom">
			</td>
			<td>
				Original Price:<input type="text" name="originalPrice">
			</td>
		</tr>
		<tr>
			<td>
				Special Price:<input type="text" name="specialPrice">
			</td>
			<td>
				Special Buy Price:<input type="text" name="specialBuyPrice">
			</td>
		</tr>
		<tr>
			<td>
				Map Above Original Price:<select name="mapAboveOriginalPrice" id="mapAboveOriginalPrice">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
				</select>
			</td>
			<td>
				Alternate Price Display:<select name="alternatePriceDisplay" id="alternatePriceDisplay">
	  				<option value="true">True</option>
	  				<option value="false" selected>False</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Units Per Case:<input type="text" name="unitsPerCase">
			</td>
			<td>
				Case Unit Uom:<input type="text" name="caseUnitUom">
			</td>
		</tr>
		<tr>
			<td>
				Bulk Price:<input type="text" name="bulkPrice">
			</td>
			<td>
				Bulk Price Threshold Qty:<input type="text" name="bulkPriceThresholdQty">
			</td>
		</tr>
	</table>
			
	<button>Update Price</button>
</div>