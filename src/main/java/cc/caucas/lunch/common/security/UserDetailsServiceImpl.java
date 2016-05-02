package cc.caucas.lunch.common.security;

import cc.caucas.lunch.common.Account;
import cc.caucas.lunch.common.AccountRepository;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findOne(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new UserDetailsImpl(account);
        }
    }
}
