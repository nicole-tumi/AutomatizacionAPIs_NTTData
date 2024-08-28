package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenStep {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden en PetStore")
    public void crearOrden(String idOrder, String petId, String qty, String orderDate, String status, String complete) {


        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + idOrder + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + qty + ",\n" +
                        "  \"shipDate\": \"" + orderDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + complete + "\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all();
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validarIdOrder(int idOrder) {
        restAssuredThat(response -> response.body("id", equalTo(idOrder)));
        System.out.println("Id: " + SerenityRest.lastResponse().body().path("id").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarIdPet(int idPet) {
        restAssuredThat(response -> response.body("petId", equalTo(idPet)));
        System.out.println("Id pet: " + SerenityRest.lastResponse().body().path("petId").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarQty(int qty) {
        restAssuredThat(response -> response.body("quantity", equalTo(qty)));
        System.out.println("Cantidad: " + SerenityRest.lastResponse().body().path("quantity").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarShipDate(String shipDate) {
        restAssuredThat(response -> response.body("shipDate", equalTo(shipDate)));
        System.out.println("Fecha de envío: " + SerenityRest.lastResponse().body().path("shipDate").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarEstado(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
        System.out.println("Estado: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}
