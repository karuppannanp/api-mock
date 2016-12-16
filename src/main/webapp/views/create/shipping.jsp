<div id="shipping-create" data-url="/data/sku/create/shipping?">
	<table width="100%">
		<tr>
			<td width="50%">
				Ship Message Number:<select name="messageNumber" id="messageNumber">
	  				<option value="2" selected>2 - Does not qualify for free (Merchandise)</option>
	  				<option value="3" selected>3 - Free with $XX (Merchandise)</option>
	  				<option value="4">4 - Free Shipping (Merchandise)</option>
	  				<option value="5">5 - Free Appliance Delivery</option>
	  				<option value="6">6 - Free Appliance Delivery with $XX</option>
				</select>
			</td>
			<td>
				Dynamic Eta:<select name="dynamicEta" id="dynamicEta">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Ship to Home Start Date(yyyy-MM-dd):<input type="text" name="sthStartDate" placeholder="yyyy-MM-dd">
			</td>
			<td>
				Ship to Home EndDate(yyyy-MM-dd):<input type="text" name="sthEndDate" placeholder="yyyy-MM-dd">
			</td>
		</tr>
		<tr>
			<td>
				BOSS Start Date(yyyy-MM-dd):<input type="text" name="bossStartDate" placeholder="yyyy-MM-dd">
			</td>
			<td>
				BOSS End Date(yyyy-MM-dd):<input type="text" name="bossEndDate" placeholder="yyyy-MM-dd">
			</td>
		</tr>
		<tr>
			<td>
				Time Left Hours:<select name="timeLeftHrs" id="timeLeftHrs">
					<option value="" selected>--Select--</option>
	  				<option value="0">0</option>
	  				<option value="1">1</option>
	  				<option value="2">2</option>
	  				<option value="3">3</option>
	  				<option value="4">4</option>
	  				<option value="5">5</option>
	  				<option value="6">6</option>
	  				<option value="7">7</option>
	  				<option value="8">8</option>
	  				<option value="9">9</option>
	  				<option value="10">10</option>
	  				<option value="11">11</option>
	  				<option value="12">12</option>
	  			</select>
			</td>
			<td>
				Time Left Minutes:<select name="timeLeftMins" id="timeLeftMins">
	  				<option value="" selected>--Select--</option>
	  				<option value="0">0</option>
	  				<option value="1">1</option>
	  				<option value="2">2</option>
	  				<option value="3">3</option>
	  				<option value="4">4</option>
	  				<option value="5">5</option>
	  				<option value="6">6</option>
	  				<option value="7">7</option>
	  				<option value="8">8</option>
	  				<option value="9">9</option>
	  				<option value="10">10</option>
	  				<option value="11">11</option>
	  				<option value="12">12</option>
	  				<option value="13">13</option>
	  				<option value="14">14</option>
	  				<option value="15">15</option>
	  				<option value="16">16</option>
	  				<option value="17">17</option>
	  				<option value="18">18</option>
	  				<option value="19">19</option>
	  				<option value="20">20</option>
	  				<option value="21">21</option>
	  				<option value="22">22</option>
	  				<option value="23">23</option>
	  				<option value="24">24</option>
	  				<option value="25">25</option>
	  				<option value="26">26</option>
	  				<option value="27">27</option>
	  				<option value="28">28</option>
	  				<option value="29">29</option>
	  				<option value="30">30</option>
	  				<option value="31">31</option>
	  				<option value="32">32</option>
	  				<option value="33">33</option>
	  				<option value="34">34</option>
	  				<option value="35">35</option>
	  				<option value="36">36</option>
	  				<option value="37">37</option>
	  				<option value="38">38</option>
	  				<option value="39">39</option>
	  				<option value="40">40</option>
	  				<option value="41">41</option>
	  				<option value="42">42</option>
	  				<option value="43">43</option>
	  				<option value="44">44</option>
	  				<option value="45">45</option>
	  				<option value="46">46</option>
	  				<option value="47">47</option>
	  				<option value="48">48</option>
	  				<option value="49">49</option>
	  				<option value="50">50</option>
	  				<option value="51">51</option>
	  				<option value="52">52</option>
	  				<option value="53">53</option>
	  				<option value="54">54</option>
	  				<option value="55">55</option>
	  				<option value="56">56</option>
	  				<option value="57">57</option>
	  				<option value="58">58</option>
	  				<option value="59">59</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Free shipping Threshold:<input type="text" name="threshold">
			</td>
			<td>
				Excluded Ship States:<input type="text" name="excludedShipStates">
			</td>
		</tr>
	</table>
	<button>Update Shipping</button>
</div>