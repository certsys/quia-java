public class ConversorPDF {

    // A aplicação foi projetada para tratar arquivos WORD, temos que cuidar para que
    // alterações não mudem o comportamento, para que não exista reflexo para clientes
    // legados
    public String tipoDocumento = "WORD";

	
	/*
		Autor: Pedro Melo
		
		
		Se restringirmos a entrada a apenas 2 condições (se é Word ou Excell), teremos apenas o trabalho de desenvolvimento
		quando um novo formato for solicitado, mudando o tipo de origem e aplicando chamando as classes para esse 
		determinado tipo (Word -> com.aspose.words.Document, Excell -> Workbook, CAD -> CadRasterizationOptions, etc).
		Não é um trabalho complicado e minha sugestão seria definir com o cliente quais seriam os tipos arquivos que entrariam nessa rotina.
		Dessa forma, teremos um código único para cada tipo.
		E para cada novo tipo que entrar, vamos habilitando para o resto dos clientes os tipo de entrada de acordo com os tipo de conversão
		que temos, e de acordo com a necessidade de cada um.
		No meu ajuste abaixo, eu valido o arquivo que entra e identifico qual o seu tipo.
		Caso seja Word, entra na primeira condição.
		Case seja Escell, entra na segunda.
		Se não for nenhuma delas, apenas retorna null. 
		
		A ideia aqui é que seja validado no momento em que o usuári solicitar a conversão, restringindo a pesquisa dos aruqivos apenas dentro 
		dos tipo combinados.
		
		Além disso, otimizei dois pontos.
		1) A entrada do arquivo, havia código igual (InputStream entrada = new ByteArrayInputStream(bytesArquivo);) em duas condições diferentes, 
		   onde poderia ser utilizado uma vez só.
		2) O retorno (return documentoPDF.toByteArray();), caindo no mesmo caso da primeira condição.
		
		Finalizando, creio que seja uma boa otimização. Imagino que há melhores e piores formas de resolver isso, pois com programação, temos 
		muitas formas diferentes de resolver problemas e desenvolver novas soluções.
		
	*/
	
	
	
    /**
     * Esse método recebe o como entrada o arquivo que vai ser convertido
     * para PDF
     *
     * @param bytesArquivo
     * @return
     */
    public byte[] converteParaPDF(byte[] bytesArquivo, String nomeArquivo){
	
		
		InputStream entrada = new ByteArrayInputStream(bytesArquivo);
		
		if(nomeArquivo.getName().endsWith('.doc') || nomeArquivo.getName().endsWith('.docx')){
			com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
            documentoWord.save(documentoPDF, SaveFormat.PDF);
			
		}else if(nomeArquivo.getName().endsWith('.xls') || nomeArquivo.getName().endsWith('.xlsx')){
			Workbook workbook = new Workbook(entrada);
            PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
            opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
            workbook.save(documentoPDF, opcaoSalvar);
			
		}else{
			return null;
		}
		
		return documentoPDF.toByteArray();
    }
}
