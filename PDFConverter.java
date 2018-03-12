import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.aspose.cells.*;
import com.aspose.words.PdfCompliance;
import com.aspose.words.PdfSaveOptions;
import com.aspose.words.SaveFormat;

public class PDFConverter {

	public String tipoDocumento = "";

	/**
	 * Método recebe o como entrada o arquivo que vai ser convertido para PDF
	 *
	 * @param bytesArquivo
	 * @return
	 */
	public byte[] converteParaPDF(byte[] bytesArquivo) {

		if (tipoDocumento.equals("EXCEL")) {

			return workFile2Excel(bytesArquivo);

		}

		if (tipoDocumento.equals("WORD")) {

			return workFile(bytesArquivo);

		} else {

			InputStream entrada = new ByteArrayInputStream(bytesArquivo);
			Workbook workbook = new Workbook(entrada);
			PdfSaveOptions opcaoSalvar = new PdfSaveOptions();
			opcaoSalvar.setCompliance(PdfCompliance.PDF_A_1_B);
			ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
			workbook.save(documentoPDF, opcaoSalvar);

			return documentoPDF.toByteArray();
		}

	}

	private byte[] workFile(byte[] bytesArquivo) throws Exception {

		InputStream entrada = new ByteArrayInputStream(bytesArquivo);
		com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
		ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
		documentoWord.save(documentoPDF, SaveFormat.PDF);

		return documentoPDF.toByteArray();

	}

	private byte[] workFile2Excel(byte[] bytesArquivo) throws Exception {

		InputStream entrada = new ByteArrayInputStream(bytesArquivo);
		Workbook asposeCellWb = new Workbook(entrada);
		ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
		asposeCellWb.save(documentoPDF, SaveFormat.PDF);

		return documentoPDF.toByteArray();
	}
}
