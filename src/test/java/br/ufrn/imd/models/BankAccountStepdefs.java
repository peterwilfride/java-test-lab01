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
    public void um_bank_account_com_saldo_de_r$(Double double1) {
        bankAccount = new BankAccount(123456, 123, double1);
    }

    @When("depositar R$ {double}")
    public void depositar_r$(Double double1) {
        bankAccount.deposit(double1);
    }

    @Then("o saldo do BankAccount deve ser R$ {double}")
    public void o_saldo_deve_ser_r$(Double double1) {
        var saldo = bankAccount.getBalance();
        assertEquals(double1, saldo);
    }

    @Given("um BankAccount com saldo de R$ {double}")
    public void um_conta_de_banco__com_saldo_de_r$(Double double1) {
        bankAccount = new BankAccount(123456, 123, double1);
    }

    @When("depositar R$ {double}")
    public void retirar_r$(Double double1) {
        bankAccount.withdraw(double1);
    }

    @Then("o saldo do BankAccount deve ser R$ {double}")
    public void o_saldo_da_conta_deve_ser_r$(Double double1) {
        var saldo = bankAccount.getBalance();
        assertEquals(double1, saldo);
    }

    @Given("um BankAccount com saldo de R$ {double} e um banco destino com saldo de R$ {double}")
    public void um_bank_account_com_saldo_de_r$(Double double1, Double double2) {
        bankAccount = new BankAccount(123456, 123, double1);
        bankDestiny = new BankAccount(123457, 124, double2);
    }

    @When("transfetir R$ {double} para o banco destino")
    public void tranferir_r$(Double double1) {
        bankAccount.transfer(bankDestiny, double1);
    }

    @Then("o saldo do BankAccount deve ser R$ {double} e o saldo do BankAccount de destino deve ser R$ {double}")
    public void o_saldo_deve_ser_r$(Double double1, Double double2) {
        var saldo1 = bankAccount.getBalance();
        var saldo2 = bankDestiny.getBalance();
        assertEquals(double1, saldo1);
        assertEquals(double2, saldo2);
    }

}
