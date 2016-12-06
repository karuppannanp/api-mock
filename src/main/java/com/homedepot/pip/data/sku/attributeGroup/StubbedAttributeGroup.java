package com.homedepot.pip.data.sku.attributeGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.DomainGroup;
import com.homedepot.pip.backend.domain.item.ItemAttribute;
import com.homedepot.pip.input.Attribute;
import com.homedepot.pip.input.ItemInput;

@Component
public class StubbedAttributeGroup extends AttributeGroupMappings {
	
	public ArrayList<DomainGroup> createDomainGroupList(ItemInput itemInput) {
		ArrayList<DomainGroup> domainGroups = new ArrayList<DomainGroup>();
		createDefaultDomainGroupList(domainGroups);
		removeAttributeGroups(domainGroups, itemInput.getAttributeGroupNames());
		insertAttributes(domainGroups, itemInput.getAttributeGroups());
		return domainGroups;
	}
	
	private void insertAttributes(ArrayList<DomainGroup> domainGroups, Map<String, List<Attribute>> attrGroups) {
		if (attrGroups == null || attrGroups.size() == 0) {
			return;
		}

		Iterator<String> attrGroupNames = attrGroups.keySet().iterator();
		String attrGroupName = null;
		List<Attribute> attrs = null;
		while (attrGroupNames.hasNext()) {
			attrGroupName = attrGroupNames.next();
			if (attrGroups.containsKey(attrGroupName)) {
				attrs = attrGroups.get(attrGroupName);
				for (Attribute attr : attrs) {
					if (attr != null && StringUtils.isNotBlank(attr.getGuid())
							&& StringUtils.isNotBlank(attr.getValue())) {
						insertAnAttribute(attr.isBulleted(), attr.getGuid(), attr.getValue(), domainGroups, attrGroupName);
					}
				}
			}
		}
	}
	
	private void createDefaultDomainGroupList(ArrayList<DomainGroup> domainGroups) {
		domainGroups.add(createDefaultDescriptiveGroup());
		domainGroups.add(createDefaultFunctionalGroup());
		domainGroups.add(createDefaultNotDisplayedGroup());
		domainGroups.add(createDefaultSupplementalDimensionGroup());
		domainGroups.add(createBaseDimensionGroup());
	}

	private DomainGroup createDomainGroup(String groupType, ArrayList<ItemAttribute> groupList) {
		DomainGroup domainGroup = new DomainGroup();
		domainGroup.setGroupType(groupType);
		domainGroup.setGroupList(groupList);
		return domainGroup;
	}

	private ItemAttribute createItemAttribute(Boolean bulletedAttr, String guid, String name, String value) {
		return createItemAttribute(bulletedAttr, guid, name, value, null);
	}

	private ItemAttribute createItemAttribute(Boolean bulletedAttr, String guid, String name, String value, String url) {
		ItemAttribute itemAttribute = new ItemAttribute();
		itemAttribute.setName(name);
		itemAttribute.setValue(value);
		itemAttribute.setGuid(guid);
		itemAttribute.setBulletedAttr(bulletedAttr);
		itemAttribute.setUrl(url);
		return itemAttribute;
	}
	
	private void insertAnAttribute(Boolean bulletedAttr, String guid, String value,
			ArrayList<DomainGroup> attributeGroups, String attrGroupType) {
		insertAnAttribute(bulletedAttr, guid, AttributeGroupMappings.getGuidToNameMappings().get(guid), value, attributeGroups, attrGroupType);
	}
	
	@SuppressWarnings("unchecked")
	private void insertAnAttribute(Boolean bulletedAttr, String guid, String name, String value,
			ArrayList<DomainGroup> attributeGroups, String attrGroupType) {
        boolean attrGroupTypePresent = false;
        ArrayList<ItemAttribute> attrList = null;

        for (DomainGroup attributeGroupList : attributeGroups) {
            if (StringUtils.equals(StringUtils.trim(attributeGroupList.getGroupType()),
                    attrGroupType)) {
                attrList = (ArrayList<ItemAttribute>) attributeGroupList.getGroupList();
                checkAnAttributeAndRemove(attrList, guid);
                attrList.add(createItemAttribute(bulletedAttr, guid, name, value));
                attrGroupTypePresent = true;
                break;
            }
        }
        if (!attrGroupTypePresent) {
            attrList = new ArrayList<ItemAttribute>();
            attrList.add(createItemAttribute(bulletedAttr, guid, name, value));
            DomainGroup domainGroup = createDomainGroup(attrGroupType, attrList);
            attributeGroups.add(domainGroup);
        }
    }

