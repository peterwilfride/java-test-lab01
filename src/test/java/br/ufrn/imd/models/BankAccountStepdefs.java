package br.ufrn.imd.models;

import br.ufrn.imd.models.BankAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountStepdefs {

    private BankAccount bankAccount;
    private BankAccount bankDestiny;

    @Given("um BankAccount com saldo de R$ {double}")
    public void um_bank_account__com_saldo_de_r$(Double double1) {
        bankAccount = new BankAccount(123456, 123, double1);
    }

    @Given("um BankAccount de destino com saldo de R$ {double}")
    public void um_bank_account_de_destino_com_saldo_de_r$(Double double1) {
        bankDestiny = new BankAccount(123457, 124, double1);
    }

    @When("depositar R$ {double}")
    public void depositar_r$(Double double1) {
        bankAccount.deposit(double1);
    }

    @When("retirar R$ {double}")
    public void retirar_r$(Double double1) {
        bankAccount.withdraw(double1);
    }

    @When("tranferir R$ {double} para o BankAccount de destino")
    public void tranferir_r$_para_o_bank_account_de_destino(Double double1) {
        bankAccount.transfer(bankDestiny, double1);
    }
    @Then("o saldo do BankAccount deve ser R$ {double}")
    public void o_saldo_do_bank_account_deve_ser_r$(Double double1) {
        var saldo1 = bankAccount.getBalance();
        assertEquals(double1, saldo1);
    }
    @Then("o saldo do BankAccount de destino deve ser R$ {double}")
    public void o_saldo_do_bank_account_de_destino_deve_ser_r$(Double double1) {
        var saldo1 = bankAccount.getBalance();
        assertEquals(double1, saldo1);
    }
}
