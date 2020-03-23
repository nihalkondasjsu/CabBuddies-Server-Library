package com.cabbuddies.library.repository.jwt;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.cabbuddies.library.model.jwt.BasicUserDetails;
import com.cabbuddies.library.model.jwt.JWT;

@Component
public class JWTRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public JWT saveJWT(JWT jwt) {
		mongoTemplate.findAllAndRemove(Query.query(Criteria.where(JWT._BASIC_USER_DETAILS+"."+BasicUserDetails._USER_ID).is(jwt.getBasicUserDetails().getUserId())), JWT.class);
		return mongoTemplate.insert(jwt);
	}
	
	public JWT renewJWT(JWT jwt,String ip) {
		
		return jwt;
	}

	public List<JWT> findAll() {
		return mongoTemplate.findAll(JWT.class);
	}
	
//	public void flushNonRenewableJwt() {
//		System.out.println(
//		mongoTemplate.remove(
//				Query.query(
//						Criteria.where(JWT._VALID_TILL)
//							.lt(new Date().getTime()-STANDARD_RENEWAL_VALIDITY)
//						),
//				JWT.class).getDeletedCount()+" deleted");
//	}
	
}
