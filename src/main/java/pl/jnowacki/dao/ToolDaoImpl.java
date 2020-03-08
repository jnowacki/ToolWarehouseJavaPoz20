package pl.jnowacki.dao;

import pl.jnowacki.model.Tool;
import pl.jnowacki.model.ToolType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao {

    private static ToolDaoImpl instance;
    private List<Tool> tools;

    private ToolDaoImpl(){
        tools = Arrays.asList(
                new Tool(1L, "Red hammer", ToolType.HAMMER, true),
                new Tool(2L, "Sonic screwdriver", ToolType.SCREWDRIVER, true),
                new Tool(3L, "Pila", ToolType.SAW, true),
                new Tool(4L, "Pila II", ToolType.SAW, true)
        );
    }

    public static ToolDaoImpl getInstance() {

        if(instance == null) {
            instance = new ToolDaoImpl();
        }

        return instance;
    }

    @Override
    public List<Tool> getAll() {
        return tools;
    }

    @Override
    public void setAvailability(Long id, boolean isAvailable) {
        tools.stream()
                .filter(tool -> tool.getId().equals(id))
                .findAny()
                .ifPresent(tool -> tool.setAvailability(isAvailable));
    }
}
