package sthorng.core;

import org.apache.commons.lang3.tuple.Pair;
import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptHelper {

  public static String encrypt(String key, Pair<String, String> value) {
    String result = _encrypt(value.getLeft(), value.getRight());
    System.out.println("-----ENCRYPTION-----");
    System.out.println("Name : " + key);
    System.out.println("password : " + value.getRight());
    System.out.println("key : " + value.getLeft());
    System.out.println("result : " + result);
    System.out.println("");
    return result;
  }

  public static String decrypt(String key, Pair<String, String> value) {
    String result = _decrypt(value.getLeft(), value.getRight());
    System.err.println("-----DECRYPTION-----");
    System.err.println("Name : " + key);
    System.err.println("password : " + value.getRight());
    System.err.println("key : " + value.getLeft());
    System.err.println("result : " + result);
    System.err.println("");
    return result;
  }


  private static String _encrypt(String key, String password) {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
    textEncryptor.setPasswordCharArray(password.toCharArray());
    String encryptedText = textEncryptor.encrypt(key);

    return encryptedText;
  }

  private static String _decrypt(String encryptedKey, String password) {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
    textEncryptor.setPasswordCharArray(password.toCharArray());
    String decryptedText = textEncryptor.decrypt(encryptedKey);

    return decryptedText;
  }

}
