package org.youcode.magestic_cup.shared.utils.init;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.youcode.magestic_cup.role.Role;
import org.youcode.magestic_cup.role.RoleDAO;

import java.util.List;

@AllArgsConstructor
@Component
public class RoleInitializer {
    private final RoleDAO roleDAO;

    @PostConstruct
    public void initializeRoles() {
        List<String> roleNames = List.of("OPERATOR", "ADMIN");

        for (String roleName : roleNames) {
            if (!roleDAO.existsByRoleName(roleName)) {
                Role role = new Role();
                role.setRoleName(roleName);
                roleDAO.save(role);
            }
        }
    }
}