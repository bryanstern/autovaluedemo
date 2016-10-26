package com.bryanstern.autovaluedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

interface Teammate {
    @NonNull
    String firstName();

    @NonNull
    String lastName();

    @NonNull
    String fullName();

    @NonNull
    Date joinDate();

    /**
     * Number of pets they own, cannot be less than 0.
     */
    @NonNull
    int petCount();

    @Nullable
    String favoriteCoffeeDrink();
}
