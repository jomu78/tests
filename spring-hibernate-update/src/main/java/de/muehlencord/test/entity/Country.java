package de.muehlencord.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
