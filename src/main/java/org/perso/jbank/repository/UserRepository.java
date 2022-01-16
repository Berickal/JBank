package org.perso.jbank.repository;

import org.perso.jbank.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository <User, Integer> {

    @Transactional
    public Optional<User> findByMail(String mail);

}
