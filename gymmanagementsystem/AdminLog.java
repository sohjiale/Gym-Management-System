/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanagementsystem;

/**
 * Records admin actions for audit trail
 *
 * OOP Concept: Encapsulation - data (action, time) is wrapped inside object
 *
 * @author Asus
 */
import java.time.LocalDateTime;

public class AdminLog {

    private String action;        // What action was performed
    private LocalDateTime time;   // When it happened (auto-recorded)

    // Constructor - timestamp is set automatically when log is created
    public AdminLog(String action) {
        this.action = action;
        this.time = LocalDateTime.now();  // Capture current date & time
    }

    // Getter methods - provide controlled access to private fields
    public String getAction() {
        return action;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
