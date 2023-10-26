package de.muehlencord.test.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * id for CountryI18n
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 1.0.0
 */
@Embeddable
@Getter
@Setter
public class CountryI18nId implements I18nId<UUID>, Serializable {

  @NotNull
  @Column(name = "country")
  private UUID country;
  @Basic(optional = false)
  @NotNull
  @Size(max = 5)
  @Column(name = "locale")
  private String locale;

  @Override
  public UUID getIdentifier() {
    return country;
  }

  @Override
  public void setIdentifier(UUID i18n) {
    this.country = i18n;
  }

  /* **** hash / equals / toString  **** */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountryI18nId that = (CountryI18nId) o;
    return Objects.equals(country, that.country) &&
      Objects.equals(locale, that.locale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, locale);
  }

  @Override
  public String toString() {
    return "CountryI18nPk{" +
      "country=" + country +
      ", locale='" + locale + '\'' +
      '}';
  }
}
