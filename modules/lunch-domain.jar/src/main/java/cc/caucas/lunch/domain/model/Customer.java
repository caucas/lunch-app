package cc.caucas.lunch.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Georgy Davityan.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Account {

    public Customer() {
        this.role = "ROLE_CUSTOMER";
    }
}
