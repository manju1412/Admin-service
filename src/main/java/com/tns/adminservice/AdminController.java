package com.tns.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Ensure this URL matches your Angular app
@RequestMapping("/admin") // To avoid repeating /admin in all mappings
public class AdminController {

    @Autowired
    private AdminService adminService;

    // GET: Retrieve all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // GET: Retrieve a single admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST: Create a new admin
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    // PUT: Update an existing admin by ID
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            admin.setUsername(adminDetails.getUsername());
            admin.setPassword(adminDetails.getPassword());
            admin.setEmail(adminDetails.getEmail());
            admin.setLoginAttempts(adminDetails.getLoginAttempts());
            admin.setIsActive(adminDetails.getIsActive());
            admin.setLastLoginTime(adminDetails.getLastLoginTime());
            Admin updatedAdmin = adminService.saveAdmin(admin);
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Remove an admin by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            adminService.deleteAdmin(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}