/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Bar implements Comparable<Bar> {

    private String name;
    private int value;
    private String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("value is negative");
        }
        if (category == null) {
            throw new IllegalArgumentException("category is negative");
        }

        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException();
        }
        return this.value - that.value;
    }

    // Sample client (see below).
    public static void main(String[] args) {

    }

}