package pl.jnowacki.model;

import java.io.Serializable;

public class Tool implements Serializable {

    private Long id;
    private String name;
    private ToolType type;
    private boolean availability;

    public Tool() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
