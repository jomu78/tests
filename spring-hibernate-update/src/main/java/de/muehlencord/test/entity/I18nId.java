package de.muehlencord.test.entity;

import java.io.Serializable;

/**
 * interface for i18n supporting entities.
 *
 * @author Joern Muehlencord, 2023-10-26
 * @since 1.0.0
 */
public interface I18nId<T> extends Serializable {

  String getLocale();

  void setLocale(String locale);

  T getIdentifier();

  void setIdentifier(T i18n);
}
