package Belajar_Spring_Boot.Spring_Boot_RestFull.repository;

import Belajar_Spring_Boot.Spring_Boot_RestFull.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
