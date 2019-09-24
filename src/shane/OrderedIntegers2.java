package shane;


public class OrderedIntegers2 {
    private int[] numbers;
    private int size;

    public OrderedIntegers2(int length) {
        this.numbers = new int[length];
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getValue(int index) {
        try {
            return numbers[index];
        }
        catch (IndexOutOfBoundsException ex) {
            throw new OrderedIntegersException("Incorrect index: " + String.valueOf(index));
        }
    }

    public void addValue(int newNumber) {
        if (size == numbers.length)
            throw new OrderedIntegersException("Array is full");
        else {
            ++size;
            addValueHelper(newNumber, 0); // this is just initialization for the recursive requirement.
        }
    }

    private void addValueHelper(int newNumber, int index) { // moves everything down until newNumber can be placed.
        if (index < getSize() && numbers[index] < newNumber) { // if the current value isn't greater than newNumber
            addValueHelper(newNumber, ++index); // increment the index
        } else { // the current value is greater than or equal to newNumber
            shiftRight(newNumber, getSize() - 1); // shift everything down from index
            numbers[index] = newNumber; // place the newNumber in that index.
        }
    }

    private void shiftRight(int newNumber, int index) { // shifts right starting from index
        if (index > 0) {
            if (numbers[index - 1] >= newNumber) {
                numbers[index] = numbers[index - 1];
                shiftRight(newNumber, --index);
            }
        }
    }

    private void shiftLeft(int index) { // shifts left starting from index
        if (index < getSize() - 1) {
            numbers[index] = numbers[index + 1];
            shiftLeft(++index);
        } else { // this is for the tail
            numbers[index] = 0;
        }
    }

    public void removeValue(int index) {
        try {
            shiftLeft(index);
            --size;
        }
        catch(IndexOutOfBoundsException ex) {
            throw new OrderedIntegersException("Incorrect index: " + String.valueOf(index));
        }
    }

    public boolean search(int value) {
        return true;
    }


    public static void main(String[] args) {
        OrderedIntegers2 orderedIntegers2 = new OrderedIntegers2(6);
        orderedIntegers2.addValue(1);
        orderedIntegers2.addValue(2);
        orderedIntegers2.addValue(4);
        orderedIntegers2.addValue(5);
        orderedIntegers2.addValue(3);


        for (int i = 0; i < orderedIntegers2.numbers.length; ++i) {
            System.out.print(orderedIntegers2.getValue(i) + " ");
        }
        System.out.println();
    }
}