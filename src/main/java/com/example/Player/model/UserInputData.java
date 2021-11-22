package com.example.Player.model;

import java.util.Objects;

public class UserInputData {
    private String displayName;
    private String description;

    public UserInputData(String displayName, String description){
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserInputData() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInputData)) return false;
        UserInputData that = (UserInputData) o;
        return Objects.equals(displayName, that.displayName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description);
    }
}
