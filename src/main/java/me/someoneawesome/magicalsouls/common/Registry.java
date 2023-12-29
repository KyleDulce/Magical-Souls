package me.someoneawesome.magicalsouls.common;

import me.someoneawesome.magicalsouls.exceptions.ItemIdAlreadyExistsException;

import java.util.HashMap;

public class Registry<T extends Initializable> {
    private final HashMap<String, T> items = new HashMap<>();
    private final String registryTypeName;

    public Registry(String registryTypeName) {
        this.registryTypeName = registryTypeName;
    }

    public void register(String id, T item) {
        if(items.containsKey(id)) {
            throw new ItemIdAlreadyExistsException(registryTypeName + " id " + id + " already exists within Magical Souls. Try re downloading the mod.");
        }
        items.put(id, item);
    }

    public void initializeAll() {
        for(T item : items.values()) {
            item.initialize();
        }
    }

    public T getById(String id) {
        return items.get(id);
    }
}
