Feature: Login

  Background: Precondicion del feature
    Given El usuario navega a la pagina de Login

#    @regression
#    Scenario: Credenciales invalidas
#      When El usuario escribe el username "locked_out_user" con el password "secret_sauce" y presiona el boton de loggin
#      Then Debe aparecer un mensaje de error indicando "Epic sadface: Sorry, this user has been locked out."
#
#    @regression
#    Scenario: Credenciales inexistentes
#      When El usuario escribe el username "hola mundo" con el password "hola123" y presiona el boton de loggin
#      Then Debe aparecer un mensaje de error indicando "Epic sadface: Username and password do not match any user in this service"

    @regression
    Scenario Outline: Credenciales erroneas
      When El usuario escribe el username <username> con el password <password> y presiona el boton de loggin
      Then Debe aparecer un mensaje de error indicando <errorMessage>
      Examples:
        | username          | password       | errorMessage                                                                |
        | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out."                       |
        | "hola mundo"      | "hola123"      | "Epic sadface: Username and password do not match any user in this service" |

    @regression @smoke
      Scenario: Verificar la UI de la pagina
      Then El usuario verifica que la UI de la pagina login sea correcta