package com.serenity;

import com.serenity.account.Account;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("serenity");
        account.setEmail("serenity@email.com");

        Session session = sessionFactory.openSession();
        session.save(account);
        sessionFactory.close();

        System.out.println("finished");
    }
}
