package Ajudantes;

import java.util.Base64;

public class Criptografia {

    public static String criptografiaBase64Encoder(String valor) {
        Base64.Encoder encoder = Base64.getEncoder();
        String str = encoder.encodeToString(valor.getBytes());
        return str;
    }

    public static String descriptografiaBase64Decoder(String valorCriptografado) {
        Base64.Decoder decoder = Base64.getDecoder();
        String dStr = new String(decoder.decode(valorCriptografado));
        return dStr;
    }
}
