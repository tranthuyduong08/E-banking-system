package com.ebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebanking.entity.Role;
import com.ebanking.entity.User;
import com.ebanking.service.UserService;
import com.ebanking.repository.CurrentAccountRepository;
import com.ebanking.repository.LoanAccountRepository;
import com.ebanking.repository.RoleRepository;
import com.ebanking.repository.SavingAccountRepository;
import com.ebanking.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CurrentAccountRepository currentAccountRepository;
	
	@Autowired
	private SavingAccountRepository savingAccountRepository;
	
	@Autowired
	private LoanAccountRepository loanAccountRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User find(long id) { 
		return userRepository.findOne(id);
	}
	
	@Override
	public void hash(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));	
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}

	@Override
	public void bindRole(User user) {
		/*User tempUser = new User();
		tempUser.setFirstName(user.getFirstName());
		tempUser.setLastName(user.getLastName());
		tempUser.setGender(user.getGender());
		tempUser.setDob(user.getDob());
		tempUser.setPhone(user.getPhone());
		tempUser.setNationality(user.getNationality());
		tempUser.setCity(user.getCity());
		tempUser.setAddress(user.getAddress());
		tempUser.setUsername(user.getUsername());
		tempUser.setPassword(user.getPassword());*/
		Role role = new Role();
		role.setRole("CUSTOMER");
		user.getRoles().add(role);
		userRepository.save(user);
	}

	@Override
	public void deleteRole(User user) {
		Role role = new Role();
		role.setRole("CUSTOMER");
		user.getRoles().remove(role);
		userRepository.delete(user);
	}

	@Override
	public int countAccount() {
		long count = 0;
		count = currentAccountRepository.count() + savingAccountRepository.count() + loanAccountRepository.count();
		return (int) count;
	}

}
