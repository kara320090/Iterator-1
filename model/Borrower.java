package model;
import java.util.Objects;

public class Borrower {
    private final String name;
    private final int number;

    public Borrower(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() { return number; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "[Borrower] " + number + " / " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrower)) return false;
        return number == ((Borrower)o).number;
    }

    @Override
    public int hashCode() { return Objects.hash(number); }
}
