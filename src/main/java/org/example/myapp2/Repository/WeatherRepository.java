package org.example.myapp2.Repository;

import org.example.myapp2.Model.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WeatherRepository extends JpaRepository<User,Long> {
}

