package cybersoft.javabackend.java11.gira.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	@Autowired
	UserRepository _repository;

	@Override
	public User save(CreateUserDTO dto) {
		User user = new User();
		user.username(dto.getUsername())
		.password(dto.getPassword())
		.email(dto.getEmail())
		.fullname(dto.getFullname());
		return _repository.save(user);
	}

	@Override
	public boolean isTakenUserName(String username) {
		if( _repository.countByUserName(username) >=1)
			return true;
		return false;
	}

}
