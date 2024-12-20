package org.youcode.magestic_cup.shared.utils.init;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.youcode.magestic_cup.role.Role;
import org.youcode.magestic_cup.role.RoleDAO;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class RoleInitializer {
    private final RoleDAO roleDAO;

    @PostConstruct
    public void initRoles() {
        if (roleDAO.findAll().isEmpty()) {
            Role adminRole = new Role();
            adminRole.setRoleName("ADMIN");
            adminRole.setUsers(new ArrayList<>());

            Role operatorRole = new Role();
            operatorRole.setRoleName("OPERATOR");
            operatorRole.setUsers(new ArrayList<>());

            roleDAO.saveAll(List.of(adminRole, operatorRole));
            System.out.println("Roles initialized: ADMIN and OPERATOR");
        }
    }
}