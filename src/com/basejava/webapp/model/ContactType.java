package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний телефон"),
    SKYPE("Skype") {
        @Override
        public String toHtml0(String value) {
            return getContact() + ": " + toLink("skype:" + value, value);
        }
    },
    EMAIL("Почта") {
        @Override
        public String toHtml0(String value) {
            return getContact() + ": " + toLink("mailto:" + value, value);
        }
    },
    LINKEDIN("Профиль LinkedIn") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    },
    GITHUB("Профиль GitHub") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    },
    STACKOVERFLOW("Профиль Stackoverflow") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    },
    PAGE_HOME("Домашняя страница") {
        @Override
        public String toHtml0(String value) {
            return toLink(value);
        }
    };

    private final String contact;

    ContactType(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    protected String toHtml0(String value) {
        return contact + ": " + value;
    }

    public String toHtml(String value) {
        return (value == null) ? "" : toHtml0(value);
    }

    public String toLink(String href) {
        return toLink(href, contact);
    }

    public static String toLink(String href, String title) {
        return "<a href='" + href + "'>" + title + "</a>";
    }
}
