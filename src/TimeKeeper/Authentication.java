/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeKeeper;

import Person.Person;
import Person.PersonDAO;

/**
 *
 * @author Tim Lansing
 */
public class Authentication {
    
    private static PersonDAO pdao = new PersonDAO();
    
    public static boolean authenticateUser(int username, String password){
        boolean isGoodUser = false;
        try{
            Person user = pdao.getPerson(username);
            if (user.getPassword().equals(password)){
                isGoodUser = true;
            }
        }catch(Exception ex){
            isGoodUser = false;
        }
        return isGoodUser;
    }
}
