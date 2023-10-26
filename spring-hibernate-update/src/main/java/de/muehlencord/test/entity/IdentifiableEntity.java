package de.muehlencord.test.entity;

import java.io.Serializable;

/**
 * base class for all entities
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 0.1.0
 */
public abstract class IdentifiableEntity<T extends Serializable> {

  public abstract  T getId();

  public String getIdString() {
    T id = getId();
    if (id == null) {
      return null;
    } else {
      return id.toString();
    }
  }

  @Override
  public String toString() {
    return String.format("%s[id=%s]", getClass().getSimpleName(), getIdString());
  }
}
