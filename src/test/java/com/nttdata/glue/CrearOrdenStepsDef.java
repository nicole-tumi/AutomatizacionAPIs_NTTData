package com.nttdata.glue;

import com.nttdata.steps.CrearOrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrearOrdenStepsDef {


    @When("creo una orden con el id {string} el codigo de mascota es {string} y la cantidad {string} la fecha de envio {string} el estado es {string} y es completa {string}")
    public void creoUnaOrdenConElIdElCodigoDeMascotaEsYLaCantidadLaFechaDeEnvioElEstadoEsYEsCompleta(String idOrder, String idPet, String qty, String shipDate, String status, String complete) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.crearOrden(idOrder,idPet,qty,shipDate,status,complete);
    }

    @Then("el status de la creacion de la orden es {int}")
    public void elStatusDeLaCreacionDeLaOrdenEs(int statusCode) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.validarCodigoRespuesta(statusCode);
    }


    @And("el id de orden es {int}")
    public void elIdDeOrdenEs(int idOrder) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.validarIdOrder(idOrder);
    }


    @And("el id de la mascota es {int}")
    public void elIdDeLaMascotaEs(int petId) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.validarIdPet(petId);

    }

    @And("la cantidad es {int}")
    public void laCantidadEs(int qty) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.validarQty(qty);
    }

    @And("la fecha de envio es {string}")
    public void laFechaDeEnvioEs(String shipDate) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.validarShipDate(shipDate);
    }

    @And("el estado debe ser {string}")
    public void elEstadoDebeSer(String status) {
        CrearOrdenStep crearOrdenStep = new CrearOrdenStep();
        crearOrdenStep.validarEstado(status);
    }
}
