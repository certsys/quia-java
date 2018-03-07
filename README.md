

- **Quais são os problemas que você consegue enxergar aqui?**
Tem atributo de classe publico.
O metodo de conversão vai crescer muito a cada novo tipo d arquivo.
atributo sem validação.

- **Qual refatoração você propõe?**

Criar um enum com tipo de arquivo.
Se possivel para receber o enum tipo de arquivo talvez no contrutor da classe PDFConverter.



Levei em consideração não quebrar a chamada do metodo para os cliente antigo.  Imagine que o parametro TipoDcumento e acessado pelo cliente para setar o tipo de arquivo que ele quer converter.


Obs. o codigo foi feito da ide eclipse.
