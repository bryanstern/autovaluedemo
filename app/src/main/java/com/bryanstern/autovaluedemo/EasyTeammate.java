package com.bryanstern.autovaluedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.Date;

@AutoValue
public abstract class EasyTeammate implements Teammate {
    public abstract String firstName();
    public abstract String lastName();
    public abstract Date joinDate();
    public abstract int petCount();
    @Nullable
    public abstract String favoriteCoffeeDrink();

    public static Builder builder() {
        return new AutoValue_EasyTeammate.Builder();
    }

    @AutoValue.Builder
    public interface Builder {
        Builder firstName(String name);
        Builder lastName(String name);
        Builder joinDate(Date date);
        Builder petCount(int pets);
        Builder favoriteCoffeeDrink(@Nullable String favoriteCoffeeDrink);
        EasyTeammate build();
    }

    public static Teammate create(@NonNull String firstName, @NonNull String lastName, @NonNull Date joinDate, int petCount, @Nullable String favCoffeeDrink) {
        return builder()
                .firstName(firstName)
                .lastName(lastName)
                .joinDate(joinDate)
                .petCount(petCount)
                .favoriteCoffeeDrink(favCoffeeDrink)
                .build();
    }

    @Override
    public String fullName() {
        return firstName() + " " + lastName();
    }
}
