import java.security.SecureRandom;
public class OTPGenerator {
    private static final String OTP_CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6; // length of the OTP

    public static String generateOTP() {
        StringBuilder sb = new StringBuilder(OTP_LENGTH);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(OTP_CHARACTERS.length());
            sb.append(OTP_CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }


}
