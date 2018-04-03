public class ConversorPDF {

    /**
     * Esse método recebe o como entrada o arquivo que vai ser convertido
     * para PDF
     *
     * @param bytesArquivo
     * @return
     */
    public byte[] converteParaPDF(byte[] bytesArquivo){
            InputStream entrada = new ByteArrayInputStream(bytesArquivo);
            Workbook workbook = new Workbook(entrada);
            PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
            opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
            workbook.save(documentoPDF, opcaoSalvar);

            return documentoPDF.toByteArray();
    }
}
