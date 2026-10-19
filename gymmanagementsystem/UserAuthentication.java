/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanagementsystem;

/**
 * Handles user authentication and routes to appropriate service after login
 *
 * OOP Concepts Used: - Polymorphism: authenticate() returns User type,
 * chooseRole() handles different subtypes - Static methods: Utility class, no
 * instance needed - Delegation: After login, control passed to respective
 * service classes
 *
 * @author User
 */

public class UserAuthentication {

    // Verifies user credentials and returns the User object if valid
    // Returns null if authentication fails
    public static User authenticate(String id, String password, String role) {
        for (User u : DataStore.getUsers()) {
            if (u.getId().equalsIgnoreCase(id)
                    && u.checkPassword(password)
                    && u.getRole().equalsIgnoreCase(role)) {
                return u;
            }
        }
        return null;
    }

    public static void chooseRole(User user) {

        System.out.println("Login Successful!");

        // POLYMORPHISM (runtime object type check only once)
        UserService service;

        if (user instanceof Member member) {
            service = new MemberService(member);

        } else if (user instanceof Staff staff) {
            service = new StaffService(staff);

        } else if (user instanceof Trainer trainer) {
            service = new TrainerService(trainer);

        } else if (user instanceof Admin admin) {
            service = new AdminService(admin);

        } else {
            System.out.println("Unknown role.");
            return;
        }

        // SAME METHOD CALL, DIFFERENT BEHAVIOR
        service.showMenu();
    }
}