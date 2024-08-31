package org.labexercise.simplemvc.repository;

import org.labexercise.simplemvc.db.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDo, Long> {
}
