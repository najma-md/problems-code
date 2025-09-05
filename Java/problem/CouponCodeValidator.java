package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CouponCodeValidator {

    class Coupon {

        String code;
        String businessLine;
        Boolean isActive;

        Coupon(String code, String businessLine, Boolean isActive) {

            this.code = code;
            this.businessLine = businessLine;
            this.isActive = isActive;
        }
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<Coupon> validCoupons = new ArrayList();

        List<String> output = new ArrayList();

        HashMap<String, String> businessLineValues = new HashMap();
        businessLineValues.put("electronics", "1");
        businessLineValues.put("grocery", "2");
        businessLineValues.put("pharmacy", "3");
        businessLineValues.put("restaurant", "4");

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && code[i].matches("^[a-zA-Z0-9_]+$") && businessLineValues.containsKey(businessLine[i])) {
                Coupon c = new Coupon(code[i], businessLine[i], isActive[i]);
                validCoupons.add(c);
            }

        }

        Collections.sort(validCoupons, (c1, c2)
                -> {
            int cmp = c1.businessLine.compareTo(c2.businessLine);
            if (cmp == 0) {
                return c1.code.compareTo(c2.code);
            }
            return cmp;
        });

        for (Coupon ccal : validCoupons) {
            output.add(ccal.code);
        }

        return output;

    }

    public static void main(String[] args) {
        CouponCodeValidator validator = new CouponCodeValidator();

        String[] codes = {"SAVE10", "BLACKFRIDAY", "CYBERMONDAY"};
        String[] businessLines = {"electronics", "grocery", "pharmacy"};
        boolean[] isActive = {true, false, true};

        List<String> validCoupons = validator.validateCoupons(codes, businessLines, isActive);

        System.out.println("Valid Coupons:");
        for (String coupon : validCoupons) {
            System.out.println(coupon);
        }
    }

}
