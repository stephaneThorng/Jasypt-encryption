package sthorng.launch;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;
import sthorng.core.JasyptHelper;

public class Launcher {

  public static void main(String[] args) {
    toEncrypt();
  }

  private static void toEncrypt() {
    Map<String, Pair<String, String>> maps = new HashMap();
    String name = "key1";
    String secret = "P@ssw0rd!";
    String message = "hello world !";
    maps.put(name, Pair.of(message, secret));
    maps.forEach((key, value) -> {
      String encrypted = JasyptHelper.encrypt(key, value);

      JasyptHelper.decrypt(name, Pair.of(encrypted, secret));
    });
  }

}
