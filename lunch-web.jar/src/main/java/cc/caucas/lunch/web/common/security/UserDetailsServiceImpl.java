package cc.caucas.lunch.web.common.security;

import cc.caucas.lunch.data.repository.spring.specification.AccountByLoginSpecification;
import cc.caucas.lunch.domain.model.Account;
import cc.caucas.lunch.domain.repository.AccountRepository;
import cc.caucas.lunch.domain.repository.specification.SpecificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Georgy Davityan.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SpecificationFactory specificationFactory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AccountByLoginSpecification specification = specificationFactory.createSpecification(
                AccountByLoginSpecification.class, () -> new AccountByLoginSpecification(username));

        Account account = accountRepository.query(specification).get(0);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new UserDetailsImpl(account);
        }
    }
}
