## Workflow ou Action

Um workflow é basicamente o arquivo .yml que fica na pasta .github/workflows do seu repositório. É como uma receita que define quando e como as coisas vão rodar. No meu projeto, tenho o ci.yml que é um workflow completo.

Já uma action é uma ferramenta pronta que alguém criou e disponibilizou para reutilizar. É como um código pronto que você pode usar no seu workflow. Por exemplo, actions/checkout@v4 é uma action que baixa o código do repositório.

## Como funciona uma Action internamente

Uma action é estruturada como um mini-projeto. Ela tem:

- Código principal geralmente em JavaScript, Docker ou até shell script
- Metadados definidos no arquivo action.yml
- Documentação explicando como usar

O arquivo action.yml é o core da action. Ele define três coisas principais:
- inputs: os parâmetros que você pode passar
- outputs: o que a action retorna (se retornar algo)
- runs: como a action deve ser executada

## Exemplo prático: setup-java

A actions/setup-java@v4 que uso no meu pipeline. No workflow ela aparece assim:

'''
- name: Set up JDK 11
  uses: actions/setup-java@v4
  with:
    java-version: '11'
    distribution: 'temurin'
    cache: 'maven'
'''

O uses: é o que fala "oi, quero usar essa action aqui". O with: passa os parâmetros que a action espera receber.

Se você fosse olhar o action.yml dessa action (que tá lá no repositório da GitHub), veria algo parecido com:

'''
inputs:
  java-version:
    description: 'The Java version to set up'
    required: true
  distribution:
    description: 'Java distribution'
    default: 'temurin'
  cache:
    description: 'Name of dependency manager for caching'
    required: false
'''

É assim que a action sabe quais parâmetros aceitar e o que fazer com eles.
