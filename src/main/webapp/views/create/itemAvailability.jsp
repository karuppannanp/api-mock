<div id="item-availability-create" data-url="/data/sku/create/itemAvailability?">
	<h3>Item Availability</h3>
	<table>
		<tr>
			<td width="50%">
				Buyable:<select name="buyable" id="buyable">
	  				<option value="true" selected>true</option>
	  				<option value="false">false</option>
				</select>
			</td>
			<td>
				Discontinued:<select name="discontinued" id="discontinued">
	  				<option value="true">true</option>
	  				<option value="false" selected>false</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>		
				Online Inventory Status:<select name="inventoryStatus" id="inventoryStatus">
	  				<option value="true" selected>true</option>
	  				<option value="false">false</option>
				</select>
			</td>
			<td>
				Back Order Flag:<select name="backorderable" id="backorderable">
	  				<option value="true">true</option>
	  				<option value="false" selected>false</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Published:<select name="published" id="published">
	  				<option value="true" selected>true</option>
	  				<option value="false">false</option>
				</select>
			</td>
			<td>
				Back Order Date(yyyy-MM-dd):<input type="text" placeholder="yyyy-MM-dd" name="backorderDate" maxlength="10" size="10">
			</td>
		</tr>
		<tr>
			<td>
				Store Status:<select name="storeStatus" id="storeStatus">
	  				<option value="0">NA</option>
	  				<option value="100" selected>100 - Active</option>
	  				<option value="200">200 - In Season</option>
	  				<option value="300">300 - Out of Season</option>
	  				<option value="400">400 - In Active</option>
	  				<option value="500">500 - Clearance</option>
				</select>
			</td>
		</tr>
	</table>
			<button>Update Item Availability</button>
		</div>