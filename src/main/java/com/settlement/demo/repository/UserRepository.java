package com.settlement.demo.repository;

import com.settlement.demo.model.Domain;
import com.settlement.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByDomain_IdAndMobile(Long domain_id, String mobile);

    List<User> findByDomain_Id(Long domainId);
}
