package com.serenity.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest // H2 Database 필요
public class AccountRepositoryTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        Account account = new Account();
        account.setUsername("serenity");
        account.setPassword("1234");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

        /*
        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotNull();

        Account nonExistingAccount = accountRepository.findByUsername("serenity2");
        assertThat(nonExistingAccount).isNotNull();
        */

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotEmpty();

        Optional<Account> nonExistingAccount = accountRepository.findByUsername("serenity2");
        assertThat(nonExistingAccount).isEmpty();
    }
}
