public class ConversorPDF {
    /**
     * Esse método recebe como entrada o arquivo que vai ser convertido
     * para PDF
     *
     * @param bytesArquivo
	 * @param tipoDocumento
     * @return
     */
    public byte[] converteParaPDF(byte[] bytesArquivo, String tipoDocumento){
		
		/*  Verifica se foi passado um arquivo e um tipo de documento, caso não, 
		 *  não existe necessidade de executar o método, pelo contrário, 
		 *	caso seja ele resultará uma exception para o usuário.
		 */
		if (bytesArquivo != null && tipoDocumento != null){
			
			InputStream entrada = new ByteArrayInputStream(bytesArquivo);
			
			if(tipoDocumento.equals("WORD")) {
				com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
				ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
				documentoWord.save(documentoPDF, SaveFormat.PDF);
				
			} else if(tipoDocumento.equals("EXCEL")) {
				Workbook workbook = new Workbook(entrada);
				PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
				opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
				ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
				workbook.save(documentoPDF, opcaoSalvar);
			}
			
			return documentoPDF.toByteArray();
		}
    }
}
