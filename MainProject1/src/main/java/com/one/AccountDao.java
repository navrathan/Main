package com.one;

import org.springframework.stereotype.Repository;

import com.one.Admin.vo.Pharmacy;
import com.one.constants.BaseResponse;
import com.one.vo.Login;
import com.one.vo.Registration;


@Repository
public interface AccountDao {
	BaseResponse registration(Registration registration) throws MyException;
    BaseResponse login(Login login);
	void insertPharmacy(Pharmacy pharmacy);
	void deletePharmacy(Pharmacy pharmacy);

}
