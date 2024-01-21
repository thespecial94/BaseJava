package com.basejava.webapp.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class Resume implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    // Unique identifier
    private final String uuid;
    private final String fullName;

    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        if (!uuid.equals(resume.uuid)) {
            return false;
        }
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return uuid + ", " + fullName;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public void setContact(ContactType type, String value) {
        this.contacts.put(type,value);
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public void setSection(SectionType type,Section section) {
        this.sections.put(type,section);
    }
}