package com.example.hangrybirdz.userSession;

import com.example.hangrybirdz.userSessions.IUser;
import com.example.hangrybirdz.userSessions.User;
import com.example.hangrybirdz.userSessions.userController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void givenInitializeSetUsername() {
        // - Given: I am a user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //When: I enter my username "dustin"
        user.initialize("dustin");
        assertEquals(user.getUsername(), "dustin");
        //- Then: getUsername equals "dustin"
    }

    @Test
    public void givenUserNameCallReadOnce() {
        // - Given: I am a user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //- When: I enter my name
        user.initialize("dustin");
        verify(crud, times(1)).read("dustin");
        //- Then: Call CRUD object.read
    }

    @Test
    public void givenExistingUserIsExistingUserTrue() {
        // - Given: I am an existing user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //- CRUD object.read
        when(crud.read("dustin")).thenReturn(true);
        user.initialize("dustin");
        assertTrue(user.isExistingUser());
        //- Then: IsExistingUser returns true
    }

    @Test
    public void givenNewUserIsExistingUserFalse() {
        // - Given: I am a new user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //- CRUD object.read
        when(crud.read("dustin")).thenReturn(false);
        user.initialize("dustin");
        assertFalse(user.isExistingUser());
        //- Then: IsExistingUser returns false
    }

    @Test
    public void givenGameOverCallSaveOnce() {
        // - Given: I am a user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //- When: The game ends
        user.initialize("dustin");
        user.save(5);
        verify(crud, times(1)).create("dustin", 5);
        //-  Then: CRUD object.create (user.username, user.score)
    }

    @Test
    public void givenGameOverExistingUserTrue() {
        // - Given: I am a user
        userController crud = mock(userController.class);
        IUser user = new User(crud);
        //- When: The game ends
        when(crud.read("dustin")).thenReturn(false);
        user.initialize("dustin");
        user.save(5);
        assertTrue(user.isExistingUser());
        //-  Then: isExistingUser returns true;
    }
}