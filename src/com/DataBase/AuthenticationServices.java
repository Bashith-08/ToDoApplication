package com.DataBase;

import java.util.HashMap;

public class AuthenticationServices extends UsersClass {
	
	HashMap<String, String> usersDataMap = new HashMap<String, String>();
	
	
	//Stores New User Details
	public void storeDetails(String userId, String userPassword)
	{
		usersDataMap.put(userId, userPassword);
	}
	
	//Validate old user Details
	public int validateUser(String yourId, String yourPassword)
    {
		if(usersDataMap.containsKey(yourId))
		{
			if(usersDataMap.get(yourId).equals(yourPassword))
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
    }
        /*
        int temp=0;
        
        for (Map.Entry<String, String> dataEntries : usersDataMap.entrySet()) 
        {
 
            if (dataEntries.getKey().equals(yourId) && dataEntries.getValue().equals(yourPassword))
            {
                temp = 1;
                break;
            }
        }
        if(temp == 1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    */
        

}
