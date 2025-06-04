# DevCalc API

## Visão Geral

O DevCalc é uma API REST desenvolvida em Java que fornece operações matemáticas básicas. Este projeto serve como um ambiente de aprendizado e demonstração para a implementação de pipelines de CI/CD utilizando GitHub Actions. O objetivo principal é aplicar conceitos de automação de build, testes, empacotamento e simulação de deploy.

## Ferramenta de Build

Este projeto utiliza **Maven** para gerenciamento de dependências e para o processo de build.

## Executando Localmente

Para executar a aplicação localmente, após configurar o ambiente Java e Maven:

1.  Compile o projeto navegando até o diretório raiz (`DevCalc`) e executando:
    ```bash
    mvn package
    ```
2.  Após a compilação bem-sucedida, um arquivo `.jar` será gerado (normalmente em `target/DevCalc-1.0-SNAPSHOT.jar`). Este artefato conterá a aplicação pronta para ser executada (assim que as funcionalidades da API forem implementadas).

O projeto está em desenvolvimento e novas funcionalidades serão adicionadas progressivamente. 