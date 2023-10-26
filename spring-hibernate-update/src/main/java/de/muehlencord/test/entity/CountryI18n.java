package de.muehlencord.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
