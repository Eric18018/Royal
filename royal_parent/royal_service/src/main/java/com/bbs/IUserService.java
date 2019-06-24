package com.bbs;



public interface IUserService  {



	void addRoleToUser(String userId, String[] ids);

	void deleteUser(String id);
}

