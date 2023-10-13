package com.dda.crbc.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Local helper to get localize strings based on message property.
 */
@Component
public class LocalHelper {

    @Autowired
    private MessageSource messageSource;

    /**
     * Get localize string.
     *
     * @param messageProperty
     * @return {@code String}
     */
    public String getLocalMessage(final String messageProperty) {
        try {
            return messageSource.getMessage(messageProperty, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            return null;
        }
    }
}