	private void removeAttributeGroups(ArrayList<DomainGroup> attributeGroups,
			List<String> attributeGroupNames) {

		int attrGroupSize = attributeGroups.size();
		if (attributeGroupNames == null) {
			return;
		}
		for (String attributeGroupName : attributeGroupNames) {
			DomainGroup attributeGroupList = null;
			for (int index = 0; index < attrGroupSize; index++) {
				attributeGroupList = attributeGroups.get(index);
				if (attributeGroupList != null && StringUtils
						.equals(StringUtils.trim(attributeGroupList.getGroupType()), attributeGroupName)) {
					attributeGroups.remove(index);
				}
			}
		}
	}
	
	private void checkAnAttributeAndRemove(ArrayList<ItemAttribute> attrs, String guid) {
		if (attrs == null || attrs.size() == 0) {
			return;
		}

		for (int index = 0; index < attrs.size(); index++) {
			ItemAttribute attr = attrs.get(index);
			if (attr != null && StringUtils.equals(attr.getGuid(), guid)) {
				attrs.remove(index);
				break;
			}
		}
	}
	
    private DomainGroup createDefaultSupplementalDimensionGroup() {
        ArrayList<ItemAttribute> groupList = new ArrayList<ItemAttribute>();
        groupList.add(createItemAttribute(null, "542b2138-e766-4426-aa1a-250eadc74b50", "Product Height (in.)", "14.5"));
        groupList.add(createItemAttribute(null, "fc29e921-fd44-4fca-911e-c4433c7effe6", "Product Diameter (in.)", "12 in"));
        groupList.add(createItemAttribute(null, "5ad8d718-20da-4ce0-9872-fe7c84f24bb2", "Product Depth (in.)", "13"));
        groupList.add(createItemAttribute(null, "fac03a00-67f9-402b-a121-fb9448fc552d", "Product Width (in.)", "13"));
        return createDomainGroup("supplemental dimensions", groupList);
    }
    
    private DomainGroup createBaseDimensionGroup() {
    	ArrayList<ItemAttribute> groupList = new ArrayList<ItemAttribute>();
        groupList.add(createItemAttribute(null, "18a2f6bd-81b5-4c8e-9cff-15ca6824eb5a", "Manufacturer Warranty", "no"));
        return createDomainGroup("base dimensions", groupList);
    }
    
    private DomainGroup createDefaultDescriptiveGroup() {
        ArrayList<ItemAttribute> groupList = new ArrayList<ItemAttribute>();
        groupList.add(createItemAttribute(true, "1905c003-bc16-459c-848d-930ce2db71bb", "Bullet06", "Buckets are not food grade"));
        groupList.add(createItemAttribute(true, "3b8d7d7e-9ff9-4b2b-99ca-57a1ba19eb94", "Bullet01", "Use for mixing paint, hauling topsoil, storing parts and for other purposes"));
        groupList.add(createItemAttribute(true, "8736c9b6-a1db-4bd9-a9b5-938234b899ec", "Plastic construction for durability", "Plastic construction for durability"));
        groupList.add(createItemAttribute(true, "702cd201-e56d-45d7-947f-31575735ffa2", "Bullet20", "Note: product may vary by store"));
        groupList.add(createItemAttribute(true, "c69c774b-774d-4887-9656-c77807342c64", "Bullet05", "Orange color with the Home Depot logo"));
        groupList.add(createItemAttribute(true, "fed33381-f352-458d-9732-11e1053008c2", "Bullet03", "Holds up to a 9 in. bucket grid"));
        groupList.add(createItemAttribute(null, "fed33381-f352-458d-9732-11e1053008c2", "MFG Brand Name", "The Home Depot"));
        groupList.add(createItemAttribute(true, "15271107-6854-40a9-bcd6-b320407d8544", "Bullet02", "Ideal for use as a utility pail on work sites"));
        return createDomainGroup("descriptive", groupList);
    }
    
