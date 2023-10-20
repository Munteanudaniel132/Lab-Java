public class main {
    public static void main(String[] args) {
        int[] month_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        for (int i = 0; i < months.length; i++) {
            if (month_days[i] < 31) {
                System.out.println(months[i] + " has " + month_days[i] + " days.");
            }
        }
    }
}