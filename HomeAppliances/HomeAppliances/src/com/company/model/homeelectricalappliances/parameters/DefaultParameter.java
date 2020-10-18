package com.company.model.homeelectricalappliances.parameters;

import java.util.Objects;

public class DefaultParameter implements Parameters{
    String value;
    @Override
    public String getName() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultParameter that = (DefaultParameter) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public DefaultParameter(String value) {
        this.value = value;
    }
}
