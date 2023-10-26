package de.muehlencord.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * country
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 0.1.0
 */
@Entity
@Table(name = "country")
@Getter
@Setter
@NamedEntityGraph(name = "countryI18n", attributeNodes = @NamedAttributeNode("countryI18n"))
public class Country extends UuidIdentifiedEntity implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(max = 2)
  @Column(name = "country_code")
  private String countryCode;

  @JsonIgnore
  @JoinColumn(name = "country_currency", referencedColumnName = "id", foreignKey = @ForeignKey(name = "country_currency_fk"))
  @ManyToOne(optional = false)
  private Currency countryCurrency;

  @JsonBackReference
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
  private List<CountryI18n> countryI18n;

  /* **** equals / hash **** */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Country country = (Country) o;
    return Objects.equals(countryCode, country.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode);
  }
}
