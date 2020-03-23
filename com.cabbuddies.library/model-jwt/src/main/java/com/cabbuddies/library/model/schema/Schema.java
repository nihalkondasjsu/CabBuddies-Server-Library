package com.cabbuddies.library.model.schema;

public class Schema {

	public static class BasicId{
		public static final String _ID="_id";
	}
	
	public static class JWT extends BasicId{
		public static final String _PRIMARY_TOKEN="primaryToken";
		public static final String _SECONDARY_TOKEN="secondaryToken";
		public static final String _IP="ip";
		public static final String _BASIC_USER_DETAILS="basicUserDetails";
		public static final String _VALID_TILL="validTill";
	}
	
	public static class BasicUserDetails extends BasicId{
		public static final String _USER_ID="userId";
		public static final String _USER_FIRST_NAME="userFirstName";
		public static final String _USER_LAST_NAME="userLastName";
		public static final String _USER_DISPLAY_PICTURE="userDisplayPicture";
	}
	
}
