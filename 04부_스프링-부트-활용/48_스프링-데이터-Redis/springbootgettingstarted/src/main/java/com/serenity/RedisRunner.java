package com.serenity;

import com.serenity.Account.Account;
import com.serenity.Account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("serenity", "test");
        values.set("sprintboot", "2.0");
        values.set("hello", "world");

        // AccountRepository
        Account account = new Account();
        account.setUsername("serenity");
        account.setEmail("serenity@email.com");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById((account.getId()));
        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());
    }
}
