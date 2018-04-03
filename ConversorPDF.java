import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.aspose.words.SaveFormat;

public class ConversorPDF {
    /**
     * Esse método recebe como entrada o arquivo que vai ser convertido
     * para PDF
     * 
     * @param bytesArquivo
     * @return
     * @throws Exception
     */
    public byte[] converteParaPDF(byte[] bytesArquivo) throws Exception {
        InputStream entrada = new ByteArrayInputStream(bytesArquivo);
        com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
        ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
        documentoWord.save(documentoPDF, SaveFormat.PDF);
        return documentoPDF.toByteArray();
    }
}