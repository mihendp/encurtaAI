package dev.miguel.EncurtaAI.Links.repository;

import dev.miguel.EncurtaAI.Links.models.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, UUID> {
    LinkModel findByUrlEncurtada(String urlEncurtada);
}
