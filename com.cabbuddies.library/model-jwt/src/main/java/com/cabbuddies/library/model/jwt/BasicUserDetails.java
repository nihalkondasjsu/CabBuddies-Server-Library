package com.cabbuddies.library.model.jwt;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cabbuddies.library.model.schema.Schema;

@Document
public class BasicUserDetails extends Schema.BasicUserDetails{

	@Id
	@Field(name=_ID)
	private ObjectId id = new ObjectId();

	@Field(name=_USER_ID)
	private ObjectId userId = new ObjectId();

	@Field(name=_USER_FIRST_NAME)
	private String userFirstName = "Unknown";

	@Field(name=_USER_LAST_NAME)
	private String userLastName = "Unknown";

	@Field(name=_USER_DISPLAY_PICTURE)
	private String userDisplayPicture = "";

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserDisplayPicture() {
		return userDisplayPicture;
	}

	public void setUserDisplayPicture(String userDisplayPicture) {
		this.userDisplayPicture = userDisplayPicture;
	}
	
}
