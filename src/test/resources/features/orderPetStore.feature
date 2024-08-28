Feature: Crear y consultar ordenes en PetStore

  @Test
  Scenario Outline: Crear una orden para un cliente en PetStore

    When creo una orden con el id "<idOrder>" el codigo de mascota es "<idPet>" y la cantidad "<quantity>" la fecha de envio "<shipDate>" el estado es "<status>" y es completa "<complete>"
    Then el status de la creacion de la orden es <statusCode>
    And el id de orden es <idOrder>
    And el id de la mascota es <idPet>
    And la cantidad es <quantity>
    And la fecha de envio es "<expectedShipDate>"
    And el estado debe ser "<status>"
    Examples:
      | idOrder | idPet | quantity | shipDate                 | status    | complete | statusCode | expectedShipDate             |
      | 101     | 1     | 5        | 2024-08-28T14:04:04.800Z | recibida  | true     | 200        | 2024-08-28T14:04:04.800+0000 |
      | 102     | 2     | 10       | 2024-08-29T15:05:05.900Z | enviada   | false    | 200        | 2024-08-29T15:05:05.900+0000 |
      | 103     | 3     | 2        | 2024-08-30T16:06:06.100Z | cancelada | true     | 200         | 2024-08-30T16:06:06.100+0000 |
      | 104     | 4     | 7        | 2024-09-01T17:07:07.200Z | procesada | false    | 200        | 2024-09-01T17:07:07.200+0000 |
      | 105     | 5     | 3        | 2024-09-02T18:08:08.300Z | recibida  | true     | 200        | 2024-09-02T18:08:08.300+0000 |

  @Test
 Scenario Outline: Consultar una orden en PetStore
    When consulto la orden registrada con el id <idOrder>
    Then el status de la consulta debe ser <statusCode>
    And el codigo de la mascota debe ser <idPet>
    And imprimo el detalle de la orden
    Examples:
      | idOrder | idPet | statusCode |
      | 101     | 1     | 200        |
      | 102     | 2     | 200        |
      | 103     | 3     | 200        |
      | 104     | 4     | 200        |
      | 105     | 5     | 200        |

