package com.one;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.Admin.vo.Pharmacy;
import com.one.constants.BaseResponse;
import com.one.vo.Encrypt;
import com.one.vo.Login;
import com.one.vo.Registration;

@Service("accountService")
public class AccountService {
	@Autowired
	AccountDao accountdao;
	private HttpServletRequest request;
	public BaseResponse registration(Registration registration) throws MyException {
		BaseResponse baseresponse=new BaseResponse();
		registration.setFullName(registration.getFirstName()+" "+registration.getLastName());
		registration.setPassword(Encrypt.passwordEncyption(registration.getPassword()));
		accountdao.registration(registration);
		return baseresponse;
	}
	

	public BaseResponse login(Login login) {
		BaseResponse response=new BaseResponse();
		Encrypt passwordEncryptio=new Encrypt();
		String pass=login.getPassword();
		login.setPassword(passwordEncryptio.passwordEncyption(pass));
	    response = accountdao.login(login);
		System.out.println("in account service");

		
		HttpSession session;
		if (response != null) {
			session = request.getSession(true);
		
		}
		return response;
	}
	
	public void insertPharmacy(Pharmacy pharmacy) {
		
		accountdao.insertPharmacy(pharmacy);
	}


	public void deletePharmacy(Pharmacy pharmacy) {
		accountdao.deletePharmacy(pharmacy);
		
	}

}
