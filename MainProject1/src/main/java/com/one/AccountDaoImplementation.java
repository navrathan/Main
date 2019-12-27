package com.one;

import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.one.vo.Counter;
import com.one.Admin.vo.Pharmacy;
import com.one.constants.BaseResponse;
import com.one.constants.MongoDbUtil;
import com.one.vo.Encrypt;
import com.one.vo.Login;
import com.one.vo.Registration;

@Repository("accountdao")

public class AccountDaoImplementation implements AccountDao{

	@Autowired
	AccountDao accountdao;
	
	
	@Override
	public BaseResponse registration(Registration registratio) throws MyException {
		BaseResponse response=new BaseResponse();
		try {
		
		System.out.println("db"+MongoDbUtil.getDB());
		Registration registrationUser = new Jongo(MongoDbUtil.getDB()).getCollection("registration")
				.findOne("{$or:[{email:#},{mobileNumber:#}]}", registratio.getEmail(), registratio.getMobileNumber())
				.as(Registration.class);

		if (registrationUser != null) {

			if (registrationUser.getMobileNumber() == registratio.getMobileNumber()) {
				response.setStatusCode(601);
				response.setStatusMessage("Mobile Number already exists");
				System.out.println("Mobile Number already exists");
				
			}
			if (registrationUser.getEmail().equals(registratio.getEmail())) {
				response.setStatusCode(601);
				response.setStatusMessage("Email already exists");
				System.out.println("email already exists");
			}
			return response;

		} else {
		new Jongo(MongoDbUtil.getDB()).getCollection("registration").insert(registratio);
		response.setStatusCode(200);
		response.setStatusMessage("registration successful");
		return response;
		
		}
		}
		catch(Exception e) {
			throw new MyException("exception while registration");
		}
	}
	
	@Override
	public BaseResponse login(Login login) {
		BaseResponse response=new BaseResponse();
		System.out.println(login.getEmail());
		String email=login.getEmail();
		String pass=login.getPassword();                    
		if(email.equals("admin") && pass.equals("1234a")) {

			response.setStatusCode(200);
			response.setStatusMessage("login successful");	;
		}
		else {
			response.setStatusCode(100);
			response.setStatusMessage("login unsuccessful");	;
		}
		return response;
		
	}

	@Override
	public void insertPharmacy(Pharmacy pharmacy) {
		new Jongo(MongoDbUtil.getDB()).getCollection("pharmacyCounter").update("{ _id:1 }").with("{$inc:{seq:1}}");
		Counter counter = new Jongo(MongoDbUtil.getDB()).getCollection("pharmacyCounter").findOne("{ _id: 1}")
				.as(Counter.class);
		pharmacy.setPharmacyId(counter.getSeq());
		
		new Jongo(MongoDbUtil.getDB()).getCollection("pharmacyDetails").insert(pharmacy);
	}

	@Override
	public void deletePharmacy(Pharmacy pharmacy) {
		Pharmacy pharma = new Jongo(MongoDbUtil.getDB()).getCollection("pharmacyDetails").findOne("{ pharmacyId : #}",pharmacy.getPharmacyId())
				.as(Pharmacy.class);
		int id=pharma.getPharmacyId();
		new Jongo(MongoDbUtil.getDB()).getCollection("pharmacyDetails").remove("{pharmacyId: #}",id);
		System.out.println("done deletion");
		
	}
	

}
