package com.theapprenticewizard.aspectlogging.model.repository;

import com.theapprenticewizard.aspectlogging.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BirdRepository extends JpaRepository<Bird, String> {
}
