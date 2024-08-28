package com.nttdata.steps;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import net.thucydides.core.annotations.Step;

public class ConsultarOrdenStep {

    private static String URL = "https://petstore.swagger.io/v2/store/order/";
    private Response response;

    @Step("consulto la orden registrada con el id {int}")
    public void consultarOrden(int idOrder) {

        response =
        given()
                .contentType("application/json")
                .log()
                .all()
                .get(URL + idOrder);

        System.out.println("Response: " + response.asString());
        System.out.println("Status code: " + response.statusCode());
    }

    public void validarCodigoRespuesta(int statusCode) {
        if (response == null) {
            throw new IllegalStateException("La respuesta es null.");
        }
        if (response.statusCode() != statusCode) {
            throw new AssertionError("Código de estado esperado: " + statusCode + ", pero se recibió: " + response.statusCode());
        }
        System.out.println("Status code: " + response.statusCode());
    }

    public void validarIdPet(int idPet) {
        if (response == null) {
            throw new IllegalStateException("La respuesta es null.");
        }
        //restAssuredThat(response -> response.body("petId", equalTo(idPet)));
        int actualIdPet = response.jsonPath().getInt("petId");
        if (actualIdPet != idPet) {
            throw new AssertionError("ID de mascota esperado: " + idPet + ", pero se recibió: " + actualIdPet);
        }
        System.out.println("Id pet: " + response.body().path("petId").toString());

    }

    public void imprimirOrden() {
        // Obtener los valores del JSON
        int id = response.jsonPath().getInt("id");
        int petId = response.jsonPath().getInt("petId");
        int quantity = response.jsonPath().getInt("quantity");
        String shipDate = response.jsonPath().getString("shipDate");
        String status = response.jsonPath().getString("status");
        boolean complete = response.jsonPath().getBoolean("complete");

        // Imprimir detalle de la orden
        System.out.println("-------------------------------");
        System.out.println("Id de la Orden: " + id);
        System.out.println("Id de la mascota: " + petId);
        System.out.println("Cantidad: " + quantity);
        System.out.println("Fecha de envío: " + shipDate);
        System.out.println("Estado: " + status);
        System.out.println("¿Orden completada?: " + complete);
        System.out.println("-------------------------------");
    }


}
