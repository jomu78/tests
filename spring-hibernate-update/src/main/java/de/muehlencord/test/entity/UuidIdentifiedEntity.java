package de.muehlencord.test.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * base class for all entities with a UUID is primary key / ID
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 0.1.0
 */
@Setter
@Getter
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class UuidIdentifiedEntity extends IdentifiableEntity<UUID> {

  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  protected UUID id;

  public void generateId() {
    if (id == null) {
      id = UUID.randomUUID();
    }
  }
}
