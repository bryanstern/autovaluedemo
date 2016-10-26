package com.bryanstern.autovaluedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Preconditions;

import java.util.Date;

public final class TediousTeammate implements Teammate {
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final Date joinDate;
    private final int petCount;
    @Nullable
    private final String favoriteCoffeeDrink;

    public TediousTeammate(@NonNull String firstName, @NonNull String lastName, @NonNull Date joinDate, int petCount, @Nullable String favCoffeeDrink) {
        Preconditions.checkNotNull(firstName);
        Preconditions.checkNotNull(lastName);
        Preconditions.checkNotNull(joinDate);
        Preconditions.checkArgument(petCount >= 0, "We have some weird pet murderer on our hands here...");

        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = joinDate;
        this.petCount = petCount;
        this.favoriteCoffeeDrink = favCoffeeDrink;
    }

    @NonNull
    @Override
    public String firstName() {
        return firstName;
    }

    @NonNull
    @Override
    public String lastName() {
        return lastName;
    }

    @NonNull
    @Override
    public String fullName() {
        return firstName + " " + lastName;
    }

    @NonNull
    @Override
    public Date joinDate() {
        return joinDate;
    }

    @Override
    public int petCount() {
        return petCount;
    }

    @Nullable
    @Override
    public String favoriteCoffeeDrink() {
        return favoriteCoffeeDrink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TediousTeammate that = (TediousTeammate) o;

        if (petCount != that.petCount) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        return joinDate.equals(that.joinDate);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + joinDate.hashCode();
        result = 31 * result + petCount;
        return result;
    }

    @Override
    public String toString() {
        return "TediousTeammate{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joinDate=" + joinDate +
                ", petCount=" + petCount +
                '}';
    }
}
