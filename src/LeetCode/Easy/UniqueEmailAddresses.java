package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        String[] strings = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};


//        System.out.println(numUniqueEmails(strings));
    }

    public static int yetAnotherSolution(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            StringBuilder sb = new StringBuilder(); // this is faster than using String
            for(char c: email.toCharArray()) {
                if (c == '.') continue;
                if (c == '+') break;
                if (c == '@') break; // this line need be added to make the older version work.
                sb.append(c);
            }
            String cur = sb.toString() + email.substring(email.indexOf('@')); // local name + domain
            set.add(cur);
        }
        return set.size();
    }

    public static int anotherSolution(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.
        }
        return normalized.size();
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> processedEmails = new HashSet<>(); // no dupes

        for (String email : emails) {
            boolean inDomain = false;
            boolean ignored = false;

            String processed = "";
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (!inDomain && !ignored) { // local part before potential '+'
                    if (('a' <= c && c <= 'z') || ('1' <= c && c <= '9')) {
                        processed += c;
                    } else if (c == '+') {
                        ignored = true;
                    } else if (c == '@') {
                        inDomain = true;
                        processed += c;
                    }
                } else if (!inDomain && ignored) { // after '+' and before '@'
                    if (c == '@') {
                        inDomain = true;
                        processed += c;
                    }
                } else if (inDomain) { // after '@'
                    processed += c;
                }
            }
            processedEmails.add(processed);
        }
        return processedEmails.size();
    }
}