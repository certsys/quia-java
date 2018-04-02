public class ConversorPDF {

    // A aplicação foi projetada para tratar arquivos WORD, temos que cuidar para que
    // alterações não mudem o comportamento, para que não exista reflexo para clientes
    // legados
    public String tipoDocumento = "WORD";

    /**
     * Esse método recebe o como entrada o arquivo que vai ser convertido
     * para PDF
     *
     * @param bytesArquivo
     * @return
     */
    public byte[] converteParaPDF(byte[] bytesArquivo){
        if(tipoDocumento.equals("WORD")) {            
            return wordToPDF(bytesArquivo);
        } else if(tipoDocumento.equals("EXCEL")) {            
            return excelToPDF(bytesArquivo);      
        }else{
            return null;
        }
    }

    /**
     * Esse método recebe o como entrada um arquivo no formato word que vai ser convertido
     * para PDF
     * @param bytesArquivo
     * @return
     */
    public byte[] wordToPDF(byte[] bytesArquivo)
    {
        InputStream entrada = new ByteArrayInputStream(bytesArquivo);
        ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();        
        com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);            
        documentoWord.save(documentoPDF, SaveFormat.PDF);   
        
        return documentoPDF.toByteArray(byte[] bytesArquivo);
    }

    /**
     * Esse método recebe o como entrada um arquivo no formato excel que vai ser convertido
     * para PDF
     * @param bytesArquivo
     * @return
     */
    public byte[] excelToPDF()
    {
        InputStream entrada = new ByteArrayInputStream(bytesArquivo);
        ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();         
        Workbook workbook = new Workbook(entrada);
        PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
        opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
        workbook.save(documentoPDF, opcaoSalvar);                
        
        return documentoPDF.toByteArray();
    }
}
