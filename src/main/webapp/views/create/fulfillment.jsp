<div id="fulfillment-create" data-url="/data/sku/create/fulfillment?">
	<table width="100%">
		<tr>
			<td width="50%">
				Ship to Home Eligibility Status:<select name="sth" id="sth">
	  				<option value="true" selected>True</option>
	  				<option value="false">False</option>
				</select>
			</td>
			<td>
				BOPIS Eligibility Status:<select name="bopis" id="bopis">
	  				<option value="true" selected>True</option>
	  				<option value="false">False</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				BOPIS Check Nearby Stores Status:<select name="bopisCheckNearby" id="bopisCheckNearby">
	  				<option value="true">True</option>
	  				<option value="false" selected>False</option>
				</select>
			</td>
			<td>
				BOSS Eligibility Status:<select name="boss" id="boss">
	  				<option value="true">True</option>
	  				<option value="false" selected>False</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				BODFS Eligibility Status:<select name="bodfs" id="bodfs">
	  				<option value="true">True</option>
	  				<option value="false" selected>False</option>
				</select>
			</td>
			<td>
				BODFS Charge:<input type="text" name="bodfsCharge">
			</td>
		</tr>
		<tr>
			<td>
				Alpha Prompt Restriction:<select name="alphaPrompt" id="alphaPrompt">
	  				<option value="" selected>-Select--</option>
	  				<option value="SUPPRESS">SUPPRESS</option>
	  			</select>
			</td>
		</tr>
  	</table>
  			
	<button>Update Fulfillment</button>
</div>