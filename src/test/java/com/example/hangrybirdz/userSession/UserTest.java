package com.example.hangrybirdz.userSession;

import com.example.hangrybirdz.userSessions.IUser;
import com.example.hangrybirdz.userSessions.User;
import com.example.hangrybirdz.userSessions.userController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserTest {
    @Test
    public void givenUserNameCallReadOnce(){
        //    - Given: I am a user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //- When: I enter my name
        user.initialize("dustin");
        verify(crud, times(1)).read("dustin");
        //- Then: Call CRUD object.read
    }
//    @Test
//    public void givenUser
}
