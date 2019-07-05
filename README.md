# SysEstoque

Projeto de Sistema WEB da matéria de Java EE. 

## Tecnologias Utilizadas
WildFly, JSF, PostgreSQL, Omnifaces e BootsFaces

## Escopo

Dificuldade 2 - Paciente JSF com JPA Medicado

Desenvolver um sistema para gerenciar a contratação de noivos para um evento de casamento.

O sistema deverá ter funcionalidade para cadastramento do registro de contratação de prestação de serviços relacionado ao evento de casamento.

Faça  o  mapeamento  da  entidade  para  que  o  banco  de  dados  seja  criado  adequadamente utilizando JPA.

● Deve-se confeccionar uma janela para cadastramento do contrato;

● Todos os campos são obrigatórios. 

● Deve-se confeccionar uma janela para mostrar todos os elementos cadastrados;

● Ao  clicar  no  botão  “Listar  Noivos”, deve-se  navegar  para  a  janela  de  listagem.

● Desenvolva   as   Interfaces   utilizando   técnicas de templates com facelets para   a padronização  e  a  reutilização  de  código.  O template  de  tela  deve  possuir  ao  menos  3 blocos substituíveis no template. 

● Não  deve  ser  possível  cadastrar  valores  acima  de  200  convidados  para  o  campo  Nº  de convidados.  E  o  valor  do  contrato  não  pode  ser  inferior  à  R$5.200,00.  Faça  essas validações utilizando a técnica de Validators do JSF.

● Configure  o  projeto  para  realizar  acesso  ao  banco de  dados  utilizando  JPA  e  crie  uma entidade para armazenar os dados do contrato. Utilize o nome que achar mais adequado para a entidade. 

● Não  deve  ser  possível  cadastrar  o  contrato  de  noivos  com  números  de  convidados inferiores  a  100  convidados. 

● Não  deve  ser  possível excluir  um  contrato  de  noivos  caso  o contrato  já  tenha  sido  pago.  

● Caso  ocorram  esses  casos  de  exceção,  deve-se  enviar mensagens  próprias  para  o  usuário  na  tela.  

## Instalação

Utilizando o Eclipse, vá em "File > Import > JSF Project" e escolha o diretório onde você baixou o projeto.

## Utilização

Para utilizar, é necessário configurar o servidor de aplicações WildFly (ou outro de sua preferência, mas talvez necessite de alguma alteração) e configurar o persistence.xml com a configuração do banco de dados que você utilizar.

```xml
<property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL95Dialect" />
<jta-data-source>java:/cs_db</jta-data-source> 
```

Obs: Não foi utilizado o Maven para realizar a build devido a limitações de acesso à internet no campus.
