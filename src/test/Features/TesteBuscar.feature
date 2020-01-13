#language=pt
@test
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Validar quantidade retornada da  busca do diretor no Google
    Given Estou na pagina do Google
    And Insiro o nome "<nomeDiretor>" do diretor
    When clico em Pesquisar
    And Busca e realizada
    Then retorna o numero total dos resultados do paramento da busca
    

