package com.serenity.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //@Query(nativeQuery = true, value = "SELECT * FROM account WHERE username = '{0}'")
    //Account findByUsername(String username);

    Optional<Account> findByUsername(String username);
}
