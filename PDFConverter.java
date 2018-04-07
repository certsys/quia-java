public class ConversorPDF {

	// A aplica��o foi projetada para tratar arquivos WORD, temos que cuidar para que
	// altera��es n�o mudem o comportamento, para que n�o exista reflexo para clientes
	// legados
	
	public ConversorPDF( String tipo ){
		public String tipoDocumento = tipo;
	}
	
	/**
	 * Esse m�todo recebe o como entrada o arquivo que vai ser convertido
	 * para PDF
	 *
	 * @param bytesArquivo
	 * @return
	 */
	public byte[] converteParaPDF(byte[] bytesArquivo) throws Exception{
		ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
		
		if (tipoDocumento.equals("WORD") || tipoDocumento.equals("EXCEL")){
			try{
				if(tipoDocumento.equals("WORD")) {
					InputStream entrada = new ByteArrayInputStream(bytesArquivo);
					com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
					documentoWord.save(documentoPDF, SaveFormat.PDF);

					return documentoPDF.toByteArray();
				} else {
					InputStream entrada = new ByteArrayInputStream(bytesArquivo);
					Workbook workbook = new Workbook(entrada);
					PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
					opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
					workbook.save(documentoPDF, opcaoSalvar);

					return documentoPDF.toByteArray();
				}
			}catch(Exception e){
				System.out.println("Erro ao converter o arquivo do tipo" + tipoDocumento);
			}
		} else {
			System.out.println("Tipo de arquivo n�o permitido:" + tipoDocumento);
			return null;
		}
	}
}
