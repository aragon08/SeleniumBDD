Feature: Playstation

  Background: Precondicion del feature
    Given El usuario navega a la pagina de Liverpool

  @regression
  Scenario: Verificar que la pagina de Liverpool carga
    Then El usuario verifica que la pagina Liverpool sea correcta


  @regression
  Scenario: Buscar y filtrar smart tv en Liverpool
    When El usuario busca "smart tv" en la barra de busqueda
    Then El usuarios es redirigido a la pagina de resultados de smart tv
    And La pagina contiene los filtros: Size y Price
    And el usuario seleciona los filtros: Size 55 pulgadas, price mayor a 10000 y brand Sony