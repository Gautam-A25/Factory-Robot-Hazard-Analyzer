import java.util.Scanner;
/**
 * Factory Robot Hazard Analyzer
 *
 * Displays the system name.
 *
 * @author Aayush
 * @version 3.0
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Arm precision:");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density:");
        int workerDensity = sc.nextInt();

        System.out.println("Enter Machinery State:");
        String machineryState = sc.next();

        double machineRiskFactor = 1.0;

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        sc.close();
    }
}
