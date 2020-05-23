package com.settlement.demo.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.settlement.demo.model.Domain;
import com.settlement.demo.model.User;
import com.settlement.demo.service.DomainService;
import com.settlement.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    UserService userService;

    @Autowired
    DomainService domainService;

    public User createUser(String name, String mobile, Long domainId) {
        Domain d = domainService.findDomainByDomainId(domainId);
        User u = new User();
        u.setName(name);
        u.setMobile(mobile);
        u.setDomain(d);
        u.setCreatedAt(new Date());
        u.setUpdatedAt(new Date());

        return userService.saveUser(u);
    }
}
