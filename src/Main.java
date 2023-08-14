// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.




import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Properties;

/**
 * Created by giangnh29 on 6/24/2019.
 */
public class Main {

    private static String key = "dl_vitd_key!#@$a";

//    private static Properties prop = MyProperties.loadProperties();

//    private static String key = prop.getProperty("key_pass_code");


    public static void main(String[] args) throws Exception {

        SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");

        System.out.println("pass vbi_dwh321!DAC#: "+encode("goku@02#2022"));
//        System.out.println("pass vbi_dwh321 "+encode("vbi_dwh321"));
////        System.out.println("pass FitzzwDuckDLRdY3Uev7Sg==: "+decode("di2bunAwpYedWzQa9M/lYw=="));
//        System.out.println("pass xlsl!@#$5: "+encode("xlsl!@#$5"));
//        System.out.println("pass Sdf@efd7f: "+encode("Sdf@efd7f"));
//        System.out.println("pass FxtBi3409# "+encode("FxtBi3409#"));
//        System.out.println("pass Viette^l!#6789 "+encode("Viette^l!#6789"));
//        System.out.println("pass Viette^l!#6789 "+encode("Viette^l!#6789"));
        System.out.println("pass Survey@123 "+encode("Survey@123"));
        System.out.println("pass Vbi@Report098 "+encode("Vbi@Report098"));
//        System.out.println(Boolean.valueOf(MyProperties.isMoveToTrash()));


//        String pass ="Survey@123";
//        System.out.println("Pass sau ma hoa la" + encode(pass));
    }




    public static String decode(String m) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] byteDecrypted = cipher.doFinal(Base64.getDecoder().decode(m));
        return new String(byteDecrypted);
    }
    public static String encode(String m) throws Exception{
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(m.getBytes());
        return  Base64.getEncoder().encodeToString(byteEncrypted);
    }
}
