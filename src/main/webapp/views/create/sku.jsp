<div id="sku-create" data-url="/data/sku/create?">

	<table width="100%">
		<tr>
			<td width="50%">
				 <label for="itemId">Item Id:</label><input type="text" name="itemId" id="itemId">
			</td>
			<td>
				 <label for="appliance">Appliance Flag:</label><select name="appliance" id="appliance">
							<option value="true">True</option>
							<option value="false" selected>False</option>
					</select>
			</td>
		</tr>
		<tr>
			<td>
				<label for="storeId">Store Id:</label><input type="text" name="storeId" id="storeId">
			</td>
			<td>
				<label for="storeSkuId">Store SKU Id:</label><input type="text" name="storeSkuId" id="storeSkuId">
			</td>
	</tr>
	<tr>
		<td>
			<label for="protectionPlanSku">Protection Plan SKU:</label><input type="text" name="protectionPlanSku" id="protectionPlanSku">
		</td>
		<td>
			<label for="MERCHANDISE">Item Type:</label>
			<select name="itemType" id="itemType">
				<option value="MERCHANDISE" id="MERCHANDISE" selected>Merchandise</option>
				<option value="MAJOR_APPLIANCES">Appliance</option>
				<option value="CONFIGURABLE_BLINDS">Configurable Blinds</option>
			</select>
		</td>
	</tr>

	<tr>
		<td>
			<label for="availabilityType">Availability Type:</label>
			<select name="availabilityType" id="availabilityType">
				<option value="shared" selected>Shared</option>
				<option value="online">Online</option>
				<option value="store">Store</option>
			</select>
		</td>
		<td>
			<label for="parentId">Parent Id:</label><input type="text" name="parentId" id="parentId">
	</tr>
	</table>
	<button>Create SKU</button>
</div>
	