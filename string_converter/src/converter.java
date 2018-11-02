public class converter {
    public static void main(String[] args) {
        // Enter text in params below
        convert("This NETbuilder assessment is way too easy.");
    }

    public static void convert(String userInput) {
        String output = "";

        // Convert input into lower case so that correct ascii code is shown
        userInput = userInput.toLowerCase();

        for (int count = 0; count <= (userInput.length() - 1); count++) {
            // Convert each character into ascii code to calculate alphabet position
            int charCode = Character.codePointAt(userInput, count);

            // Ensures that only letters a-z are allowed
            if (charCode > 97 && charCode < 122) {
                // Ascii code for a starts at 97, so minus 96 to get the alphabet position
                charCode = charCode - 96;
                output = output + String.valueOf(charCode) + " ";
            }
        }
        System.out.println(output);
    }
}