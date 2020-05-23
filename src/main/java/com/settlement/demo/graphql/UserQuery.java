package com.settlement.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.settlement.demo.model.User;
import com.settlement.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public User user(Long domainId,String mobile) {
        return  this.userService.findUserByDomainAndMobile(domainId, mobile);
    }

    public List<User> getUsersByDomain(Long domainId) {
        return this.userService.findUserByDomain(domainId);
    }
}
