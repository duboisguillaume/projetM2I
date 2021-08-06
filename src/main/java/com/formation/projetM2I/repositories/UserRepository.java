package com.formation.projetM2I.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projetM2I.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
