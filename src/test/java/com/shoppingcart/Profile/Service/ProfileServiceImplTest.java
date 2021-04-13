package com.shoppingcart.Profile.Service;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.shoppingcart.Profile.Model.userProfile;
import com.shoppingcart.Profile.Repository.ProfileRepository;

@RunWith(MockitoJUnitRunner.class)
class ProfileServiceImplTest {

	@InjectMocks
	ProfileServiceImpl serviceImpl;
	
	@Mock
	ProfileRepository profileRepository;
	
	@Mock
	BCryptPasswordEncoder passwordEncoder; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testAddNewCustomerProfile() {
		userProfile uP = new userProfile();
		uP.setEmailId("abc@abc");
		uP.setMobileNumber(9090L);
		uP.setPassword("lala");
		userProfile ActualuP = null;
		try {
			Mockito.when(profileRepository.findByEmailId(uP.getEmailId())).thenReturn(null);
			Mockito.when(profileRepository.findByMobileNumber(uP.getMobileNumber())).thenReturn(null);
			ActualuP=serviceImpl.addNewCustomerProfile(uP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(uP.getEmailId(),ActualuP.getEmailId());
	}

//	@Test
//	void testAddNewMerchantProfile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddDeliveryAgentProfile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllProfiles() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProfileById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProfileByMobile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateUserProfile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteProfileById() {
//		fail("Not yet implemented");
//	}

}
