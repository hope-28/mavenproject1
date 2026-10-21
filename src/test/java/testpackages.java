import com.mycompany.mavenproject1.RegisterUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testpackages {

    // Test data - valid user
    RegisterUser validUser = new RegisterUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27831234567");
    // Test data - invalid user
    RegisterUser invalidUser = new RegisterUser("kyle!!!!!!", "password", "Kyle", "Smith", "08966553");

    @Test
    public void testCheckUserName_CorrectlyFormatted() {
        assertTrue(validUser.checkUserName(), "Username correctly formatted");
    }

    @Test
    public void testCheckUserName_IncorrectlyFormatted() {
        assertFalse(invalidUser.checkUserName(), "Username is not correctly formatted");
    }

    @Test
    public void testCheckPasswordComplexity_MeetsComplexity() {
        assertTrue(validUser.checkPasswordComplexity(), "Password correctly formatted");
    }

    @Test
    public void testCheckPasswordComplexity_DoesNotMeetComplexity() {
        assertFalse(invalidUser.checkPasswordComplexity(), "Password is not correctly formatted");
    }

    @Test
    public void testCheckCellPhoneNumber_CorrectlyFormatted() {
        assertTrue(validUser.checkCellPhoneNumber(), "Cell phone number correctly formatted");
    }

    @Test
    public void testCheckCellPhoneNumber_IncorrectlyFormatted() {
        assertFalse(invalidUser.checkCellPhoneNumber(), "Cell phone number is incorrectly formatted");
    }

    @Test
    public void testRegisterUser_Successful() {
        String result = validUser.registerUser();
        assertEquals("User has been registered successfully.", result);
    }

    @Test
    public void testLoginUser_Successful() {
        assertTrue(validUser.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Failed() {
        assertFalse(validUser.loginUser("kyl_1", "wrongpass"));
    }

    @Test
    public void testReturnLoginStatus_Successful() {
        String status = validUser.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle Smith it is great to see you again.", status);
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        String status = validUser.returnLoginStatus("kyl_1", "wrong");
        assertEquals("Username or password incorrect, please try again.", status);
    }
} 
