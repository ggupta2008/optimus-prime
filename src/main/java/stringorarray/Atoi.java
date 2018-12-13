package stringorarray;

public class Atoi {
    public int parseInt(String str) {
        if(str == null) return 0;
        str = str.trim();
        int sign = 1;
        int startIndex = 0;
        long result = 0;
        if(str.length() > 0) {
            if(str.charAt(0) == '-') {
                sign = -1;
                startIndex++;
            } else if(str.charAt(0) == '+') {
                startIndex++;
            }

            for (int i = startIndex; i < str.length(); i++) {
                char temp = str.charAt(i);
                if(Character.isDigit(temp)) {
                    result = result*10 + (temp - '0');
                } else {
                    break;
                }

                if(result > Integer.MAX_VALUE){
                    if(sign == -1)
                    return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
            }
        } else {
            return 0;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.parseInt("-1223"));
    }
}
