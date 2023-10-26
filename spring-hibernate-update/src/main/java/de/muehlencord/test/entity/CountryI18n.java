package de.muehlencord.test.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * country i18n
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 0.1.0
 */
@Entity
@Table(name = "country_i18n")
@Getter
@Setter
public class CountryI18n extends IdentifiableEntity<CountryI18nId> implements Serializable {

  @EmbeddedId
  protected CountryI18nId countryI18nPK;
  @Basic(optional = false)
  @NotNull
  @Size(max = 100)
  @Column(name = "country_name")
  private String countryName;

  @JoinColumn(name = "country", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Country country;

  @Override
  public CountryI18nId getId() {
    return countryI18nPK;
  }
}