	private DomainGroup createDefaultFunctionalGroup() {

        ArrayList<ItemAttribute> groupList = new ArrayList<ItemAttribute>();

        groupList.add(createItemAttribute(null, "6780e60c-b9a5-432a-889d-1df5e84dec21", "Lid Included", "No"));
        groupList.add(createItemAttribute(null, "675afb24-0e4b-4c58-adc4-63e467935346", "Returnable", "90-Day"));
        groupList.add(createItemAttribute(null, "e17c7a92-90d8-49b5-acbe-12bd21067613", "Product Weight (lb.)", "1.8"));
        groupList.add(createItemAttribute(null, "eb285f84-2814-4613-baf5-a5cf53cfd892", "Capacity (qt.)", "20 qt (US)"));
        groupList.add(createItemAttribute(null, "fb89b7dc-2ac0-43c3-bd4b-d50e3f098220", "Paint Product Type", "Paint Buckets and Lids"));
        groupList.add(createItemAttribute(null, "a8bbc5b6-bbec-438b-8ff7-0b04afc987cc", "Graduation markings", "No"));
        groupList.add(createItemAttribute(null, "d238cd83-383a-4462-93ca-616ec7bb426e", "Applicator/Tool Type", "Bucket"));
        groupList.add(createItemAttribute(null, "4c6e7d58-b64c-42a1-8d1f-3f23265d7949", "Material", "Plastic"));
        return createDomainGroup("functional details", groupList);
    }
    
