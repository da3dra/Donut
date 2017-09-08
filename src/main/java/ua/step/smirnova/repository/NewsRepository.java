package ua.step.smirnova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.smirnova.entities.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
