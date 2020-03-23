package com.cabbuddies.library.model.jwt;

import java.util.Date;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cabbuddies.library.model.schema.Schema;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document("jwt")
public class JWT extends Schema.JWT{

	@Id
	@Field(name=_ID)
	private ObjectId id = new ObjectId();

	@Field(name=_PRIMARY_TOKEN)
	private String primaryToken = UUID.randomUUID().toString();
	
	@Field(name=_SECONDARY_TOKEN)
	private String secondaryToken = UUID.randomUUID().toString();
	
	@Field(name=_IP)
	private String ip = "";
	
	@Field(name=_BASIC_USER_DETAILS)
	private BasicUserDetails basicUserDetails = new BasicUserDetails();
	
	@Field(name=_VALID_TILL)
	private Long validTill = new Date().getTime();

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getPrimaryToken() {
		return primaryToken;
	}

	public void setPrimaryToken(String primaryToken) {
		this.primaryToken = primaryToken;
	}

	public String getSecondaryToken() {
		return secondaryToken;
	}

	public void setSecondaryToken(String secondaryToken) {
		this.secondaryToken = secondaryToken;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public BasicUserDetails getBasicUserDetails() {
		return basicUserDetails;
	}

	public void setBasicUserDetails(BasicUserDetails basicUserDetails) {
		this.basicUserDetails = basicUserDetails;
	}

	public Long getValidTill() {
		return validTill;
	}

	public void setValidTill(Long validTill) {
		this.validTill = validTill;
	}
	

	@JsonIgnore
	public boolean isValid(JWT jwt,Long cutoffTime) {
		return 	this.equals(jwt) && jwt.isValid(cutoffTime);
	}
	
	
	@JsonIgnore
	public boolean isValid(Long cutoffTime) {
		return (this.validTill>=cutoffTime);
	}
	
	@JsonIgnore
	public boolean equals(JWT jwt) {
		return 	(this.id.equals(jwt.id)) &&
				(this.primaryToken.equals(jwt.primaryToken)) &&
				(this.secondaryToken.equals(jwt.secondaryToken)) &&
				(this.ip.equals(jwt.ip)) &&
				(this.basicUserDetails.equals(jwt.basicUserDetails)) &&
				(this.validTill.equals(jwt.validTill)) ;
	}
	
	@JsonIgnore
	public boolean isRenewable(Long cutoffTime,String ip) {
		return cutoffTime<=this.validTill && this.ip.equals(ip);
	}
	
}
