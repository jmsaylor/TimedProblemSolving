package com.johnsaylor.codesignal;

import java.util.Arrays;

public class FreedomFinancialCoverDebts {

    public static void main(String[] args) {
        System.out.println(coverDebts(50, new int[]{2,2,5}, new int[]{200, 100, 150}));
//        System.out.println(coverDebts(40, new int[]{2,2,5}, new int[]{75, 25, 25}));
    }

    static double coverDebts(int s, int[] debts, int[] interests) {
        for (int i = 0; i < debts.length; i++) {
            for (int j = 0; j < debts.length - 1; j++) {
                if (interests[j] < interests[j + 1]) {
                    int debtTemp = debts[j + 1];
                    debts[j + 1] = debts[j];
                    debts[j] = debtTemp;

                    int interestTemp = interests[j + 1];
                    interests[j + 1] = interests[j];
                    interests[j] = interestTemp;
                }
            }
        }

        System.out.println(Arrays.toString(debts));
        System.out.println(Arrays.toString(interests));

        double monthlySpend = s * 0.10;

        int index = 0;
        double[] balances = new double[debts.length];

        for (int i = 0; i < debts.length; i++) {
            balances[i] = debts[i];
        }
        System.out.println(Arrays.toString(balances));

        for (int i = 0; i < interests.length; i++) {
            if (interests[i] < 100) {
                interests[i] += 100;
            }
        }

        double total = 0;

            while (balances[balances.length - 1] > 0) {
                double debtBudget = monthlySpend;
                System.out.println(index);

                while (index < balances.length && debtBudget > 0) {
                    if (debtBudget > balances[index]) {
                        debtBudget -= balances[index];
                        total += balances[index];
                        balances[index] = 0;
                        index++;
                    } else {
                        balances[index] = balances[index] - debtBudget;
                        total += debtBudget;
                        System.out.println("break: "  + Arrays.toString(balances));
                        break;
                    }
                }

                for (int i = index; i < debts.length; i++) {
                    balances[i] = balances[i]  * (interests[i] / 100d);
                }
                System.out.println(Arrays.toString(balances));
            }


//        System.out.println(Arrays.toString(debts));
//        System.out.println(Arrays.toString(interests));
        return total;
    }

    static double coverDebtsv1(int s, int[] debts, int[] interests) {
        for (int i = 0; i < debts.length; i++) {
            for (int j = 0; j < debts.length - 1; j++) {
                if (debts[j] > debts[j + 1]) {
                    int debtTemp = debts[j + 1];
                    debts[j + 1] = debts[j];
                    debts[j] = debtTemp;

                    int interestTemp = interests[j + 1];
                    interests[j + 1] = interests[j];
                    interests[j] = interestTemp;
                } else if (debts[j] == debts[j + 1]) {
                    if (interests[j] < interests[j + 1]) {
                        int temp = interests[j + 1];
                        interests[j + 1] = interests[j];
                        interests[j] = temp;
                    }
                }
            }
        }


        double monthlySpend = s * 0.10;

        int index = 0;
        double[] balances = new double[debts.length];

        for (int i = 0; i < debts.length; i++) {
            balances[i] = debts[i];
        }
        System.out.println(Arrays.toString(balances));

        for (int i = 0; i < interests.length; i++) {
            if (interests[i] < 100) {
                interests[i] += 100;
            }
        }

        double total = 0;

        while (balances[balances.length - 1] > 0) {
            double debtBudget = monthlySpend;
            System.out.println(index);

            while (index < balances.length && debtBudget > 0) {
                if (debtBudget > balances[index]) {
                    debtBudget -= balances[index];
                    total += balances[index];
                    balances[index] = 0;
                    index++;
                } else {
                    balances[index] = balances[index] - debtBudget;
                    total += debtBudget;
                    System.out.println("break: "  + Arrays.toString(balances));
                    break;
                }
            }

            for (int i = index; i < debts.length; i++) {
                balances[i] = balances[i]  * (interests[i] / 100d);
            }
            System.out.println(Arrays.toString(balances));
        }


//        System.out.println(Arrays.toString(debts));
//        System.out.println(Arrays.toString(interests));
        return total;
    }
}
