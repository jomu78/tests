package de.muehlencord.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Basic;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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
