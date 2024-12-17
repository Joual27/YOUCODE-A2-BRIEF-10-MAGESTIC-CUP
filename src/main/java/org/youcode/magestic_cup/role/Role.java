package org.youcode.magestic_cup.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.user.User;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String roleName;
    @DBRef
    private List<User> users;

}
