package main.java;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.stream.Stream;

public enum EnumTipoArquivo implements Convert {



    WORD() {

        @Override

        public ByteArrayOutputStream convertParaPDf(InputStream entrada ) {
            //com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
           // documentoWord.save(documentoPDF, SaveFormat.PDF);
            return documentoPDF;
        }
    },

    EXCEL() {
        @Override
        public ByteArrayOutputStream convertParaPDf(InputStream entrada ) {

            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
           /* Workbook workbook = new Workbook(entrada);
            PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
            opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
            workbook.save(documentoPDF, opcaoSalvar);*/
            return documentoPDF;
        }
    };



    public static EnumTipoArquivo seachTipoArquivo(String tipoArquivo){
          EnumTipoArquivo[] values = EnumTipoArquivo.values();
         return  Stream.of(values).filter(v->v.name().equals(tipoArquivo)).findFirst().orElse(null);
    }



}