    private DomainGroup createDefaultNotDisplayedGroup() {
    	ArrayList<ItemAttribute> groupList = new ArrayList<ItemAttribute>();
        groupList.add(createItemAttribute(null, "459ed8bb-73f1-48d2-aebf-9ef43dbfe201", "OMS THD Sub Class", "60"));
        groupList.add(createItemAttribute(null, "1c18afcb-cb1d-4424-a9d6-81c318626a17", "ShipType", "33"));
        groupList.add(createItemAttribute(null, "a91fa6bd-c9c5-43b5-a05b-87607b5c15a2", "Vendor Processing Days", "1"));
        groupList.add(createItemAttribute(null, "a91fa6bd-c9c5-43b5-a05b-87607b5c15a2", "Dotcom Shipping Carton Width (in)", "13 In."));
        groupList.add(createItemAttribute(null, "d1cdfb22-c198-46e4-ac93-260d042b8dd2", "ShippingSurcharge", "0"));
        groupList.add(createItemAttribute(null, "37f3fed4-5bf3-4bf8-88bd-310bd2addb56", "MFG Name", "Leaktite Corporation"));
        groupList.add(createItemAttribute(null, "e5491a59-0ea3-4e73-a02c-fa32b3956342", "Supplier SKU", "789513"));
        groupList.add(createItemAttribute(null, "46f9ad07-5df1-47d1-84e0-c51d39626b8d", "THD IN STORE", "Y"));
        groupList.add(createItemAttribute(null, "6d030ff8-72ce-4f42-ba53-023f55c53a20", "UPC", "084305355546"));
        groupList.add(createItemAttribute(null, "ba5bbbf2-01bd-4b0c-bc68-025df2150266", "Sell UOM (as sold to consumer)", "EA-Each"));
        groupList.add(createItemAttribute(null, "6f8487bb-858f-4c1c-b17a-8c91f2b57ff5", "THDInMarket401", "Y"));
        groupList.add(createItemAttribute(null, "84ebbc8a-5c11-44e7-b1f1-d37babdb0833", "COUNTRY OF ORIGIN", "US"));
        groupList.add(createItemAttribute(null, "27156dfb-3ce8-4307-bd7e-b36cae566a3f", "THD SKU # (NO dashes)", "131227"));
        groupList.add(createItemAttribute(null, "90c8023b-39e6-43dd-91b1-7d1df23fa356", "ExcludedShipStates", "AK,GU,HI,PR,VI"));
        groupList.add(createItemAttribute(null, "c924a8d7-350a-4cdf-9841-1864341bb606", "UOMCd", "EA"));
        groupList.add(createItemAttribute(null, "8a44b69c-db4d-4618-9a5f-421c6d6fbf06", "Image Enhancement Available", "Y"));
        groupList.add(createItemAttribute(null, "8b6366a5-1f08-4573-b3d2-c5a978c6189d", "ItemLevelFreeShip", "false"));
        groupList.add(createItemAttribute(null, "f6ef55f4-9f5b-46d9-869d-40b671d668c1", "THD OnlineStatus", "true"));
        groupList.add(createItemAttribute(null, "e7b509cd-3a71-4b24-8611-361540e96e3d", "Primary Category", "34630083-9c67-4bba-9472-2475e2c0fa50"));
        groupList.add(createItemAttribute(null, "6ec6731b-f6cf-4b8a-980d-b706b17b1c00", "OMS THD Class", "10"));
        groupList.add(createItemAttribute(null, "6013739a-4343-4579-b770-ae00e49d1b52", "Dotcom Shipping Carton Gross Weight (lb)", "1.84"));
        groupList.add(createItemAttribute(null, "20574c03-de83-42ec-b3de-ad2b24237020", "TaxwareCode", "89998"));
        groupList.add(createItemAttribute(null, "d9947b6c-5ebf-48b8-aeb6-e7ebd9221420", "OMSID", "100087613"));
        groupList.add(createItemAttribute(null, "9df05b5f-8807-4870-be9a-3b62038c74e6", "FieldDestroy", "false"));
        groupList.add(createItemAttribute(null, "ae4d63ea-744b-428a-bcfc-589f050f8d3b", "OMS THD Dept", "24"));
        groupList.add(createItemAttribute(null, "9de2009d-e656-4cba-af51-df453a8dd419", "PRODUCT_TYPE", "MERCHANDISE"));
        groupList.add(createItemAttribute(null, "987841c7-1c8a-4e60-9a34-12c4edc6395a", "EligibleForRetailDiscount", "true"));
        groupList.add(createItemAttribute(null, "e0c519c3-b558-4a42-b327-a06a7577d9f4", "Do not Show Brand Name", "false"));
        groupList.add(createItemAttribute(null, "812fcf72-7fbc-473f-93de-ce9acdc0ecac", "Dotcom Shipping Carton Depth (in)", "12 In."));
        groupList.add(createItemAttribute(null, "2bce6533-87c7-4646-a3b7-d5efb49bf927", "MFG Model #", "05GLHD2"));
        groupList.add(createItemAttribute(null, "d96fcf59-ca33-47e2-9f36-c105510b4d00", "THD Class", "10"));
        groupList.add(createItemAttribute(null, "ae8c38ff-4109-44b1-9fc4-93d1b586a680", "OMS THD SKU", "1000186099"));
        groupList.add(createItemAttribute(null, "6120da58-d2ae-42ef-9ac1-d2e123faa759", "OMS THD Vendor Name", "YOW"));
        groupList.add(createItemAttribute(null, "82904470-0dbd-4e33-a681-6fef5e2992fe", "BackOrdersAllowed", "false"));
        groupList.add(createItemAttribute(null, "27ba4961-93f2-4d87-9bb3-9229f77d1015", "THD Sub Class", "8"));
        groupList.add(createItemAttribute(null, "8f624a04-f591-4bf6-a0a8-83dc71881048", "Family", "Homer"));
        groupList.add(createItemAttribute(null, "19e476b8-e751-4b8d-b372-d4d2b62b6a21", "EligibleFreeShip", "false"));
        groupList.add(createItemAttribute(null, "5ddbe247-f603-48b7-8476-245c990f2b0f", "Dotcom Shipping Carton Height (in)", "14.5 In."));
        groupList.add(createItemAttribute(null, "85753845-83f6-4eaa-84ab-5648a34c4077", "OMS THD SKU Status Code", "100"));
        groupList.add(createItemAttribute(null, "31fb6392-36cd-49ca-bc2d-177ddc7a8a55", "THD Dept", "24"));
        groupList.add(createItemAttribute(null, "bcdfe1a4-626a-4042-9a2e-5298f9b952a8", "OMS THD Sku Type", "S"));
        groupList.add(createItemAttribute(null, "dd3e3b80-46d8-4906-ac5f-844b3db02430", "Keywords", "pail, bucket, 5 gallon, homer"));
        groupList.add(createItemAttribute(null, "cd250fb8-fb00-4f9d-813a-dea949605715", "MFG Part #", "05GLHD2"));
        groupList.add(createItemAttribute(null, "770b0397-4cff-4e8d-8a0b-dd11ccc77e9e", ".com Merch Vendor #", "72792"));
        groupList.add(createItemAttribute(null, "3735eab9-2ab3-4eeb-b5c3-d538d42dea73", "Sell Pkg Qty (as sold to consumer)", "1"));
        groupList.add(createItemAttribute(null, "eb8db341-33c1-4ca4-9316-84dfba75e7fb", "THDOMSValidated", "true"));
        groupList.add(createItemAttribute(null, "57719267-5477-4f2e-84b6-1bf342fa23d2", "THD Vendor #", "447995"));
        groupList.add(createItemAttribute(null, "ccdfe24e-1138-4601-9575-66bc717edbc0", "THD Dot Com Onlinestatus", "true"));
        groupList.add(createItemAttribute(null, "bf15fa45-176c-4749-8481-2c8a2f9dd70f", "THD Browse Onlinestatus", "true"));
        groupList.add(createItemAttribute(null, "6ed8afb5-8571-414c-bdfa-645494cda8b1", "PRO", "Pro"));
        groupList.add(createItemAttribute(null, "7eb1e571-64d3-4800-85ff-7bae9f84e334", "Ship From YOW/CHUB", "YOW"));
        groupList.add(createItemAttribute(null, "e5271c05-f70f-4dd4-bc89-2e559827f8c8", "Freight Class", "125"));
        groupList.add(createItemAttribute(null, "26a47f9d-c137-4f65-a128-c68e406e2a6e", "SEO Keywords", "Homer Bucket, Homer, Bucket, 5 gal., Home Depot Orange, Utility pail, 70mil, painting supplies, Paint supplies, Painting supplies"));
        groupList.add(createItemAttribute(null, "9e747da5-fef5-45ed-8495-97ca2fbb8507", "SEO Description", "Use The Home Depot Homer Bucket to mix paint, wash your car and many other household or work-site tasks. Made of plastic material."));
        groupList.add(createItemAttribute(null, "d9fd4421-ab85-4015-a228-fb2d2e4f9081", "bopis eligible", "true"));
        groupList.add(createItemAttribute(null, "aee97348-db1c-4e33-a1d8-932f31f2ed35", "Proposition 65 warning required?", "No"));
        groupList.add(createItemAttribute(null, "4e5ee0cd-56f1-462f-96d5-c6d45eec2083", "Online More Views", "sys_homedepot_uid_100087613"));
        groupList.add(createItemAttribute(null, "48956d44-8156-46df-af1a-3eff05b3a842", "Description (36)", "5GAL HOMER BUCKET"));
        groupList.add(createItemAttribute(null, "4efcb9a4-dcf6-4c8e-a5b4-0834a2318562", "BOSS eligible", "true"));
        groupList.add(createItemAttribute(null, "b21a0531-6bce-4a47-9faa-12be2eae5bee", "THD Category", "102"));
        groupList.add(createItemAttribute(null, "8c50bd36-118e-4ac3-a6b1-e1f132cb7290", "OMS THD Category", "104"));
        groupList.add(createItemAttribute(null, "9991ed9a-06d2-4cb1-8a8a-b8b9deb88893", "THD Sub Sub-Class", "105"));
        groupList.add(createItemAttribute(null, "f8fca106-b543-432b-be73-81ab18beb768", "OMS THD Sub Sub-Class", "101"));
        groupList.add(createItemAttribute(null, "030f9c4c-444a-4487-9b88-4a1475494229", "BODFS Eligible", "true"));
        groupList.add(createItemAttribute(null, "cdca4473-4693-4d3f-a917-1e45db88f20b", "YOW SKU # (NO dashes)", "789513"));
        groupList.add(createItemAttribute(null, "c69a4f10-8875-4bd0-889f-6fa7a8c8a638", "YOW Description (35)", "05GLH2 5GAL ORG'HOMER'BUCKET*SEE P*"));
        return createDomainGroup("notDisplayed", groupList);
	}
}