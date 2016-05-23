package cc.caucas.lunch.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Georgy Davityan.
 */
@Data
public class Account {

    @Id
    private String login;
    private String password;
    protected String role;

    public Account() {
        this.role = "ROLE_ADMIN";
    }

}
