import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return roundUp(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return roundUp(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double roundUp(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void getDepositCalculator() {
        int periodByDeposit;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        periodByDeposit = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double profitFromDeposit = 0;
        if (action == 1) profitFromDeposit = calculateSimplePercent(depositAmount, 0.06, periodByDeposit);
        else if (action == 2) {
            profitFromDeposit = calculateComplexPercent(depositAmount, 0.06, periodByDeposit);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + periodByDeposit + " лет превратятся в " + profitFromDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().getDepositCalculator();
    }

}