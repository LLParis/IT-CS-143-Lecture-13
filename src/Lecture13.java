import java.io.*;
import java.lang.*;

class Lecture13 {
    private static int[] elementData = {11, -7, 3, 42, 0, 14};
    private static int size = elementData.length;

    public static void main(String[] args) {
        System.out.println("Hello from lecture 13");

        // Self-Check Problems:
        // Section 15.1: Simple ArrayIntList

        // 1. What is the difference between an array list’s size and its capacity?
        // What is the relationship between the two values? (Is one always larger or
        // smaller than the other, for instance?)
        // The difference between ArrayList's size and capacity is one. For example,
        // the size of an ArrayList may be 6 but its capacity is 7 because we account for 0.

        // 2. What fields must be included in the ArrayIntList class, and why is each
        // field important? Would the class still work correctly if we removed any of
        // these fields?
        // int[] elementData to store the integers that we are working with
        // int size to track how many elements are currently in the list.
        // If we removed elementData, we would have no way to store numbers.
        // If we removed size, we could not perform operations based on index
        // and you wouldn't know where the list starts or ends

        // 3. Why does the list class use a toString method rather than a print method?
        // toString can be used in various contexts such as concatenation or serialization.
        // a print method is solely for printing to console, so less flexible.

        // 4. We wrote the class to have public methods called size (to read the number
        // of elements of the list) and get (to access the element value at a specific
        // index).
        // Why is this approach better than declaring the fields (such as size) public?
        // Encapsulation allows the class to control how its fields are accessed or modified.
        // For example, you can make size read-only by providing a size() method without
        // a setter method.

        // 7. An element can be inserted at the beginning, middle, or end of an array
        // list.
        // Which of the three insertion points is the most computationally expensive,
        // and why? Which is the most expensive location to remove an element from the
        // list?
        // The most computationally expensive insertion point is the beginning because it requires shifting
        // every element to the right. Insertion into the middle only requires shifting of the elements to the
        // right of the insertion. Insertion at the end does not require shifting of the elements.

        // 8. Write methods called min and max that return the smallest and largest
        // values in the list respectively.
        // For example, if a variable called list stores [11, –7, 3, 42, 0, 14], the
        // call of list.min() should return –7 and the call of list.max() should return
        // 42. If the list is empty, the methods should throw an IllegalStateException.
        System.out.println("min: " + min());
        System.out.println("max: " + max());

        // Section 15.2: A More Complete ArrayIntList

        // 9. Describe the overall preconditions placed on the list class in this
        // section.
        // What assumptions do we make about how clients will use the list?
        // It is assumed that clients will respect the bounds of the list.
        // Clients are expected to handle errors.

        // 10. What is the purpose of the checkIndex method?
        // Where is it called in the list class? Describe a way that the client can
        // utilize an ArrayIntList that will be caught by checkIndex.
        // checkIndex checks whether a given index is within the acceptable range for an operation.
        // When an ArrayIntList holds five elements, and the client tries to insert a new element
        // list.add(6, element),
        // Without checkIndex, this operation might lead to unpredictable behavior
        // With checkIndex, the method would throw an IndexOutOfBoundsException

        // 11. What is the purpose of the checkCapacity method?
        // Where is it called in the list class? Describe a way that the client can
        // utilize an ArrayIntList that will be caught by checkCapacity.
        // The purpose of the checkCapacity method is to make sure of enough space.
        // If there is not enough space, it resizes the array dynamically.
        // In an ArrayIntList with 10 elements, when you try to add the eleventh,
        // without checkCapacity, adding another element is outside of the bounds
        // with checkCapacity, the method triggers an increase on the array's capacity

        // 12. Once we check thoroughly for preconditions in the code, what data
        // invariants can we now assume about the list?
        // Valid size, valid index, capacity, element integrity, and structural integrity

        // 13. Why do we bother to add the contains, isEmpty, and remove methods to the
        // list class, when the client can already perform this same functionality with
        // the indexOf, size, and remove methods, respectively?
        // isEmpty() is more readable than checking if size() returns 0.
        // indexOf returns a number rather than checking for the element directly like contains().
        // remove enables direct removal of an object without having to search for its index first.

        // Exercises:
        // None
    }

    public static int min() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int min = elementData[0];
        for (int i = 1; i < size; i++) {
            if (elementData[i] < min) {
                min = elementData[i];
            }
        }
        return min;
    }

    public static int max() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int max = elementData[0];
        for (int i = 1; i < size; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }
}
