<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="attribute-create" data-url="/data/sku/create/attribute?">
	<table width="100%">
		<tr>
			<td width="50%">
				Attribute Group Name:<select name="groupName" id="groupName">
					<option value="">--Select--</option>
					<c:forEach items="${attributeGroupNames}" var="attributeGroupName">
	  					<option value="${attributeGroupName.key}">${attributeGroupName.key}</option>
	  				</c:forEach>
				</select>
			</td>
			<td>
				Attribute GUID:<select name="guid" id="guid">
					<c:forEach items="${guidToNameMappings}" var="guidToNameMapping">
	   					 <option value="${guidToNameMapping.key}">${guidToNameMapping.value}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Attribute Value:<input type="text" name="value" id="value">
			</td>
			<td>
				Bulletted Attribute:<select name="bulleted" id="bulleted">
	  				<option value="" selected>--Select--</option>
	  				<option value="true">True</option>
	  				<option value="false">False</option>
				</select>
			</td>
		</tr>
  	</table>
			  			
	<button>Update Attribute</button>
</div>
		
<div id="attribute-group-delete" data-url="/data/sku/delete/attributeGroup?">
	<table width="100%">
		<tr>
			<td width="50%">
			Attribute Group Name:<select name="groupName" id="groupName">
				<option value="">--Select--</option>
				<c:forEach items="${attributeGroupNames}" var="attributeGroupName">
  					<option value="${attributeGroupName.key}">${attributeGroupName.key}</option>
  				</c:forEach>
			</select>
			</td>
		</tr>
  	</table>
			  			
	<button>Delete an Attribute Group</button>
</div>