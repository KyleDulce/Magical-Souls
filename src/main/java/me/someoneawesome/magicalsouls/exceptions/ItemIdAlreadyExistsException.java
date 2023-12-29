package me.someoneawesome.magicalsouls.exceptions;

public class ItemIdAlreadyExistsException extends MagicalSoulsException {
    public ItemIdAlreadyExistsException() {
        super();
    }

    public ItemIdAlreadyExistsException(String message) {
        super(message);
    }
}
