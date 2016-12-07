/**
 * 
 */
package com.homedepot.pip.data.sku.attributeGroup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author KXP8101
 *
 */
public class AttributeGroupMappings implements Guid {
	
	private static final Map<String, String> GUID_TO_NAME_MAPPINGS = new LinkedHashMap<>();
	private static final Map<String, String> ATTR_GROUP_NAME_MAPPING = new HashMap<>();
	
	private static final Map<String, String> ATTRIBUTE_GROUP_NAMES = new HashMap<>();

	static {
		ATTRIBUTE_GROUP_NAMES.put("base dimensions", null);
		ATTRIBUTE_GROUP_NAMES.put("supplemental dimensions", null);
		ATTRIBUTE_GROUP_NAMES.put("functional details", null);
		ATTRIBUTE_GROUP_NAMES.put("descriptive", null);
		ATTRIBUTE_GROUP_NAMES.put("categorical", null);
		ATTRIBUTE_GROUP_NAMES.put("notDisplayed", null);
		ATTRIBUTE_GROUP_NAMES.put("pdf documents", null);
		ATTRIBUTE_GROUP_NAMES.put("product highlights", null);
	}

	static {
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_360_SPIN, "360 Spins");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_BARE_CUSHION, "Bare Cushion");
		GUID_TO_NAME_MAPPINGS.put(ATTR_PROPOSITION_65_WARNING_GUID_ID, "Proposition 65 Flag");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_REPLACEMENT_MODEL, "Replacement Model SKU");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_RICH_CONTENT, "Rich Content Display Mode");
		GUID_TO_NAME_MAPPINGS.put(ATTR_SALIENT_POINT_1, "Salient Points 1");
		GUID_TO_NAME_MAPPINGS.put(ATTR_SALIENT_POINT_2, "Salient Points 2");
		GUID_TO_NAME_MAPPINGS.put(ATTR_SALIENT_POINT_3, "Salient Points 3");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_SEO_DESCRIPTION, "SEO Description");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_SEO_KEYWORD, "SEO Keyword");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_SEO_TITLE, "SEO Title");
		GUID_TO_NAME_MAPPINGS.put(ATTR_NAME_SHIP_LEAD_DAYS, "Ship Lead Days");
		
		ATTR_GROUP_NAME_MAPPING.put("", "");
	}
	
	public static Map<String, String> getGuidToNameMappings() {
		return GUID_TO_NAME_MAPPINGS;
	}
	
	public static Map<String, String> getAttributeGroupNames() {
		return ATTRIBUTE_GROUP_NAMES;
	}
}
