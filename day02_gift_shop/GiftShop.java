class GiftShop {
    public static void main(String[] args) {
        String inputPath = "inputs/day02_input.txt";
        InvalidIdsIdentifier identifier = new InvalidIdsIdentifier();

        identifier.feedRangesList(inputPath);
        identifier.detectInvalids();

        System.out.println("Sum: " + identifier.getSumOfInvalidIds());
    }
}