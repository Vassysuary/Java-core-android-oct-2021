package ru.geekbrains.jca.lessons.l10;

import java.util.Objects;

public class Phonebook {
    private String family;
    private String phoneNumber;

    public Phonebook(String family, String phoneNumber) {
        this.family = family;
        this.phoneNumber = phoneNumber;
    }

    public String getFamily() {
        return family;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "family='" + family + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phonebook phonebook = (Phonebook) o;
        return family.equals(phonebook.family) && phoneNumber.equals(phonebook.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, phoneNumber);
    }
}
