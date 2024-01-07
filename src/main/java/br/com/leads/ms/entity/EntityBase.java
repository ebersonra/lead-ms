package br.com.leads.ms.entity;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class EntityBase {

    public abstract UUID getUniqueId();

    public abstract void setUniqueId(UUID uniqueId);
}
