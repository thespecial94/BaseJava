package com.basejava.webapp.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Link link;
    private final List<Period> periods;

    public Organization(String name, String url, Period... periods) {
        this(new Link(name, url), Arrays.asList(periods));
    }

    public Organization(Link link, List<Period> periods) {
        this.link = link;
        this.periods = periods;
    }

    public Link getLink() {
        return link;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(link, that.link) && Objects.equals(periods, that.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, periods);
    }

    @Override
    public String toString() {
        return link.toString() + periods;
    }
}
