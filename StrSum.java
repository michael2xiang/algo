import java.util.Stack;

public class StrSum {
    public static void main(String[] args) {
        String a = "1119";
        String b = "1";
        StrSum obj = new StrSum();
        String res = obj.sum(a, b);

        System.out.println(res);
    }

    public String sum(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        Stack<String> stack = new Stack<>();
        int n = a.length() - 1, m = b.length() - 1;
        int flat = 0;
        while (n >= 0 && m >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(n))) + Integer.parseInt(String.valueOf(b.charAt(m)));
            sum += flat;
            if (sum >= 10) {
                flat = sum / 10;
                stack.push(String.valueOf(sum % 10));
            } else {
                stack.push(String.valueOf(sum));
                flat = 0;
            }
            n--;
            m--;
        }
        while (n >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(n))) + flat;
            if (sum >= 10) {
                flat = sum / 10;
                stack.push(String.valueOf(sum % 10));
            } else {
                stack.push(String.valueOf(sum));
                flat = 0;
            }
            n--;
        }
        while (m >= 0) {
            int sum = Integer.parseInt(String.valueOf(b.charAt(m))) + flat;
            if (sum >= 10) {
                flat = sum / 10;
                stack.push(String.valueOf(sum % 10));
            } else {
                stack.push(String.valueOf(sum));
                flat = 0;
            }
            m--;
        }

        StringBuilder sb = new StringBuilder();
        int i = stack.size();
        for (; i > 0; i--) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}