		<div id="item-availability-create" data-url="/data/sku/create/itemAvailability?">
			Buyable:<select name="buyable" id="buyable">
  				<option value="true" selected>true</option>
  				<option value="false">false</option>
			</select>
			Discontinued:<select name="discontinued" id="discontinued">
  				<option value="true">true</option>
  				<option value="false" selected>false</option>
			</select>
			Online Inventory Status:<select name="inventoryStatus" id="inventoryStatus">
  				<option value="true" selected>true</option>
  				<option value="false">false</option>
			</select>
			Back Order Flag:<select name="backorderable" id="backorderable">
  				<option value="true">true</option>
  				<option value="false" selected>false</option>
			</select>
			Published:<select name="published" id="published">
  				<option value="true" selected>true</option>
  				<option value="false">false</option>
			</select>
			Back Order Date:<input type="text" placeholder="yyyy-MM-dd" name="backorderDate">
			<select name="storeStatus" id="storeStatus">
  				<option value="0">NA</option>
  				<option value="100" selected>100 - Active</option>
  				<option value="200">200 - In Season</option>
  				<option value="300">300 - Out of Season</option>
  				<option value="400">400 - In Active</option>
  				<option value="500">500 - Clearance</option>
			</select>
			<button>Update Item Availability</button>
		</div>