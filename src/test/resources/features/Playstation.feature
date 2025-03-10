Feature: Playstation

  Background: Precondicion del feature
    Given El usuario navega a la pagina de Liverpool

  @regression
  Scenario: Verificar que la pagina de Liverpool carga
    Then El usuario verifica que la pagina Liverpool sea correcta

  @regression
  Scenario: Buscar y validar detalles de una consola playstation
    When El usuario ingresa "playstation" en la barra de busqueda
    Then El usuaro es redirigido a la pagina de resultados de playstation
    And El usuario hace click en el link consolas
    Then El usuario verifica que la página de consolas muestra la lista de consolas disponibles
    And El usuario hace clic en el primer artículo de la lista
    Then El usuario verifica que la página de detalles del artículo muestra el título "PLAYSTATION"
    And El usuario verifica que el precio del artículo es "9999.00"