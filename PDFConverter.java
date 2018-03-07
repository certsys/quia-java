package main.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;

public class PDFConverter{


    public String tipoDocumento = "WORD";



    /**
     * Levei em consideração não quebrar a chamada do metodo para os cliente antigo.
     * Imagine que o parametro TipoDcumento e acessado pelo cliente para setar o tipo de arquivo que ele quer converter.
     * Esse método recebe o como entrada o arquivo que vai ser convertido
     * para PDF
     *
     * @param bytesArquivo
     * @return
     */
    public byte[] converteParaPDF(byte[] bytesArquivo){

        if(Objects.isNull(bytesArquivo)){

            throw new IllegalArgumentException("Arquivo para conversao null");
        }

        InputStream entrada = new ByteArrayInputStream(bytesArquivo);
        EnumTipoArquivo arquivo = EnumTipoArquivo.seachTipoArquivo(tipoDocumento);

        if(Objects.isNull(arquivo)){

            throw new IllegalArgumentException("tipo de arquivo não encontrado");
        }


        ByteArrayOutputStream byteArrayOutputStream = arquivo.convertParaPDf(entrada);
        return  byteArrayOutputStream.toByteArray();
    }




}
