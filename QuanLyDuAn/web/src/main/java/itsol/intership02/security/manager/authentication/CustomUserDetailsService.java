package itsol.intership02.security.manager.authentication;


import itsol.intership02.StaffService;
import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


	@Autowired
	private StaffDAO staffDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load user by Username");

		Staff staff = staffDAO.findByUsername(username);//cần staff thỏa mản cả username và password

		if(staff == null){
			System.out.println("oke");
		}


		CustomUserDetails userDetails = null;
		if (staff != null) {
			System.out.println("load username success");
			userDetails = new CustomUserDetails();
			userDetails.setStaff(staff);


		} else {
			System.out.println("load username not success");
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetails;

	}

}
