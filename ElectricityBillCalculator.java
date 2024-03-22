public class ElectricityBillCalculator {
    private double totalBill;

    public ElectricityBillCalculator(double unitsConsumed) {
        calculateBill(unitsConsumed);
    }

    private void calculateBill(double unitsConsumed) {
        if (unitsConsumed <= 50) {
            totalBill = unitsConsumed * 0.50;
        } else if (unitsConsumed <= 100) {
            totalBill = 50 * 0.50 + (unitsConsumed - 50) * 0.75;
        } else if (unitsConsumed <= 200) {
            totalBill = 50 * 0.50 + 50 * 0.75 + (unitsConsumed - 100) * 1.20;
        } else {
            totalBill = 50 * 0.50 + 50 * 0.75 + 100 * 1.20 + (unitsConsumed - 200) * 1.50;
        }
    }

    public double getTotalBill() {
        return totalBill;
    }
}
