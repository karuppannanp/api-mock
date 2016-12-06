<div id="sku-create" data-url="/data/sku/create?">
			Item Id:<input type="text" name="itemId">
			Appliance Flag:<select name="appliance" id="appliance">
  				<option value="true">True</option>
  				<option value="false" selected>False</option>
			</select>
			Store Id:<input type="text" name="storeId">
			Store SKU Id:<input type="text" name="storeSkuId">
			Protection Plan SKU:<input type="text" name="protectionPlanSku">
			Item Type:<select name="itemType" id="itemType">
  				<option value="MERCHANDISE" selected>Merchandise</option>
  				<option value="MAJOR_APPLIANCES">Appliance</option>
  				<option value="CONFIGURABLE_BLINDS">Configurable Blinds</option>
			</select>
			Availability Type:<select name="availabilityType" id="availabilityType">
  				<option value="shared" selected>Shared</option>
  				<option value="online">Online</option>
  				<option value="store">Store</option>
			</select>
			Parent Id:<input type="text" name="parentId">
			<button>Create SKU</button>
		</div>
	