package com.bryanstern.autovaluedemo;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

import java.util.Date;

@AutoValue
public abstract class EasyTeammate implements Teammate, Parcelable {
    public abstract String firstName();
    public abstract String lastName();
    public abstract Date joinDate();
    public abstract int petCount();
    @Nullable @Redacted
    public abstract String favoriteCoffeeDrink();

    public static Builder builder() {
        return new AutoValue_EasyTeammate.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder firstName(String name);
        public abstract Builder lastName(String name);
        public abstract Builder joinDate(Date date);
        public abstract Builder petCount(int pets);
        public abstract Builder favoriteCoffeeDrink(@Nullable String favoriteCoffeeDrink);

        abstract EasyTeammate autoBuild();

        EasyTeammate build() {
            EasyTeammate teammate = autoBuild();
            Preconditions.checkArgument(teammate.petCount() >= 0);
            return teammate;
        }
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
