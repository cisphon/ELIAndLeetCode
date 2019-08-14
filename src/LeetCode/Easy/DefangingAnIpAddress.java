package LeetCode.Easy;

public class DefangingAnIpAddress {

    public static void main(String[] args) {
        String s = "12.1.1.1";
        DefangingAnIpAddress d = new DefangingAnIpAddress();
        System.out.println(d.defangIPaddr(s));
    }

    public String defangIPaddr(String address) {
        String[] nums = {"", "", "", ""};
        for(int i = 0, numIndex = 0; i < address.length() && numIndex < nums.length; i++) {
            char curr = address.charAt(i);
            if (curr == '.') {
                numIndex++;
            } else {
                nums[numIndex] = nums[numIndex] + curr;
            }
        }
        return nums[0] + "[.]" + nums[1] + "[.]" + nums[2] + "[.]" + nums[3];
    }
}
