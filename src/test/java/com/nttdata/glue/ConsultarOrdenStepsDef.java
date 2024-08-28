package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrdenStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConsultarOrdenStepsDef {

    private final ConsultarOrdenStep consultarOrdenStep = new ConsultarOrdenStep();

    @When("consulto la orden registrada con el id {int}")
    public void consultoLaOrdenRegistradaConElId(int expectedIdOrder) {
        //ConsultarOrdenStep consultarOrdenStep = new ConsultarOrdenStep();
        consultarOrdenStep.consultarOrden(expectedIdOrder);
    }

    @Then("el status de la consulta debe ser {int}")
    public void elStatusDeLaConsultaDebeSer(int expectedStatusCode) {
        //ConsultarOrdenStep consultarOrdenStep = new ConsultarOrdenStep();
        consultarOrdenStep.validarCodigoRespuesta(expectedStatusCode);
    }

    @And("el codigo de la mascota debe ser {int}")
    public void elCodigoDeLaMascotaDebeSer(int expectedIdPet) {
        //ConsultarOrdenStep consultarOrdenStep = new ConsultarOrdenStep();
        consultarOrdenStep.validarIdPet(expectedIdPet);
    }

    @And("imprimo el detalle de la orden")
    public void imprimoElDetalleDeLaOrden() {
        consultarOrdenStep.imprimirOrden();
    }


}
