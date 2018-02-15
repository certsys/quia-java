# quia-java

Temos uma classe que converte documentos do Word para PDFs. A tarefa é simples, receber o arquivo Word e retornar ele em um formato PDF - Essa aplicação utiliza uma biblioteca que converte documentos do Word em PDFs. A biblioteca *Aspose.words*.

O cliente pede para que seja adicionado a opção para converter o documentos Excel para PDF, e para isso adicionamos um condicional para efetuar essa transformação. Com isso temos a seguinte classe:
```java
public class ConversorPDF {

    // A aplicação foi projetada para tratar arquivos WORD, alter o código vai modificar 
    // o comportamento para os clientes antigos, é necessário garantir a compatibilidade 
    // com clientes antigos nas novas alterações
    public String tipoDocumento = "WORD";

    /**
     * Esse método recebe como entrada o arquivo que vai ser convertido
     * para PDF
     *
     * @param bytesArquivo
     * @return
     */
    public byte[] converteParaPDF(byte[] bytesArquivo){
        if(tipoDocumento.equals("WORD")) {
            InputStream entrada = new ByteArrayInputStream(bytesArquivo);
            com.aspose.words.Document documentoWord = new com.aspose.words.Document(entrada);
            ByteArrayOutputStream documentoPDF = new ByteArrayOutputStream();
            documentoWord.save(documentoPDF, SaveFormat.PDF);

            return documentoPDF.toByteArray();
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
}
```
[PDFConverter](https://github.com/certsys/quia-java/blob/master/PDFConverter.java)

Este código funcionará perfeitamente para o novo cliente (e ainda funcionará conforme o esperado para os clientes existentes), mas alguns problemas de design de software estão começando a aparecer no código. Isso significa que não estamos fazendo isso da maneira perfeita, e não seremos capazes de modificar nossa classe facilmente quando um novo tipo de documento for solicitado.

- **Quais são os problemas que você consegue enxergar aqui?**
- **Qual refatoração você propõe?**

Por favor, envie um pull request com as alterações que você recomendaria aqui. Tente gastar 30 minutos no máximo para todo o trabalho. Se você precisar de mais tempo, está fazendo algo errado. 

Além disso, se você acha que algo mais deve ser refatorado ainda mais, coloque suas idéias na descrição do pull request.
