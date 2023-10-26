package de.muehlencord.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Currency entity
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 0.1.0
 */
@Entity
@Table(name = "currency")
@Getter
@Setter
public class Currency extends UuidIdentifiedEntity implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(max = 3)
  @Column(name = "currency_code")
  private String currencyCode;

  @JsonBackReference
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
  private List<CountryI18n> countryI18n;

}
