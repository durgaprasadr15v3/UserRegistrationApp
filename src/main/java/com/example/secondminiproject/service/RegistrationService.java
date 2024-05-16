
package com.example.secondminiproject.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.secondminiproject.binding.UserBinding;
import com.example.secondminiproject.config.Email;
import com.example.secondminiproject.config.RandomPasswordGenerator;
import com.example.secondminiproject.entity.CIty_master;
import com.example.secondminiproject.entity.Country_master;
import com.example.secondminiproject.entity.State_master;
import com.example.secondminiproject.entity.User;
import com.example.secondminiproject.exception_handing.User_Define_Exception;
import com.example.secondminiproject.repo.CityRepository;
import com.example.secondminiproject.repo.CountryRepository;
import com.example.secondminiproject.repo.StateRepository;
import com.example.secondminiproject.repo.UserRepository;

@Service
public class RegistrationService implements ServiceInterface {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private RandomPasswordGenerator generatepasswordclass;

	@Autowired
	private Email email;

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean userformdata(UserBinding userBinding) {

		User user = new User();

		user.setFname(userBinding.getFname());
		user.setLname(userBinding.getLname());
		user.setEmail(userBinding.getEmail());
		user.setCityname(userBinding.getCityname());
		user.setCoutryname(userBinding.getCoutryname());
		user.setStatename(userBinding.getStatename());
		user.setDateofbirth(userBinding.getDateofbirth());
		user.setGender(userBinding.getGender());
		user.setPhoneno(userBinding.getPhoneno());
		//i am calling the generatepasswordclass method and return the password
		String password = generatepasswordclass.generate();
		user.setEmail(userBinding.getEmail());
		user.setCreatedate(LocalDate.now());
		user.setPassword(password);
		user.setAccountStatus("Locked");

		boolean ok = sendRegEmail(user);
		if (ok) {
		   userRepository.save(user);

			return true;
		}

		return false;
	}

	public boolean sendRegEmail(User binding) {

		String subject = "your registration successful";
		String body = readbody("demo.txt", binding);
		boolean result = email.emailsend(subject, binding.getEmail(), body);
		if (result) {
			return true;
		}
		return false;

	}

	public String readbody(String filename, User user) {

		String mailbody =null;
		
		StringBuffer buffer = new StringBuffer();
		java.nio.file.Path path = Paths.get(filename);

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				buffer.append(line);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mailbody=buffer.toString();
		mailbody = mailbody.replace("{FName}", user.getFname());
		mailbody = mailbody.replace("{temp_pwd}", user.getPassword());
		mailbody = mailbody.replace("{email}", user.getEmail());
		return mailbody;

	}

	@Override
	public Map<Integer, String> countrydata() {
		// TODO Auto-generated method stub

		List<Country_master> country = countryRepository.findAll();
		Map<Integer, String> map = new HashMap<>();
		for (Country_master data : country) {
			map.put(data.getCountryid(), data.getCountryname());
		}
		return map;
	}

	@Override
	public Map<Integer, String> statedata(int countryid) {

		List<State_master> state = stateRepository.findByCountryId(countryid);
		Map<Integer, String> map = new HashMap<>();
		for (State_master data : state) {
			map.put(data.getStateid(), data.getStatename());
		}
		return map;
	}

	@Override
	public List<String> citydata(String statename) {
		// TODO Auto-generated method stub
		List<CIty_master> citydata = cityRepository.findByStateName(statename);
		List<String> li = new ArrayList<>();

		for (CIty_master city : citydata) {
			li.add(city.getCityName());
		}
		return li;
	}

	@Override
	public boolean uniqueemail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public ResponseEntity<User> getdetailsbyid(long id) {
		// TODO Auto-generated method stub
		User user=new User();
		try
		{
		//User userdata=userRepository.findById(id);
		
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new User_Define_Exception(e.getMessage());
		}
		return ResponseEntity.ok(user);
	}

	public Optional<User> getbyid(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public String geterror() {
		// TODO Auto-generated method stub
		try {
			int a=10;
			int b=0;
			int c=a/b;
			System.out.println(c);
		}
		catch (Exception e)
		{
			throw new ArithmeticException(e.getMessage());
		}
		return "very thing fine";
	}

	public List<User> getalluserdetails() {
		// TODO Auto-generated method stub
		List<User> alluser=userRepository.findAll();
		return alluser;
	}

}
