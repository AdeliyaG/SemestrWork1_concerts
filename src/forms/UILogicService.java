package forms;

import models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class UILogicService {

    public String getHashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] mdbytes = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < mdbytes.length; j++) {
                String s = Integer.toHexString(0xff & mdbytes[j]);
                s = (s.length() == 1) ? "0" + s : s;
                sb.append(s);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
            return null;
        }
    }
}
