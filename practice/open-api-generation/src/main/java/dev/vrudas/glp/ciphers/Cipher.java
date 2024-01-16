package dev.vrudas.glp.ciphers;

public interface Cipher<DTO> {

    String encode(DTO encodeData);

    String decode(DTO decodeData);

}
