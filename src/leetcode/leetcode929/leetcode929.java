package leetcode.leetcode929;

public class leetcode929 {
    public static int numUniqueEmails(String[] emails) {
        int counter = 0;
        for (int i = 0; i < emails.length; i++) {
            int at = emails[i].lastIndexOf("@");
            int plus = emails[i].indexOf("+");
            String tail = emails[i].substring(at, emails[i].length());
            String head = "";
            if (plus != -1) {
                head = emails[i].substring(0, plus);
            } else {
                head = emails[i].substring(0, at);
            }


            head = head.replaceAll("\\.", "");


            emails[i] = head + tail;

            System.out.println(emails[i]);
            boolean flag = true;
            for (int k = i - 1; k >= 0; k--) {
                if (emails[k].equals(emails[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                counter++;
            }
        }


        return counter;
    }

    public static void main(String[] args) {
        String[] arr = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(arr));
    }
}
