package dev.vrudas.glp.cipher;

public interface Cipher<DTO> {

    String encode(DTO encodeData);

    String decode(DTO decodeData);

}
