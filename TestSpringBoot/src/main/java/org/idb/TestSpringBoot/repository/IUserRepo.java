package org.idb.TestSpringBoot.repository;

import org.idb.TestSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepo extends JpaRepository<User, Integer> {


      Optional<User> findByEmail(String email);

}
