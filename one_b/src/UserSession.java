

public class UserSession {
    private static UserSession instance;
    private boolean loggedIn;
    
    
    private UserSession() {
        this.loggedIn = false;
    }
    
    
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    
    public void login() {
        if (!loggedIn) {
            loggedIn = true;
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("User is already logged in.");
        }
    }
    
    
    public void logout() {
        if (loggedIn) {
            loggedIn = false;
            System.out.println("User logged out successfully.");
        } else {
            System.out.println("User is not logged in.");
        }
    }
    
   
    public boolean isLoggedIn() {
        return loggedIn;
    }
}

