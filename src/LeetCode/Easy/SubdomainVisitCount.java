package LeetCode.Easy;

import java.util.*;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> vals = subdomainVisits2(cpdomains);
        for (String val : vals)
            System.out.print(val + " ");
        System.out.println();
    }

    public static List<String> anotherSolution(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int visits = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1); // this is faster than using a split method.
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + visits);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + visits);
        }

        List<String> res = new ArrayList();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }

    // this method worked first try!
    public static List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null)
            return null;

        Map<String, Integer> hashMap = new HashMap<>();

        for (String cpdomain : cpdomains) { // O(n) where n = cpdomains.length;
            String[] tokens = cpdomain.split(" ");
            int visits = Integer.parseInt(tokens[0]);
            String domain = tokens[1];

            String[] domainSplit = domain.split("\\."); // split the domains based on the "."

            String dom = domainSplit[domainSplit.length - 1]; // this is the starting value without a '.'
            placeKeyValue(hashMap, dom, visits);
            for (int i = domainSplit.length - 2; i >= 0; --i) { // O(n) where
                dom = domainSplit[i] + "." + dom;
                placeKeyValue(hashMap, dom, visits);
            }
        }
        List<String> domValues = new ArrayList<>();
        mapToList(hashMap, domValues);
        return domValues;
    }

    public static List<String> subdomainVisits2(String[] cpdomains) {
        if (cpdomains == null)
            return null;

        Map<String, Integer> hashMap = new HashMap<>();

        for (String cpdomain : cpdomains) { // O(n) where n = cpdomains.length;
            String[] tokens = cpdomain.split(" ");
            int visits = Integer.parseInt(tokens[0]);
            String domain = tokens[1];

            String[] domainSplit = domain.split("\\."); // split the domains based on the "."

            String dom = domainSplit[domainSplit.length - 1]; // this is the starting value without a '.'
            placeKeyValue(hashMap, dom, visits);
            for (int i = domainSplit.length - 2; i >= 0; --i) { // O(n) where
                dom = domainSplit[i] + "." + dom;
                placeKeyValue(hashMap, dom, visits);
            }
        }
        List<String> domValues = new ArrayList<>();
        for (String s : hashMap.keySet())
            domValues.add(hashMap.get(s) + " " + s);
        return domValues;
    }

    public static void placeKeyValue(Map<String, Integer> map, String key, int value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value); // add the previous visits with the current
        } else {
            map.put(key, value);
        }
    }

    public static void mapToList(Map<String, Integer> map, List<String> list) {
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<String, Integer> entry = iter.next();
            list.add(entry.getValue() + " " + entry.getKey());
        }
    }
}
