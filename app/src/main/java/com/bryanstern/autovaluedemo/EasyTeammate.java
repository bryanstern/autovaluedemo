package com.bryanstern.autovaluedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

import java.util.Date;

@AutoValue
public abstract class EasyTeammate implements Teammate {
    public abstract String firstName();
    public abstract String lastName();
    public abstract Date joinDate();
    public abstract int petCount();
    @Nullable
    public abstract String favoriteCoffeeDrink();

    public static Teammate create(@NonNull String firstName, @NonNull String lastName, @NonNull Date joinDate, int petCount, @Nullable String favCoffeeDrink) {
        Preconditions.checkArgument(petCount >= 0);
        return new AutoValue_EasyTeammate(firstName, lastName, joinDate, petCount, favCoffeeDrink);
    }

    @Override
    public String fullName() {
        return firstName() + " " + lastName();
    }
}
