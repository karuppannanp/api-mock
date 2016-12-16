<div id="info-create" class="on" data-url="/data/sku/create/info?">
	<h3>Item Info</h3>
	<table>
		<tr>
			<td width="50%">
				<label for="description">Product Description:</label><input type="text" name="description" id="description">
			</td>
			<td>
				<label for="title">Title:</label><input type="text" name="title" id="title">
			</td>
		</tr>
		<tr>
			<td>
				<label for="brandName">Brand Name:</label><input type="text" name="brandName" id="brandName">
			</td>
			<td>
				<label for="label">Label:</label><input type="text" name="label" id="label">
			</td>
		</tr>
		<tr>
			<td>
				Model Number:<input type="text" name="modelNumber">
			</td>
			<td>
				Vendor Number:<input type="text" name="vendorNumber">
			</td>
		</tr>
		<tr>
			<td>
				UPC Code:<input type="text" name="upcCode">
			</td>
			<td>
				Ship Type:<input type="text" name="shipType">
			</td>
		</tr>
		<tr>
			<td>
				Product Class:<input type="text" name="prodClass">
			</td>
			<td>
				Product Sub Class:<input type="text" name="subClass">
			</td>
		</tr>
		<tr>
			<td>
				Department:<input type="text" name="department">
			</td>
			<td>
				Limit Per Order:<input type="text" name="limitPerOrder">
			</td>
		</tr>
		<tr>
			<td>
				Generic Brand Flag:<select name="genericBrandFlag" id="genericBrandFlag">
	  				<option value="true">true</option>
	  				<option value="false" selected>false</option>
				</select>
			</td>
			<td>
				Savings Center:<select name="savingsCenter" id="savingsCenter">
	  				<option value="" selected>--Select--</option>
	  				<option value="null">Null</option>
	  				<option value="New Lower Prices">New Lower Prices</option>
	  				<option value="Overstock">Overstock</option>
	  				<option value="Special Buys">Special Buys</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Hide Price:<select name="hidePrice" id="hidePrice">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
				</select>
			</td>
			<td>
				Has IRG items:<select name="hasIrgItems" id="hasIrgItems">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Has FBT items:<select name="hasFbtItems" id="hasFbtItems">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
				</select>
			</td>
			<td>
				Has FBR items:<select name="hasFbrItems" id="hasFbrItems">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
	  			</select>
			</td>
		</tr>
  	</table>
			<button>Update Info</button>
		</div>