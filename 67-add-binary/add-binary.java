class Solution {
    public String addBinary(String a, String b) {
        // Make both strings equal in length by padding with leading zeros
        int maxLength = Math.max(a.length(), b.length());
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Start from the end of both strings
        for (int i = maxLength - 1; i >= 0; i--) {
            int aBit = a.charAt(i) - '0'; // Convert char to int (either 0 or 1)
            int bBit = b.charAt(i) - '0'; // Convert char to int (either 0 or 1)

            // Sum the bits and carry
            int sum = aBit + bBit + carry;

            // Append the current bit to result (0 or 1)
            result.append(sum % 2);

            // Update carry (0 or 1)
            carry = sum / 2;
        }

        // If there's a carry left, append it
        if (carry > 0) {
            result.append(carry);
        }

        // Reverse the result since we constructed it backwards
        return result.reverse().toString();
    }
}