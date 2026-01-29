/**
 * Custom exception for robot safety violations.
 */
public class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
    }
}
