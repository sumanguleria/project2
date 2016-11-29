
package com.web.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.web.model.User;
import com.web.model.UserAdmin;

@Repository("userDAO")
public interface UserDAO {
	
// boolean addUser(UserAdmin ua);
//     List<User> viewALL();
//     User get(String  id);
//     User get(String id, String password);
// 	   boolean updateUser(User user);
//     void deleteUserById(String id);
// 	boolean isValidUserDetails(String id, String name);
// 	
    
 	public List<User> list();
    public User get(String id);
    public boolean save(User user);
	public boolean update(User user);
    public User validate(String id, String password);




    

}
