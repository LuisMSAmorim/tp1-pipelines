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

(alteração readme)

## Debugging de Workflows

Para exercitar a depuração de workflows, introduzi uma falha de propósito no pipeline de CI/CD. A falha foi causada pela alteração do comando mvn clean install -DskipTests para mvn clen install -DskipTests no arquivo .github/workflows/ci.yml.

A identificação do problema foi feita através da aba Actions no GitHub. Ao navegar para o flow que falhou, os logs do job build_project mostraram um erro indicando que o comando clen não foi encontrado.

A correção foi simples, bastou reverter a alteração no arquivo .github/workflows/ci.yml, corrigindo o erro de digitação no comando do Maven. Após o commit e push da correção, o pipeline voltou a executar com sucesso.