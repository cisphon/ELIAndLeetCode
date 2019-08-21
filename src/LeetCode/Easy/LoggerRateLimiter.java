package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    public static void main(String[] args) {
        Logger obj = new Logger();
        System.out.println(obj.shouldPrintMessage(1, "foo"));
        System.out.println(obj.shouldPrintMessage(2,"bar"));
        System.out.println(obj.shouldPrintMessage(3,"foo"));
        System.out.println(obj.shouldPrintMessage(8,"bar"));
        System.out.println(obj.shouldPrintMessage(10,"foo"));
        System.out.println(obj.shouldPrintMessage(11,"foo"));
    }
}

// This worked first try and it was pretty fast.
class Logger {

    private Map<String, Integer> hashMap;
    /** Initialize your data structure here. */
    public Logger() {
        hashMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (hashMap.containsKey(message)) {
            int previousTime = hashMap.get(message);
            if (timestamp >= previousTime + 10) {
                hashMap.put(message, timestamp);
                return true;
            }
        } else {
            hashMap.put(message, timestamp);
            return true;
        }

        return false;
    }
}