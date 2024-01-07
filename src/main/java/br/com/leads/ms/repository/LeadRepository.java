package br.com.leads.ms.repository;

import br.com.leads.ms.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeadRepository extends JpaRepository<Lead, UUID> {

    Optional<Lead> findByUniqueId(UUID uniqueId);

    Optional<Lead> findByPhone(String phone);
}
