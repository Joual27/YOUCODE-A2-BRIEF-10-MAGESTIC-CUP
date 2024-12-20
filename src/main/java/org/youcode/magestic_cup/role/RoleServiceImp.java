package org.youcode.magestic_cup.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.exceptions.EntityNotFoundException;
import org.youcode.magestic_cup.role.interfaces.RoleService;

@AllArgsConstructor
@Service
public class RoleServiceImp implements RoleService {

    private final RoleDAO roleDAO;
    @Override
    public Role getRoleDocumentByName(String name){
        return roleDAO.findByRoleName(name)
                .orElseThrow(() -> new EntityNotFoundException("No role found with given name !"));
    }
}
