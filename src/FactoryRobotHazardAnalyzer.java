import java.util.Scanner;
/**
 * Factory Robot Hazard Analyzer
 *
 * Displays the system name.
 *
 * @author Aayush
 * @version 6.0
 */
public class FactoryRobotHazardAnalyzer {
    private static void calculateHazardRisk(double armPrecision,
                                            int workerDensity,
                                            String machineryState) throws RobotSafetyException {

        double machineRiskFactor;

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        System.out.println("Robot Hazard Risk Score: " + hazardRisk);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Arm precision:");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density:");
        int workerDensity = sc.nextInt();

        System.out.println("Enter Machinery State:");
        String machineryState = sc.next();

        try {
            calculateHazardRisk(armPrecision, workerDensity, machineryState);
        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
