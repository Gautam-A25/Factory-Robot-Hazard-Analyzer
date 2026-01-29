import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer
 *
 * Final implementation using Map-based machinery state handling.
 *
 * @author Aayush
 * @version 8.0
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.next();

        try {
            calculateHazardRisk(armPrecision, workerDensity, machineryState);
        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    private static void calculateHazardRisk(double armPrecision,
                                            int workerDensity,
                                            String machineryState)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        Map<String, Double> machineryRiskMap = buildMachineryRiskMap();

        if (!machineryRiskMap.containsKey(machineryState)) {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        double machineRiskFactor = machineryRiskMap.get(machineryState);

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        System.out.println("Robot Hazard Risk Score: " + hazardRisk);
    }

    private static Map<String, Double> buildMachineryRiskMap() {

        Map<String, Double> riskMap = new HashMap<>();
        riskMap.put("Worn", 1.3);
        riskMap.put("Faulty", 2.0);
        riskMap.put("Critical", 3.0);

        return riskMap;
    }
}
