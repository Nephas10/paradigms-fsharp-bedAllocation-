package dee;
public class BedAllocation {
    public static void main(String[] args) {
        // Arrays for beds and names
        int[] bedNumbers = {1, 2, 3, 4, 5};
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        // Allocate people to beds
        String[] bedAllocation = new String[bedNumbers.length];
        for (int i = 0; i < bedNumbers.length && i < names.length; i++) {
            bedAllocation[i] = names[i] + " - Bed " + bedNumbers[i];
        }

        // Traverse and print the array
        System.out.println("Bed Allocation:");
        for (String allocation : bedAllocation) {
            System.out.println(allocation);
        }
    }
}
